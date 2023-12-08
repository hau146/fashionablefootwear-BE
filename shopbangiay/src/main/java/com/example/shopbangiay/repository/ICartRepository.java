package com.example.shopbangiay.repository;

import com.example.shopbangiay.model.Cart;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.awt.*;
import java.util.List;

public interface ICartRepository extends JpaRepository<Cart, Integer> {
    @Query(value = "select * from cart where id_account = :id order by id desc", nativeQuery = true)
    Page<Cart> showCartById(Pageable pageable, @Param("id") Integer id);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO `shopbangiay`.`cart` " +
            "(`number_product`, `size_product`, `id_account`, `id_product`) " +
            "VALUES (:numberProduct, :sizeProduct, :idAccount, :idProduct)",nativeQuery = true)
    void addToCart(@Param("numberProduct") Integer numberProduct,@Param("sizeProduct") Integer sizeProduct, @Param("idAccount") Integer idAccount, @Param("idProduct") Integer idProduct);

    @Query(value = "SELECT SUM(number_product) AS total_number_product\n" +
            "FROM cart;", nativeQuery = true)
    Integer sumProductInCart();
}
