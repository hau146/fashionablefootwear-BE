package com.example.shopbangiay.service;

import com.example.shopbangiay.dto.IImageDto;
import com.example.shopbangiay.repository.IImageProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ImageProductService implements IImageProductService{
    @Autowired
    private IImageProductRepository imageProductRepository;
    @Override
    public List<IImageDto> findAllImage() {
        return imageProductRepository.findAllImage();
    }
}
