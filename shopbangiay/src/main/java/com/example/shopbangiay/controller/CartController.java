package com.example.shopbangiay.controller;

import com.example.shopbangiay.dto.CartDto;
import com.example.shopbangiay.dto.ICartDto;
import com.example.shopbangiay.dto.IProductDetail;
import com.example.shopbangiay.dto.IProductDto;
import com.example.shopbangiay.model.Cart;
import com.example.shopbangiay.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@Controller
@CrossOrigin("*")
@RestController
@RequestMapping("/api/public/cart")
public class CartController {
    @Autowired
    private ICartService cartService;

    @GetMapping("/{id}")
    public ResponseEntity<Page<Cart>> showCartById(@RequestParam(name = "limit", defaultValue = "5", required = false) int limit,
                                                   @RequestParam(name = "page", defaultValue = "0", required = false) int page,
                                                   @PathVariable int id) {
        Pageable pageable = PageRequest.of(page, limit);
        Page<Cart> carts = cartService.showCartById(pageable, id);
        if (carts.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(carts, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<CartDto> addToCart(@RequestBody CartDto cartDto){
        cartService.addToCart(cartDto.getNumberProduct(), cartDto.getSizeProduct(), cartDto.getIdAccount(), cartDto.getIdProduct());
        if (cartService == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/sumCart")
    public ResponseEntity<Integer> sumProductInCart() {
        Integer sumCart = cartService.sumProductInCart();
        return new ResponseEntity<>(sumCart, HttpStatus.OK);
    }
}
