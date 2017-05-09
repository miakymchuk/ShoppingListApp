package com.shopping.list.service;

import com.shopping.list.chain.MergeStrategyChainHolder;
import com.shopping.list.domain.Card;
import com.shopping.list.domain.CustomerDeviceCardMap;
import com.shopping.list.dto.CardDto;
import com.shopping.list.dto.Status;
import com.shopping.list.repository.CardRepository;
import com.shopping.list.repository.CustomerDeviceCardMapRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import static com.shopping.list.dto.Status.DELETED;

@Component
public class ShoppingListSyncService {
    @Autowired
    private CardRepository cardRepository;
    @Autowired
    private CustomerDeviceCardMapRepository customerDeviceCardMapRepository;

    //FIXME use spring converter mechanism
    @Autowired
    private Converter<Card, CardDto> convertCardToDto;
    @Autowired
    private Converter<CardDto, Card> convertDtoToCard;
    @Autowired
    private MergeStrategyChainHolder mergeStrategyChainHolder;

    @Transactional
    public Set<CardDto> getRelevantList(List<CardDto> currentDeviceList) {
        List<CustomerDeviceCardMap> serverUserCards = customerDeviceCardMapRepository
                .findOwnedCardAndSharedByUserAndByDeviceId();

        final Map <Long, Card> serverCardsMap = serverUserCards.stream()
                .collect(Collectors.toMap(CustomerDeviceCardMap::getDeviceCardId, CustomerDeviceCardMap::getCard));
        final Map<Long, CardDto> deviceCardsMap = currentDeviceList.stream()
                .collect(Collectors.toMap(CardDto::getDeviceId, Function.identity()));



        Set<Card> syncCards = serverCardsMap.entrySet().stream().map(item -> {

            CardDto deviceItem = deviceCardsMap.get(item.getKey());
            switch (deviceItem.getStatus()) {
                case SERVER:
                    //do nothing, if card device status server just keep card from server, if server has updated instance it will apply
                    break;
                case MODIFIED:
                    mergeStrategyChainHolder.execute(item.getValue(), deviceItem);
                    break;
                case DELETED:
                    item.getValue().setStatus(DELETED);
                    break;
            }

            return item;
        }).map(card -> card.getValue()).collect(Collectors.toSet());


        for (CardDto cardDto : currentDeviceList) {
            if (Status.CREATED.equals(cardDto.getStatus())) {
                syncCards.add(convertDtoToCard.convert(cardDto));
            }
        }

        return syncCards.stream().map(card -> convertCardToDto.convert(card))
                .collect(Collectors.toSet());
    }
}
