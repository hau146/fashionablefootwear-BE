package com.example.shopbangiay.service;

import com.example.shopbangiay.dto.JwtResponseUserDetail;
import com.example.shopbangiay.model.Account;
import com.example.shopbangiay.model.UserRole;
import com.example.shopbangiay.repository.IAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.persistence.Access;
import java.util.ArrayList;
import java.util.List;

@Service
public class AccountService implements IAccountService{
    @Autowired
    private IAccountRepository accountRepository;

    @Override
    public Account findAccountByName(String username) {
        return null;
    }

    @Override
    public Account findAppUserIdByUserName(String userName) {
        return accountRepository.findIdByUserName(userName);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountRepository.findAccountByName(username);
        if (account == null) {
            throw new UsernameNotFoundException("User name or password is wrong");
        }

        List<GrantedAuthority> grantList = new ArrayList<>();
        for (UserRole userRole : account.getUserRoleSet()) {
            grantList.add(new SimpleGrantedAuthority(userRole.getRole().getName()));
        }
        UserDetails userDetails = new JwtResponseUserDetail(
                account.getUsername(),
                account.getPassword(),
                account.getIsDeleted(),
                grantList);
        return userDetails;
    }
//    @Override
//    public UserDetails findAccountByName(String username) throws UsernameNotFoundException {
//        Account account = accountRepository.findAccountByName(username);
//        if (account == null) {
//            throw new UsernameNotFoundException("User name or password is wrong");
//        }
//
//        List<GrantedAuthority> grantList = new ArrayList<>();
//        for (UserRole userRole : account.getUserRoleSet()) {
//            grantList.add(new SimpleGrantedAuthority(userRole.getRole().getName()));
//        }
//        UserDetails userDetails = new JwtResponseUserDetail(
//                account.getUserName(),
//                account.getPass(),
//                account.getFlagOnline(),
//                grantList);
//        appUserRepository.updateAppUserIsOnline(account);
//        return userDetails;
//    }
}
