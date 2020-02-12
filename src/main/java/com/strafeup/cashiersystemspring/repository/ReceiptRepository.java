package com.strafeup.cashiersystemspring.repository;

import com.strafeup.cashiersystemspring.entity.ReceiptEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ReceiptRepository extends PagingAndSortingRepository<ReceiptEntity, Long> {
    Page<ReceiptEntity> findAll(Pageable pageable);
}
