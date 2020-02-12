package com.strafeup.cashiersystemspring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "items")
@AllArgsConstructor
@NoArgsConstructor
public class ItemEntity {

    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String name;
    @Column
    private double weight;
    @Column
    private int quantity;

}