package com.strafeup.cashiersystemspring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "receipts")
@AllArgsConstructor
@NoArgsConstructor
public class ReceiptEntity {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private Long receiptId;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<ItemEntity> itemEntities;
    @Column
    private LocalDateTime timeOfReceipt;

}
