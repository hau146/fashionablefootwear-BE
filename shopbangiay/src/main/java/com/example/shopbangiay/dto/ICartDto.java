package com.example.shopbangiay.dto;

import com.example.shopbangiay.model.Account;
import com.example.shopbangiay.model.Product;

public interface ICartDto {
    Integer getId();
    Integer getIdAccount();
    Integer getIdProduct();
    Integer getSizeProduct();
    Integer getNumberProduct();
    String getImage();
    String getNameProduct();
    Double getPriceProduct();
    String getTypeProduct();
}
