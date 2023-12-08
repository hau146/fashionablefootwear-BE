package com.example.shopbangiay.service;

import com.example.shopbangiay.dto.CartDto;
import com.example.shopbangiay.model.Cart;
import com.example.shopbangiay.repository.ICartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService implements ICartService{
    @Autowired
    private ICartRepository cartRepository;

    @Override
    public Page<Cart> showCartById(Pageable pageable, Integer id) {
        return cartRepository.showCartById(pageable, id);
    }


    @Override
    public void addToCart(Integer numberProduct, Integer sizeProduct, Integer idAccount, Integer idProduct) {
        cartRepository.addToCart(numberProduct,sizeProduct,idAccount,idProduct);
    }

    @Override
    public Integer sumProductInCart() {
        return cartRepository.sumProductInCart();
    }
}
