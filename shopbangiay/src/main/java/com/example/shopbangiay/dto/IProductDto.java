package com.example.shopbangiay.dto;

public interface IProductDto {
    Integer getId();
    String getName();
    Integer getNumberProduct();
    Integer getPrice();
    Integer getSellNumber();
    double getShippingCost();
    boolean getIsDeleted();
    String getTypeProduct();
    String getImage();
}
