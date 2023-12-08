package com.example.shopbangiay.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class CartDto {
    private Integer idAccount;
    private Integer idProduct;
    private Integer sizeProduct;
    private Integer numberProduct;
}
