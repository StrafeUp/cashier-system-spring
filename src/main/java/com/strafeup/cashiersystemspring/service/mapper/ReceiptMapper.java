package com.strafeup.cashiersystemspring.service.mapper;

import com.strafeup.cashiersystemspring.domain.Item;
import com.strafeup.cashiersystemspring.domain.Receipt;
import com.strafeup.cashiersystemspring.domain.User;
import com.strafeup.cashiersystemspring.entity.ItemEntity;
import com.strafeup.cashiersystemspring.entity.ReceiptEntity;
import com.strafeup.cashiersystemspring.entity.UserEntity;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;
@Component
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ReceiptMapper implements Mapper<ReceiptEntity, Receipt> {

    private final Mapper<ItemEntity, Item> itemMapper;
    private final Mapper<UserEntity, User> userMapper;

    @Override
    public ReceiptEntity mapDomainToEntity(Receipt domain) {
        ReceiptEntity receiptEntity = new ReceiptEntity();
        receiptEntity.setId(domain.getId());
        receiptEntity.setReceiptId(domain.getReceiptId());
        receiptEntity.setStatus(domain.getStatus());
        receiptEntity.setItemEntities(domain.getItems().stream()
                .map(itemMapper::mapDomainToEntity)
                .collect(Collectors.toList()));
        receiptEntity.setUserEntity(userMapper.mapDomainToEntity(domain.getUser()));
        receiptEntity.setTimeOfReceipt(domain.getTimeOfReceipt());


        return receiptEntity;
    }

    @Override
    public Receipt mapEntityToDomain(ReceiptEntity entity) {
        return Receipt.builder()
                .id(entity.getId())
                .user(userMapper.mapEntityToDomain(entity.getUserEntity()))
                .status(entity.getStatus())
                .receiptId(entity.getReceiptId())
                .items(entity.getItemEntities().stream()
                        .map(itemMapper::mapEntityToDomain)
                        .collect(Collectors.toList()))
                .build();
    }
}
