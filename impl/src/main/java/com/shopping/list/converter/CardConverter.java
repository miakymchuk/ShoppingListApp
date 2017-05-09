package com.shopping.list.converter;

import com.shopping.list.domain.Card;
import com.shopping.list.dto.CardDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CardConverter implements Converter<Card, CardDto> {

    @Override
    public CardDto convert(Card card) {
        return null;
    }
}
