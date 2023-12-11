package com.example.shopbangiay.service;

import com.example.shopbangiay.dto.IOrderProductDetailDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

public interface IOrderProductDetailService {
    Page<IOrderProductDetailDto> findAllById(Pageable pageable, Integer id);
}
