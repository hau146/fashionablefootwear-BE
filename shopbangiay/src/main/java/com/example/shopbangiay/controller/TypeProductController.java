package com.example.shopbangiay.controller;

import com.example.shopbangiay.model.TypeProduct;
import com.example.shopbangiay.service.ITypeProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/public/typeProduct")
public class TypeProductController {
    @Autowired
    private ITypeProductService typeProductService;

    @GetMapping("")
    public ResponseEntity<List<TypeProduct>> findAll() {
        List<TypeProduct> typeProductList = typeProductService.findAll();
        if (typeProductList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(typeProductList, HttpStatus.OK);
        }
    }
}
