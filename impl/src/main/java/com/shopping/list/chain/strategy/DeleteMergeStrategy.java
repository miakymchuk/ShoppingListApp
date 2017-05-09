package com.shopping.list.chain.strategy;

import com.shopping.list.domain.Card;
import com.shopping.list.dto.CardDto;
import com.shopping.list.dto.Status;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class DeleteMergeStrategy implements MergeStrategy {

    @Override
    public boolean apply(Card serverCard, CardDto deviceCard) {
        if (Status.DELETED.equals(serverCard.getStatus())) {
            serverCard.setStatus(Status.DELETED);
            return true;
        }
        return false;
    }

}
