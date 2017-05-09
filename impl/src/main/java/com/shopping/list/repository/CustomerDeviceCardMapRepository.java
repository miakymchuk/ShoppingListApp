package com.shopping.list.repository;

import com.shopping.list.domain.CustomerDeviceCardMap;
import org.springframework.data.repository.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface CustomerDeviceCardMapRepository extends Repository<CustomerDeviceCardMap, Long> {

    List<CustomerDeviceCardMap> findOwnedCardAndSharedByUserAndByDeviceId();
}
