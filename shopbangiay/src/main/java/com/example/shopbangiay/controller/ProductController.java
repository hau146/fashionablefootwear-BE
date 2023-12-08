package com.example.shopbangiay.controller;

import com.example.shopbangiay.dto.IImageDto;
import com.example.shopbangiay.dto.IProductDetail;
import com.example.shopbangiay.dto.IProductDto;
import com.example.shopbangiay.dto.ISizeDto;
import com.example.shopbangiay.model.TypeProduct;
import com.example.shopbangiay.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin("*")
@RestController
@RequestMapping("/api/public/product")
public class ProductController {
    @Autowired
    public IProductService productService;

//    @GetMapping("")
//    public ResponseEntity<List<IProductDto>> findAll() {
//        List<IProductDto> productDtoList = productService.findAllProduct();
//        if (productDtoList.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        } else {
//            return new ResponseEntity<>(productDtoList, HttpStatus.OK);
//        }
//    }

    @GetMapping
    public ResponseEntity<Page<IProductDto>> getAllCandidate(@RequestParam(name = "limit", defaultValue = "3", required = false) int limit,
                                                             @RequestParam(name = "page", defaultValue = "0", required = false) int page,
                                                             @RequestParam(name = "nameProduct", defaultValue = "", required = false) String nameProduct,
                                                             @RequestParam(name = "typeId", defaultValue = "", required = false) String typeId) {

        Pageable pageable = PageRequest.of(page, limit);
        Page<IProductDto> productDtoList = productService.findAllProduct(pageable, nameProduct, typeId);
        if (productDtoList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(productDtoList, HttpStatus.OK);
    }

    @GetMapping("/detailProduct/{id}")
    public ResponseEntity<IProductDetail> findByAllIdProduct(@PathVariable int id) {
        IProductDetail productDetail = productService.findByAllIdProduct(id);
        return new ResponseEntity<>(productDetail, HttpStatus.OK);
    }

    @GetMapping("/detailSizeProduct/{id}")
    public ResponseEntity<List<ISizeDto>> findBySizeIdProduct(@PathVariable int id) {
        List<ISizeDto> sizeDtoList = productService.findBySizeIdProduct(id);
        if (sizeDtoList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(sizeDtoList, HttpStatus.OK);
    }

    @GetMapping("/detailImageProduct/{id}")
    public ResponseEntity<List<IImageDto>> findByImageIdProduct(@PathVariable int id) {
        List<IImageDto> iImageDtoList = productService.findByImageIdProduct(id);
        if (iImageDtoList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(iImageDtoList, HttpStatus.OK);
    }
}
