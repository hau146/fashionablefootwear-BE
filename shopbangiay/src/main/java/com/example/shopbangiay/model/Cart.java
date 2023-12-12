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
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int numberProduct;
    private int sizeProduct;
    @Column(name = "select_pay",columnDefinition = "bit(1) default 0")
    private boolean selectPay;

    @ManyToOne
    @JoinColumn(name = "id_account",referencedColumnName = "id")
    private Account account;

    @ManyToOne
    @JoinColumn(name = "id_product",referencedColumnName = "id")
    private Product product;
}
