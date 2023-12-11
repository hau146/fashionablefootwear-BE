package com.example.shopbangiay.dto;

import com.example.shopbangiay.model.Account;
import com.example.shopbangiay.model.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class getCartDto {
    private Integer id;
    private Account idAccount;
    private Product idProduct;
    private Integer sizeProduct;
    private Integer numberProduct;
    private String image;
}
