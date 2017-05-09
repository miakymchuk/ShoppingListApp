package com.shopping.list.chain.strategy;


import com.shopping.list.domain.Card;
import com.shopping.list.dto.CardDto;

public interface MergeStrategy {
    boolean apply(Card serverCard, CardDto deviceCard);
}
