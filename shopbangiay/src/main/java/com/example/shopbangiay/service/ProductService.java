package com.example.shopbangiay.service;

import com.example.shopbangiay.dto.IImageDto;
import com.example.shopbangiay.dto.IProductDetail;
import com.example.shopbangiay.dto.IProductDto;
import com.example.shopbangiay.dto.ISizeDto;
import com.example.shopbangiay.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService{
    @Autowired
    public IProductRepository productRepository;

    @Override
    public Page<IProductDto> findAllProduct(Pageable pageable, String nameProduct, String typeId) {
        return productRepository.findAllProduct(pageable, "%" + nameProduct + "%", "%" + typeId + "%");
    }

    @Override
    public IProductDetail findByAllIdProduct(Integer id) {
        return productRepository.findByAllIdProduct(id);
    }

    @Override
    public List<ISizeDto> findBySizeIdProduct(Integer id) {
        return productRepository.findBySizeIdProduct(id);
    }

    @Override
    public List<IImageDto> findByImageIdProduct(Integer id) {
        return productRepository.findByImageIdProduct(id);
    }

}
