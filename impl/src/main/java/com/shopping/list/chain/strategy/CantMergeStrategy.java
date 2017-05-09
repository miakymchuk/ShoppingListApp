package com.shopping.list.chain.strategy;

import com.shopping.list.domain.Card;
import com.shopping.list.dto.CardDto;
import com.shopping.list.exception.MergeCardException;
import lombok.extern.java.Log;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Log
@Component
@Order(Ordered.LOWEST_PRECEDENCE)
public class CantMergeStrategy implements MergeStrategy {

    @Override
    public boolean apply(Card serverCard, CardDto deviceCard) {
        //TODO log all insensitive user data
        throw new MergeCardException(String.format("Merge shopping list %s serverCardID", serverCard.getId()));
    }
}
