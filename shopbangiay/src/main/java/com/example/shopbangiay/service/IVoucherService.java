package com.example.shopbangiay.service;

import com.example.shopbangiay.model.Voucher;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IVoucherService {
    void setStatusVoucher(Integer id);
    List<Voucher> findAllById(Integer id);
    Voucher findByCode(Integer id, String code);
}
