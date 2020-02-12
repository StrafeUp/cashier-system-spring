package com.strafeup.cashiersystemspring.service.impl;

import com.strafeup.cashiersystemspring.entity.ItemEntity;
import com.strafeup.cashiersystemspring.repository.ItemRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.domain.Pageable;

import java.util.Collections;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ItemServiceImplTest {
    private static final ItemEntity ITEM_ENTITY = new ItemEntity();

    @Mock
    private ItemRepository itemRepository;

    @InjectMocks
    private ItemServiceImpl itemService;

    @Test
    public void findAllShouldReturnItems() {
        when(itemRepository.findAll(any(Pageable.class)).getContent())
                .thenReturn(Collections.singletonList(ITEM_ENTITY));
        itemService.findAll(1);
        verify(itemRepository);
    }
}