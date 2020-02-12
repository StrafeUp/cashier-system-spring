package com.strafeup.cashiersystemspring.service.impl;

import com.strafeup.cashiersystemspring.entity.ItemEntity;
import com.strafeup.cashiersystemspring.repository.ItemRepository;
import com.strafeup.cashiersystemspring.service.ItemService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ItemServiceImpl implements ItemService {
    private static final int ITEMS_PER_PAGE = 5;

    private final ItemRepository itemRepository;

    public Page<ItemEntity> findAll(int page) {
        int maxPageNumber = (int) Math.ceil(itemRepository.count() * 1.0 / ITEMS_PER_PAGE);
        if (page <= 0) {
            page = 1;
        }
        if (page >= maxPageNumber) {
            page = maxPageNumber;
        }
        return itemRepository.findAll(PageRequest.of(page-1, ITEMS_PER_PAGE));
    }
}
