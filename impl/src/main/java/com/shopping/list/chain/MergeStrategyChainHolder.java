package com.shopping.list.chain;


import com.shopping.list.chain.strategy.MergeStrategy;
import com.shopping.list.domain.Card;
import com.shopping.list.dto.CardDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MergeStrategyChainHolder {

    @Autowired
    private List<MergeStrategy> mergeStrategyList;

    public void execute(Card serverCard, CardDto deviceCard) {
        for (MergeStrategy strategy : mergeStrategyList) {
            if (strategy.apply(serverCard, deviceCard)) {
                break;
            }
        }
    }
}
