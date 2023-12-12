package com.example.shopbangiay.service;

import com.example.shopbangiay.dto.CartDto;
import com.example.shopbangiay.dto.ICartDto;
import com.example.shopbangiay.model.Cart;
import com.example.shopbangiay.repository.ICartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService implements ICartService {
    @Autowired
    private ICartRepository cartRepository;

    @Override
    public Page<ICartDto> showCartById(Pageable pageable, Integer id) {
        return cartRepository.showCartById(pageable, id);
    }

    @Override
    public Cart findCartById(Integer id) {
        return cartRepository.findCartById(id);
    }

    @Override
    public List<Cart> findAllCartByIdAccount(Integer id) {
        return cartRepository.findAllCartByIdAccount(id);
    }

    @Override
    public void addNumberToProductInCart(Integer id, Integer number) {
        cartRepository.addNumberToProductInCart(id, number);
    }


    @Override
    public void addToCart(Integer numberProduct, Integer sizeProduct, Integer idAccount, Integer idProduct) {
        cartRepository.addToCart(numberProduct, sizeProduct, idAccount, idProduct);
    }

    @Override
    public Integer sumProductInCart() {
        return cartRepository.sumProductInCart();
    }

    @Override
    public Double totalPriceProductInCart(Integer id) {
        return cartRepository.totalPriceProductInCart(id);
    }

    @Override
    public void increasingTheNumber(Integer id) {
        cartRepository.increasingTheNumber(id);
    }

    @Override
    public void reduceTheNumberOf(Integer id) {
        cartRepository.reduceTheNumberOf(id);
    }

    @Override
    public void payProduct(Integer idAccount, Double totalPrice, Integer idDetailOrderStatus) {
        cartRepository.payProduct(idAccount, totalPrice, idDetailOrderStatus);
    }

    @Override
    public void deleteAfterPayment(Integer id) {
        cartRepository.deleteAfterPayment(id);
    }

    @Override
    public void deleteProductInCart(Integer id) {
        Cart cart = cartRepository.findCartById(id);
        cartRepository.delete(cart);
    }

    @Override
    public void selectPay(Integer id, Integer numberSelect) {
        cartRepository.selectPay(id, numberSelect);
    }
}
