package com.example.shopbangiay.repository;

import com.example.shopbangiay.dto.IOrderProductDetailDto;
import com.example.shopbangiay.model.OrderProductDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface IOrderProductDetailRepository extends JpaRepository<OrderProductDetail, Integer> {
    @Query(value = "SELECT \n" +
            "    order_product_detail.id as id,\n" +
            "    order_product_detail.number_product as numberProduct,\n" +
            "    order_product_detail.size_product as sizeProduct,\n" +
            "    order_product_detail.total_price as totalPrice,\n" +
            "    order_product.id_account, \n" +
            "    MIN(image_product.image) as image,\n" +
            "    MIN(detail_order_status.name_order_status) as nameOrderStatus,\n" +
            "    product.`name` as `name`,\n" +
            "    order_product.order_date as date\n" +
            "FROM order_product\n" +
            "LEFT JOIN order_product_detail ON order_product.id = order_product_detail.id_order_product\n" +
            "LEFT JOIN product ON order_product_detail.id_product = product.id\n" +
            "LEFT JOIN image_product ON product.id = image_product.id_product\n" +
            "LEFT JOIN order_status ON product.id = order_status.id_product\n" +
            "LEFT JOIN detail_order_status ON order_status.id_detail_order_status = detail_order_status.id\n" +
            "WHERE order_product.id_account = :id\n" +
            "GROUP BY order_product.id_account, order_product_detail.id, order_product.order_date " +
            "ORDER BY order_product_detail.id desc", nativeQuery = true)
    Page<IOrderProductDetailDto> findAllById(Pageable pageable, @Param("id") Integer id);
    @Query(value = "SELECT SUM(total_price) AS total_price_sum\n" +
            "FROM order_product\n" +
            "WHERE id_account = :id", nativeQuery = true)
    Double sumTotalPriceById(@Param("id") Integer id);

    @Transactional
    @Modifying
    @Query(value = "UPDATE account SET id_rank = :number WHERE id = :id", nativeQuery = true)
    void updateRankAccount(@Param("id") Integer id, @Param("number") Integer number);
}
