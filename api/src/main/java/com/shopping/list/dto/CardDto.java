package com.shopping.list.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;

@Data
public class CardDto {

    private Long deviceId;

    private String name;

    private Status status;

    private String ownerId;

    private LocalDateTime lastDataChange;

    private Set<Item> shoppingList;
}
