package com.shopping.list.repository;

import com.shopping.list.domain.Card;
import com.shopping.list.domain.CardHistory;
import org.springframework.data.repository.Repository;

import java.util.List;


public interface CardHistoryRepository extends Repository<CardHistory, Long> {


    CardHistory findLastByCard(Card serverCard);
}
