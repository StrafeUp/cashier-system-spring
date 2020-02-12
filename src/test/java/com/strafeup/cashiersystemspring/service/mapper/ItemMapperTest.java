package com.strafeup.cashiersystemspring.service.mapper;

import com.strafeup.cashiersystemspring.domain.Item;
import com.strafeup.cashiersystemspring.entity.ItemEntity;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

@RunWith(BlockJUnit4ClassRunner.class)
public class ItemMapperTest {

    private Mapper<ItemEntity, Item> mapper = new ItemMapper();

    @Test
    public void mapDomainToEntityShouldReturnItemWithValidName() {
        Item item = Item.builder()
                .id(1L)
                .name("Kumquat")
                .weight(100)
                .quantity(1)
                .build();
        ItemEntity itemEntity = mapper.mapDomainToEntity(item);
        Assert.assertEquals("Kumquat", itemEntity.getName());
    }

    @Test
    public void mapEntityToDomainShouldReturnItemWithValidName() {
        ItemEntity itemEntity = new ItemEntity();
        itemEntity.setId(1L);
        itemEntity.setName("Kumquat");
        itemEntity.setWeight(100);
        itemEntity.setQuantity(1);

        Item item = mapper.mapEntityToDomain(itemEntity);
        Assert.assertEquals("Kumquat", item.getName());
    }
}