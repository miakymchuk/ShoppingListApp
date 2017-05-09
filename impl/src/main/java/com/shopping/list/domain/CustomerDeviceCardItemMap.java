package com.shopping.list.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "customer_device_card_item_map")
public class CustomerDeviceCardItemMap {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_device_card_item_map_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_device_id")
    private CustomerDevice customerDevice;

    @ManyToOne
    @JoinColumn(name = "card_id", nullable = false)
    private Card card;

    @ManyToOne
    @JoinColumn(name = "card_item_id", nullable = false)
    private CustomerItem customerItem;

    @Column(name = "device_card_item_id", nullable = false)
    private Long deviceCardId;
}
