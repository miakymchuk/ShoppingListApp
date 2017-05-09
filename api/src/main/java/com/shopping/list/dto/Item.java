package com.shopping.list.dto;


import lombok.Data;

@Data
public class Item {

    private Long deviceId;

    private String name;

    private CardItemActionType status;

    private boolean markedAsChecked;

    private String quantityDescription;
}
