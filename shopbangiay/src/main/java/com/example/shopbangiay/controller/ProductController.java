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

    @GetMapping
    public ResponseEntity<Page<IProductDto>> getAllCandidate(@RequestParam(name = "limit", defaultValue = "3", required = false) int limit,
                                                             @RequestParam(name = "page", defaultValue = "0", required = false) int page,
                                                             @RequestParam(name = "nameProduct", defaultValue = "", required = false) String nameProduct,
                                                             @RequestParam(name = "typeId", defaultValue = "", required = false) String typeId,
                                                             @RequestParam(name = "typeSort", defaultValue = "0", required = false) int typeSort) {

        Pageable pageable = PageRequest.of(page, limit);
        Page<IProductDto> productDtoList;

        if (typeSort == 1) {
            productDtoList = productService.findAllProductSort(pageable, nameProduct, typeId, "price", "asc");
        } else if (typeSort == 2) {
            productDtoList = productService.findAllProductSort(pageable, nameProduct, typeId, "price", "desc");
        } else if (typeSort == 3) {
            productDtoList = productService.findAllProductSort(pageable, nameProduct, typeId, "sellNumber", "asc");
        } else if (typeSort == 4) {
            productDtoList = productService.findAllProductSort(pageable, nameProduct, typeId, "sellNumber", "desc");
        } else {
            productDtoList = productService.findAllProduct(pageable, nameProduct, typeId);
        }

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

    @PatchMapping("/delete")
    public ResponseEntity<String> deleteById(@RequestParam(name = "id", defaultValue = "", required = false) Integer id) {
        productService.deleteById(id);
        return ResponseEntity.ok("Sửa thành công");
    }
}
