package com.shopping.list.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "card_history")
@Getter
@Setter
public class CardHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "card_history_id")
    private Long id;

    @Column(name ="card_action_type")
    private CardActionType cardActionType;

    @ManyToOne
    @JoinColumn(name = "card_id", referencedColumnName = "card_id",  nullable = false)
    private Card card;

    @Column(name = "date_in")
    private LocalDateTime dateIn;
}
