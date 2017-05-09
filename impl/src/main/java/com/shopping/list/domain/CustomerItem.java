package com.shopping.list.domain;

import com.shopping.list.dto.CardItemActionType;
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
public class CustomerItem extends AbstractPersistentObject {

    @Column(name = "name")
    private String name;

    @Column(name = "is_marked_as_checked")
    private boolean markedAsChecked;

    @Column(name = "quantity_description")
    private CardItemActionType status;

    @Column(name = "quantity_description")
    private String quantityDescription;

    @ManyToOne
    @JoinColumn(name = "card_id", nullable = false)
    private Card card;
}
