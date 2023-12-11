package com.example.shopbangiay.service;

import com.example.shopbangiay.dto.IImageDto;
import com.example.shopbangiay.dto.IProductDetail;
import com.example.shopbangiay.dto.IProductDto;
import com.example.shopbangiay.dto.ISizeDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IProductService {
    //    List<IProductDto> findAllProduct();
    Page<IProductDto> findAllProduct(Pageable pageable, String nameProduct, String typeId);
    IProductDetail findByAllIdProduct(Integer id);
    List<ISizeDto> findBySizeIdProduct(Integer id);
    List<IImageDto> findByImageIdProduct(Integer id);
    void deleteById(Integer id);

}
