package com.shopping.list.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * A shopping list item.
 */
@Entity
@Table(name = "customer_item")
@Getter
@Setter
public class CustomerItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_item_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "is_marked_as_checked")
    private boolean markedAsChecked;

    @Column(name = "quantity_description")
    private String quantityDescription;
}
