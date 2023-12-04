package com.example.shopbangiay.service;

import com.example.shopbangiay.model.TypeProduct;
import com.example.shopbangiay.repository.IProductRepository;
import com.example.shopbangiay.repository.ITypeProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TypeProductService implements ITypeProductService{
    @Autowired
    private ITypeProductRepository typeProductRepository;
    @Override
    public List<TypeProduct> findAll() {
        return typeProductRepository.findAll();
    }
}
