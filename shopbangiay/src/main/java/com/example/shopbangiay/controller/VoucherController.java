package com.example.shopbangiay.controller;

import com.example.shopbangiay.model.Voucher;
import com.example.shopbangiay.service.IVoucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin("*")
@RestController
@RequestMapping("/api/public/voucher")
public class VoucherController {
    @Autowired
    private IVoucherService voucherService;

    @GetMapping("")
    public ResponseEntity<List<Voucher>> findAllById(@RequestParam(name = "id", defaultValue = "", required = false) Integer id) {
        List<Voucher> integerList = voucherService.findAllById(id);
        return new ResponseEntity<>(integerList, HttpStatus.OK);
    }

    @GetMapping("/detailVoucher")
    public ResponseEntity<Voucher> findByCode(@RequestParam(name = "id", defaultValue = "", required = false) Integer id,
                                              @RequestParam(name = "code", defaultValue = "", required = false) String code) {
        Voucher voucher = voucherService.findByCode(id,code);
        return new ResponseEntity<>(voucher, HttpStatus.OK);
    }

    @PatchMapping("/setStatus")
    public ResponseEntity<String> setStatusVoucher(@RequestParam(name = "id", defaultValue = "", required = false) Integer id) {
        voucherService.setStatusVoucher(id);
        return ResponseEntity.ok("Sửa thành công");
    }
}
