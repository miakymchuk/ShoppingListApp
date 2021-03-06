package com.shopping.list.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


/**
 * A map, server card id vs customer device card id.
 */
@Entity
@Table(name = "customer_device_card_map")
@Getter
@Setter
@Data
public class CustomerDeviceCardMap {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_device_card_map_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "customer_device_id")
    private CustomerDevice customerDevice;

    @ManyToOne
    @JoinColumn(name = "card_id", nullable = false)
    private Card card;

    @Column(name = "device_card_id", nullable = false)
    private Long deviceCardId;
}
