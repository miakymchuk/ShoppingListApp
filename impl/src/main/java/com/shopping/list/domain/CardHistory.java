package com.shopping.list.domain;

import com.shopping.list.dto.CardItemActionType;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "card_history")
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Getter
@Setter
public class CardHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "card_history_id")
    private Long id;

    @Column(name ="card_action_type")
    private CardItemActionType cardItemActionType;

    @ManyToOne
    @JoinColumn(name = "card_id", nullable = false)
    private Card card;

    @Column(name = "date_in")
    private LocalDateTime dateIn;
}
