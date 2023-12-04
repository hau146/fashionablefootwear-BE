package com.example.shopbangiay.controller;

import com.example.shopbangiay.dto.IImageDto;
import com.example.shopbangiay.service.IImageProductService;
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
@RequestMapping("/api/public/imageProduct")
public class ImageProductController {
    @Autowired
    private IImageProductService imageProductService;

    @GetMapping("")
    public ResponseEntity<List<IImageDto>> findAll() {
        List<IImageDto> iImageDtos = imageProductService.findAllImage();
        if (iImageDtos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(iImageDtos, HttpStatus.OK);
        }
    }
}
