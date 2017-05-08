package com.shopping.list.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * A customer device.
 */

@Entity
@Table(name = "customer_device")
@Getter
@Setter
public class CustomerDevice {

    @Id
    @Column(name = "customer_device_id")
    private String uniqueDeviceId;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
    private User user;
}
