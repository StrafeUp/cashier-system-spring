package com.strafeup.cashiersystemspring.service.mapper;

import com.strafeup.cashiersystemspring.domain.Item;
import com.strafeup.cashiersystemspring.entity.ItemEntity;
import org.springframework.stereotype.Component;

@Component
public class ItemMapper implements Mapper<ItemEntity, Item> {
    @Override
    public ItemEntity mapDomainToEntity(Item domain) {
        ItemEntity itemEntity = new ItemEntity();
        itemEntity.setId(domain.getId());
        itemEntity.setName(domain.getName());
        itemEntity.setQuantity(domain.getQuantity());
        itemEntity.setWeight(domain.getWeight());
        return itemEntity;
    }

    @Override
    public Item mapEntityToDomain(ItemEntity entity) {
        return Item.builder()
                .id(entity.getId())
                .name(entity.getName())
                .quantity(entity.getQuantity())
                .weight(entity.getWeight())
                .build();
    }
}
