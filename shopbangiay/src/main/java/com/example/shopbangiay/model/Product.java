package com.example.shopbangiay.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private double price;
    private int numberProduct;
    private int sellNumber;
    @Column(name = "status_product",columnDefinition = "bit(1) default 0")
    private boolean statusProduct;
    private double shippingCost;

    @Column(name = "is_deleted",columnDefinition = "bit(1) default 0")
    private Boolean isDeleted;

    @ManyToOne
    @JoinColumn(name = "id_type_product",referencedColumnName = "id")
    private TypeProduct typeProduct;

    @OneToMany(mappedBy = "product")
    @JsonBackReference
    private Set<Cart> cartSet;

    @OneToMany(mappedBy = "product")
    @JsonBackReference
    private Set<ImageProduct> imageProductSet;

    @OneToMany(mappedBy = "product")
    @JsonBackReference
    private Set<OrderStatus> orderStatusSet;

    @OneToMany(mappedBy = "product")
    @JsonBackReference
    private Set<OrderProductDetail> orderProductDetailSet;

}
