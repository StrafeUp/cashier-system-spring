package com.strafeup.cashiersystemspring.repository;

import com.strafeup.cashiersystemspring.entity.ItemEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ItemRepository extends PagingAndSortingRepository<ItemEntity, Long> {
    Page<ItemEntity> findAll(Pageable pageable);
}
