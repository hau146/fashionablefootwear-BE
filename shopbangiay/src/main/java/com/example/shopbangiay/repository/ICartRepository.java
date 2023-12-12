package com.example.shopbangiay.repository;

import com.example.shopbangiay.dto.ICartDto;
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

    @Query(value = "SELECT \n" +
            "  cart.id as id, \n" +
            "  cart.number_product as numberProduct,\n" +
            "  cart.size_product as sizeProduct,\n" +
            "  cart.id_account as idAccount, \n" +
            "  cart.id_product as idProduct, \n" +
            "  product.`name` as nameProduct, \n" +
            "  product.price as priceProduct,\n" +
            "  type_product.`name` as typeProduct,\n" +
            "  MIN(image_product.image) as image\n" +
            "FROM \n" +
            "  cart \n" +
            "  LEFT JOIN product ON cart.id_product = product.id \n" +
            "  LEFT JOIN type_product on product.id_type_product = type_product.id\n" +
            "  LEFT JOIN image_product ON product.id = image_product.id_product \n" +
            "WHERE \n" +
            "  cart.id_account = :id\n" +
            "GROUP BY\n" +
            "  cart.id,\n" +
            "  cart.number_product, \n" +
            "  cart.size_product, \n" +
            "  cart.id_account, \n" +
            "  cart.id_product, \n" +
            "  product.`name`, \n" +
            "  product.price,\n" +
            "  type_product.`name`\n" +
            "order by cart.id desc", nativeQuery = true)
    Page<ICartDto> showCartById(Pageable pageable, @Param("id") Integer id);
    @Query(value = "SELECT * FROM shopbangiay.cart where id = :id", nativeQuery = true)
    Cart findCartById(@Param("id") Integer id);


    @Query(value = "SELECT * FROM shopbangiay.cart where id_account = :id", nativeQuery = true)
    List<Cart> findAllCartByIdAccount(Integer id);
    @Transactional
    @Modifying
    @Query(value = "UPDATE cart SET number_product = (number_product + :number) WHERE id_product = :id", nativeQuery = true)
    void addNumberToProductInCart(@Param("id") Integer id, Integer number);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO `shopbangiay`.`cart` " +
            "(`number_product`, `size_product`, `id_account`, `id_product`) " +
            "VALUES (:numberProduct, :sizeProduct, :idAccount, :idProduct)", nativeQuery = true)
    void addToCart(@Param("numberProduct") Integer numberProduct, @Param("sizeProduct") Integer sizeProduct, @Param("idAccount") Integer idAccount, @Param("idProduct") Integer idProduct);

    @Query(value = "SELECT SUM(number_product) AS total_number_product\n" +
            "FROM cart;", nativeQuery = true)
    Integer sumProductInCart();

    @Query(value = "SELECT SUM(product.price * cart.number_product) AS total_price\n" +
            "FROM cart\n" +
            "JOIN product ON cart.id_product = product.id\n" +
            "WHERE id_account = :id", nativeQuery = true)
    Double totalPriceProductInCart(@Param("id") Integer id);

    @Transactional
    @Modifying
    @Query(value = "UPDATE cart SET number_product = (number_product+1) WHERE id = :id", nativeQuery = true)
    void increasingTheNumber(@Param("id") Integer id);

    @Transactional
    @Modifying
    @Query(value = "UPDATE cart SET number_product = (number_product-1) WHERE id = :id", nativeQuery = true)
    void reduceTheNumberOf(@Param("id") Integer id);

    @Transactional
    @Modifying
    @Query(value = "call InsertOrderProductAndDetailAndStatus(:idAccount, :totalPrice, :idDetailOrderStatus)", nativeQuery = true)
    void payProduct(@Param("idAccount") Integer idAccount, @Param("totalPrice") Double totalPrice, @Param("idDetailOrderStatus") Integer idDetailOrderStatus);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM cart WHERE id_account = :id AND select_pay = 1", nativeQuery = true)
    void deleteAfterPayment(@Param("id") Integer id);

    @Transactional
    @Modifying
    @Query(value = "UPDATE cart SET select_pay = :numberSelect WHERE id = :id", nativeQuery = true)
    void selectPay(@Param("id") Integer id, @Param("numberSelect") Integer numberSelect);
}
