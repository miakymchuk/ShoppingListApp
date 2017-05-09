package com.shopping.list.repository;

import com.shopping.list.domain.Card;
import com.shopping.list.domain.CustomerDeviceCardItemMap;
import org.springframework.data.repository.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface CustomerDeviceCardItemMapRepository extends Repository<CustomerDeviceCardItemMap, Long> {

    List<CustomerDeviceCardItemMap> findCardItemsByCardAndDeviceId(Card card, String deviceId);
}

