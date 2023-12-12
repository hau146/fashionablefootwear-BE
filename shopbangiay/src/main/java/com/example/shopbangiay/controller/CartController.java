package com.example.shopbangiay.controller;

import com.example.shopbangiay.dto.*;
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
import java.util.Arrays;
import java.util.List;

@Controller
@CrossOrigin("*")
@RestController
@RequestMapping("/api/public/cart")
public class CartController {
    @Autowired
    private ICartService cartService;

    @GetMapping("/{id}")
    public ResponseEntity<Page<ICartDto>> showCartById(@RequestParam(name = "limit", defaultValue = "5", required = false) int limit,
                                                       @RequestParam(name = "page", defaultValue = "0", required = false) int page,
                                                       @PathVariable int id) {
        Pageable pageable = PageRequest.of(page, limit);
        Page<ICartDto> cartDtos = cartService.showCartById(pageable, id);
        if (cartDtos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(cartDtos, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<CartDto> addToCart(@RequestBody CartDto cartDto) {
        List<Cart> cartList = cartService.findAllCartByIdAccount(cartDto.getIdAccount());
        boolean flag = true;
        for (int i = 0; i < cartList.size(); i++) {
            if (cartDto.getIdProduct() == cartList.get(i).getProduct().getId() && cartDto.getSizeProduct() == cartList.get(i).getSizeProduct()) {
                cartService.addNumberToProductInCart(cartDto.getIdProduct(), cartDto.getNumberProduct());
                flag = false;
                break;
            }
        }
        if (flag) {
            cartService.addToCart(cartDto.getNumberProduct(), cartDto.getSizeProduct(), cartDto.getIdAccount(), cartDto.getIdProduct());
        }
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

    @PatchMapping("/increase")
    public ResponseEntity<String> increasingTheNumber(@RequestParam(name = "id", defaultValue = "", required = false) Integer id) {
        cartService.increasingTheNumber(id);
        return ResponseEntity.ok("Sửa thành công");
    }

    @PatchMapping("/reduce")
    public ResponseEntity<String> reduceTheNumberOf(@RequestParam(name = "id", defaultValue = "", required = false) Integer id) {
        cartService.reduceTheNumberOf(id);
        return ResponseEntity.ok("Sửa thành công");
    }

    @PatchMapping("/selectPay")
    public ResponseEntity<String> selectPay(@RequestParam(name = "id", defaultValue = "", required = false) Integer id) {
        Cart cart = cartService.findCartById(id);
        if (cart.isSelectPay()) {
            cartService.selectPay(id, 0);
            return ResponseEntity.status(HttpStatus.CREATED).body("");
        } else {
            cartService.selectPay(id, 1);
            return ResponseEntity.ok("Sửa thành công");
        }
    }

    @PostMapping("/payCart")
    public ResponseEntity<String> payProduct(@RequestBody PayDto payDto) {
        cartService.payProduct(payDto.getIdAccount(), payDto.getTotalPrice(), payDto.getIdDetailOrderStatus());
        return ResponseEntity.ok("Sửa thành công");
    }

    @DeleteMapping("/deleteAfterPayment/{id}")
    public ResponseEntity<String> deleteAfterPayment(@PathVariable Integer id) {
        cartService.deleteAfterPayment(id);
        return ResponseEntity.ok("Xóa thành công");
    }

    @DeleteMapping("/deleteProductInCart/{id}")
    public ResponseEntity<String> deleteProductInCart(@PathVariable Integer id) {
        cartService.deleteProductInCart(id);
        return ResponseEntity.ok("Xóa thành công");
    }

    @GetMapping("/totalPrice/{id}")
    public ResponseEntity<Double> totalPrice(@PathVariable int id) {
        Double totalPrice = cartService.totalPriceProductInCart(id);
        return new ResponseEntity<>(totalPrice, HttpStatus.OK);
    }

}
