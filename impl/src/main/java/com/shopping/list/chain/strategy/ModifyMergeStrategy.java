package com.shopping.list.chain.strategy;


import com.shopping.list.domain.Card;
import com.shopping.list.domain.CardHistory;
import com.shopping.list.domain.CustomerDeviceCardItemMap;
import com.shopping.list.domain.CustomerItem;
import com.shopping.list.dto.CardDto;
import com.shopping.list.dto.CardItemActionType;
import com.shopping.list.dto.Item;
import com.shopping.list.repository.CardHistoryRepository;
import com.shopping.list.repository.CustomerDeviceCardItemMapRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class ModifyMergeStrategy implements MergeStrategy{
    @Autowired
    private CustomerDeviceCardItemMapRepository cardItemMapRepository;
    @Autowired
    private Converter<Item, CustomerItem> cardDtoConverter;
    @Autowired
    private CardHistoryRepository cardHistoryRepository;

    @Override
    public boolean apply(Card serverCard, CardDto deviceCard) {
        CardHistory serverHistory = cardHistoryRepository.findLastByCard(serverCard);
        // not care if modification will done in same time

        Map<Long, Item> deviceShoppingMap = deviceCard.getShoppingList().stream()
                .collect(Collectors.toMap(Item::getDeviceId, Function.identity()));

        //TODO device id id should be at request application context
        String deviceID = "deviceID";

        //FIXME
        final Map <String, Long> serverCardItemsMap = cardItemMapRepository
                .findCardItemsByCardAndDeviceId(serverCard, deviceID).stream()
                .collect(Collectors.toMap(CustomerItem::getId, CustomerDeviceCardItemMap::getDeviceCardId));

        //isAfter no need modification will apply modification from server
        if (serverHistory.getDateIn().isBefore(deviceCard.getLastDataChange())) {

            for (CustomerItem serverItem : serverCard.getShoppingList()) {
                Item deviceItem = deviceShoppingMap.get(serverCardItemsMap.get(serverItem.getId()));
                //Update
                serverItem.setName(deviceItem.getName());
                serverItem.setMarkedAsChecked(deviceItem.isMarkedAsChecked());
                serverItem.setQuantityDescription(deviceItem.getQuantityDescription());
                serverItem.setStatus(CardItemActionType.SERVER);
            }

        }
        //Add new shopping list item from device
        deviceCard.getShoppingList().stream()
                .filter(deviceItem -> CardItemActionType.CREATE.equals(deviceItem.getStatus()))
                .forEach(deviceItem -> serverCard.getShoppingList().add(cardDtoConverter.convert(deviceItem)));

        return true;
    }
}
