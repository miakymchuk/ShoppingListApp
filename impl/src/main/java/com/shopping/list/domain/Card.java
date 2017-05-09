package com.shopping.list.domain;

import com.shopping.list.dto.Status;
import lombok.Data;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

/**
 * A shopping list.
 */
@Entity
@Table(name = "card")
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Data
public class Card extends AbstractPersistentObject {

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "owner", nullable = false)
    private User owner;

    @Column(name = "card_status")
    private Status status;

    @OneToMany(mappedBy = "card_id")
    private Set<CustomerItem> shoppingList;

    @OneToMany
    @JoinTable(name = "shared_card_user", joinColumns = @JoinColumn(name = "card_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> allowedUsers;

}
