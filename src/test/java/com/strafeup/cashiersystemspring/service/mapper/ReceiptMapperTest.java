package com.strafeup.cashiersystemspring.service.mapper;


import com.strafeup.cashiersystemspring.domain.Item;
import com.strafeup.cashiersystemspring.domain.Receipt;
import com.strafeup.cashiersystemspring.domain.User;
import com.strafeup.cashiersystemspring.entity.ItemEntity;
import com.strafeup.cashiersystemspring.entity.ReceiptEntity;
import com.strafeup.cashiersystemspring.entity.UserEntity;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Collections;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ReceiptMapperTest {
    private static final Receipt RECEIPT = Receipt.builder().build();
    private static final ReceiptEntity RECEIPT_ENTITY = new ReceiptEntity();

    private static final Item ITEM = Item.builder().build();
    private static final ItemEntity ITEM_ENTITY = new ItemEntity();

    private static final User USER = User.builder().build();
    private static final UserEntity USER_ENTITY = new UserEntity();

    @Mock
    private Mapper<ItemEntity, Item> itemMapper;
    @Mock
    private Mapper<UserEntity, User> userMapper;

    @InjectMocks
    private ReceiptMapper receiptMapper;

    @Test
    public void mapDomainToEntityShouldReturnReceiptWithValidItemList() {
        Receipt receipt = Receipt.builder()
                .id(1L)
                .items(Collections.singletonList(itemMapper.mapEntityToDomain(new ItemEntity())))
                .build();

        ReceiptEntity receiptEntity = receiptMapper.mapDomainToEntity(receipt);
        Assert.assertEquals(1, receiptEntity.getItemEntities().size());
    }

    @Test
    public void mapEntityToDomainShouldReturnReceiptWithValidItemList() {
        ReceiptEntity receiptEntity = new ReceiptEntity();
        receiptEntity.setId(1L);
        receiptEntity.setItemEntities(Collections.singletonList(new ItemEntity()));
        when(itemMapper.mapEntityToDomain(any(ItemEntity.class))).thenReturn(ITEM);
        Receipt receipt = receiptMapper.mapEntityToDomain(receiptEntity);
        Assert.assertEquals(1, receipt.getItems().size());
    }
}