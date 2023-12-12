package com.example.shopbangiay.service;

import com.example.shopbangiay.dto.IOrderProductDetailDto;
import com.example.shopbangiay.repository.IOrderProductDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class OrderProductDetailService implements IOrderProductDetailService{
    @Autowired
    private IOrderProductDetailRepository orderProductDetailRepository;

    @Override
    public Page<IOrderProductDetailDto> findAllById(Pageable pageable, Integer id) {
        return orderProductDetailRepository.findAllById(pageable, id);
    }

    @Override
    public Double sumTotalPriceById(Integer id) {
        return orderProductDetailRepository.sumTotalPriceById(id);
    }

    @Override
    public void updateRankAccount(Integer id, Integer number) {
        orderProductDetailRepository.updateRankAccount(id, number);
    }
}
