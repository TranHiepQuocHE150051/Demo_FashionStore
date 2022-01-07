package com.example.categories_crud.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Table(name = "orders")
@Entity
@Data
public class Orders implements Serializable {
    @EmbeddedId
    private OrderKey id;
    @Column
    private int store_id;
    @Column
    private int customer_id;
    @Column
    private String Receiver_name;
    @Column
    private int phone;
    @Column
    private String address;
    @Column
    private int promotion_id;
    @ManyToOne
    @MapsId("shipping_unit_id")
    @JoinColumn(name = "shipping_unit_id")
    private ShippingUnits shipping_unit;
    @Column
    private double price ;
    @Column
    private int payment_method;
    @Column
    private int status;
    @Column
    private int payment_status;
    @Column
    @CreationTimestamp
    private Timestamp created_at;
    @Column
    @UpdateTimestamp
    private Timestamp updated_at;
}
