package com.example.shopbangiay.repository;

import com.example.shopbangiay.dto.ISizeDto;
import com.example.shopbangiay.model.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ISizeProductRepository extends JpaRepository<Size, Integer> {
    @Query(value = "select product.id as idProduct, size.size_number as sizeNumber \n" +
            "from product join size_detail on product.id = size_detail.id_product\n" +
            "join size on size_detail.id_size = size.id;", nativeQuery = true)
    List<ISizeDto> findAllSize();
}
