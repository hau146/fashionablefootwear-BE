package com.example.shopbangiay.dto;

public interface IProductDetail {
    Integer getId();
    String getName();
    Integer getNumberProduct();
    Integer getPrice();
    Integer getSellNumber();
    double getShippingCost();
    boolean getIsDeleted();
    String getTypeProduct();
}
