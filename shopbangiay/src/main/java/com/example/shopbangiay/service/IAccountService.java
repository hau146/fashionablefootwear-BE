package com.example.shopbangiay.service;

import com.example.shopbangiay.model.Account;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IAccountService extends UserDetailsService {
    Account findAccountByName(String username);
    Account findAppUserIdByUserName(String userName);

}
