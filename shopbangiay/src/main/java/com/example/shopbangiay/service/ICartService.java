package com.example.shopbangiay.service;

import com.example.shopbangiay.dto.CartDto;
import com.example.shopbangiay.model.Cart;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ICartService {
    Page<Cart> showCartById(Pageable pageable,Integer id);
    void addToCart(Integer numberProduct,Integer sizeProduct,Integer idAccount,Integer idProduct);

    Integer sumProductInCart();
}
