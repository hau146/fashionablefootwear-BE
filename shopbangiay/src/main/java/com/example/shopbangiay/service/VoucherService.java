package com.example.shopbangiay.service;

import com.example.shopbangiay.model.Voucher;
import com.example.shopbangiay.repository.IVoucherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoucherService implements IVoucherService{
    @Autowired
    private IVoucherRepository voucherRepository;
    @Override
    public void setStatusVoucher(Integer id) {
        voucherRepository.setStatusVoucher(id);
    }

    @Override
    public List<Voucher> findAllById(Integer id) {
        return voucherRepository.findAllById(id);
    }

    @Override
    public Voucher findByCode(Integer id, String code) {
        return voucherRepository.findByCode(id, code);
    }
}
