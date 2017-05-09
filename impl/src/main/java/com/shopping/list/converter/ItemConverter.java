package com.shopping.list.converter;

import com.shopping.list.domain.CustomerItem;
import com.shopping.list.dto.Item;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ItemConverter implements Converter<Item, CustomerItem> {
    @Override
    public CustomerItem convert(Item cardDto) {
        return null;
    }
}
