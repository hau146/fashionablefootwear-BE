package com.example.shopbangiay.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrderProductDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private double totalPrice;
    private int numberProduct;
    private int sizeProduct;

    @ManyToOne
    @JoinColumn(name = "id_product",referencedColumnName = "id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "id_order_product",referencedColumnName = "id")
    private OrderProduct orderProduct;
}
