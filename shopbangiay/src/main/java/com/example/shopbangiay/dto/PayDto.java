package com.example.shopbangiay.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PayDto {
    private Integer idAccount;
    private Double totalPrice;
    private Integer idDetailOrderStatus;
}
