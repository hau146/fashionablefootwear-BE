package com.example.shopbangiay.controller;

import com.example.shopbangiay.config.JwtTokenUtil;
import com.example.shopbangiay.dto.AccountDto;
import com.example.shopbangiay.dto.IAccountDto;
import com.example.shopbangiay.dto.IProductDetail;
import com.example.shopbangiay.model.Account;
import com.example.shopbangiay.model.JwtResponse;
import com.example.shopbangiay.service.IAccountService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/public/account")
public class AccountController {
    @Autowired
    private IAccountService accountService;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public ResponseEntity<Object> findAccountByName(@RequestBody AccountDto accountDto) {
        Account account = new Account();
        BeanUtils.copyProperties(accountDto, account);

        UserDetails userDetails = accountService.loadUserByUsername(account.getUsername());

        String jwtToken = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity
                .ok()
                .body(new JwtResponse(jwtToken));
    }

    @GetMapping("/idUser/{userName}")
    public ResponseEntity<Object> getIdAppUser(@PathVariable String userName){
        Account account = accountService.findAppUserIdByUserName(userName);
        if (account == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Không có dữ liệu!");
        }
        return ResponseEntity.ok().body(account);
    }
}
