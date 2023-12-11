package com.example.shopbangiay.service;

import com.example.shopbangiay.dto.CartDto;
import com.example.shopbangiay.dto.ICartDto;
import com.example.shopbangiay.model.Cart;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ICartService {
    Page<ICartDto> showCartById(Pageable pageable, Integer id);
    List<Cart> findAllCartBy(Integer id);
    void addNumberToProductInCart(Integer id, Integer number);
    void addToCart(Integer numberProduct,Integer sizeProduct,Integer idAccount,Integer idProduct);
    Integer sumProductInCart();
    Double totalPriceProductInCart(Integer id);
    void increasingTheNumber(Integer id);
    void reduceTheNumberOf(Integer id);
    void payProduct(Integer idAccount, Double totalPrice, Integer idDetailOrderStatus);
    void deleteAfterPayment(Integer id);

}
