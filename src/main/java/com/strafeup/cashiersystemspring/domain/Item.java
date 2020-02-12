package com.strafeup.cashiersystemspring.domain;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Builder
public class Item {
    @NotNull
    private Long id;
    @NotEmpty
    private String name;
    @Min(0)
    private double weight;
    @Min(0)
    private int quantity;
}
