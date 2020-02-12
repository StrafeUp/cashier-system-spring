package com.strafeup.cashiersystemspring.service;

import com.strafeup.cashiersystemspring.entity.ItemEntity;
import org.springframework.data.domain.Page;

public interface ItemService {
    Page<ItemEntity> findAll(int page);
}
