package com.example.shopbangiay.service;

import com.example.shopbangiay.dto.ISizeDto;
import com.example.shopbangiay.repository.ISizeProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SizeProductService implements ISizeProductService{
    @Autowired
    private ISizeProductRepository sizeProductRepository;
    @Override
    public List<ISizeDto> findAllSize() {
        return sizeProductRepository.findAllSize();
    }
}
