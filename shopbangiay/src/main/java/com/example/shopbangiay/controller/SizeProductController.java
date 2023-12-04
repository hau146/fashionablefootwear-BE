package com.example.shopbangiay.controller;

import com.example.shopbangiay.dto.ISizeDto;
import com.example.shopbangiay.model.TypeProduct;
import com.example.shopbangiay.service.ISizeProductService;
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
@RequestMapping("/api/public/sizeProduct")
public class SizeProductController {
    @Autowired
    private ISizeProductService sizeProductService;

    @GetMapping("")
    public ResponseEntity<List<ISizeDto>> findAll() {
        List<ISizeDto> sizeDtos = sizeProductService.findAllSize();
        if (sizeDtos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(sizeDtos, HttpStatus.OK);
        }
    }
}
