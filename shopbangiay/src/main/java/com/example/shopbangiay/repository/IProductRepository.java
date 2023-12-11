package com.example.shopbangiay.repository;

import com.example.shopbangiay.dto.IImageDto;
import com.example.shopbangiay.dto.IProductDetail;
import com.example.shopbangiay.dto.IProductDto;
import com.example.shopbangiay.dto.ISizeDto;
import com.example.shopbangiay.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface IProductRepository extends JpaRepository<Product, Integer> {
    @Query(value = "select product.id as id, product.name as `name`, product.number_product as numberProduct, product.price as price,\n" +
            "    product.sell_number as sellNumber, product.shipping_cost as shippingCost, product.is_deleted as isDeleted,\n" +
            "    type_product.name as typeProduct,\n" +
            "    MIN(image_product.image) as image\n" +
            "    from product left join type_product on product.id_type_product = type_product.id\n" +
            "    left join image_product on product.id = image_product.id_product\n" +
            "    where product.name like :nameProduct and type_product.id like :typeId and product.is_deleted = 0\n" +
            "    group by product.id", nativeQuery = true)
    Page<IProductDto> findAllProduct(Pageable pageable, @Param("nameProduct") String nameProduct, @Param("typeId") String typeId);

    @Query(value = "select product.id as id, product.name as `name`, product.number_product as numberProduct, product.price as price,\n" +
            "product.sell_number as sellNumber, product.shipping_cost as shippingCost, product.is_deleted as isDeleted,\n" +
            "type_product.name as typeProduct\n" +
            "from product left join type_product on product.id_type_product = type_product.id\n" +
            "where product.is_deleted = 0 and product.id = :id", nativeQuery = true)
    IProductDetail findByAllIdProduct(@Param("id") Integer id);


    @Query(value = "select product.id as idProduct, size.size_number as sizeNumber\n" +
            "from size join size_detail on size.id = size_detail.id_size\n" +
            "join product on size_detail.id_product = product.id\n" +
            "where product.id = :id", nativeQuery = true)
    List<ISizeDto> findBySizeIdProduct(@Param("id") Integer id);

    @Query(value = "select product.id as id, image_product.image as image\n" +
            "from product join image_product on product.id = image_product.id_product\n" +
            "where product.id = :id", nativeQuery = true)
    List<IImageDto> findByImageIdProduct(@Param("id") Integer id);

    @Transactional
    @Modifying
    @Query(value = "UPDATE product SET is_deleted = 1 WHERE id = :id", nativeQuery = true)
    void deleteById(@Param("id") Integer id);
}
