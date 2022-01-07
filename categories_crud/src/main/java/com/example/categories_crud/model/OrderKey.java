package com.example.categories_crud.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class OrderKey implements Serializable {
    @Column(name = "shipping_unit_id")
    private int shipping_unit_id;
}
