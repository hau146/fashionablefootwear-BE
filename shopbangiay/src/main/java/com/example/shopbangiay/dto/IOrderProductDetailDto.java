package com.example.shopbangiay.dto;

import java.time.LocalDateTime;

public interface IOrderProductDetailDto {
    Integer getId();
    Integer getNumberProduct();
    Integer getSizeProduct();
    Double getTotalPrice();
    Integer getIdAccount();
    String getImage();
    String getNameOrderStatus();
    String getName();
    LocalDateTime getDate();
}
