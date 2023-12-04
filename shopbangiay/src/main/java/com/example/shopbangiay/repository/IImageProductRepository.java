package com.example.shopbangiay.repository;

import com.example.shopbangiay.dto.IImageDto;
import com.example.shopbangiay.model.ImageProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IImageProductRepository extends JpaRepository<ImageProduct, Integer> {
    @Query(value = "select product.id as id, image_product.image as image \n" +
            "from product join image_product on product.id = image_product.id_product;", nativeQuery = true)
    List<IImageDto> findAllImage();
}
