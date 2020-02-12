package com.strafeup.cashiersystemspring.domain;

import com.strafeup.cashiersystemspring.entity.Status;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class Receipt {
    @NotNull
    private Long id;
    @NotNull
    private Long receiptId;
    @NotNull
    private Status status;
    @NotNull
    private User user;
    @NotEmpty
    private List<Item> items;
    @NotNull
    private LocalDateTime timeOfReceipt;
}
