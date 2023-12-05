package com.example.shopbangiay.dto;

import com.example.shopbangiay.model.UserRole;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AccountDto {
    private String username;
    private String password;
}
