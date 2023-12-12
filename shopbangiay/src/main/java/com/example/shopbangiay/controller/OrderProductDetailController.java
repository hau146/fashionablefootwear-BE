package com.example.shopbangiay.controller;

import com.example.shopbangiay.dto.ICartDto;
import com.example.shopbangiay.dto.IOrderProductDetailDto;
import com.example.shopbangiay.service.IOrderProductDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin("*")
@RestController
@RequestMapping("/api/public/orderProductDetail")
public class OrderProductDetailController {
    @Autowired
    private IOrderProductDetailService orderProductDetailService;

    @GetMapping("/{id}")
    public ResponseEntity<Page<IOrderProductDetailDto>> showCartById(@RequestParam(name = "limit", defaultValue = "5", required = false) int limit,
                                                       @RequestParam(name = "page", defaultValue = "0", required = false) int page,
                                                       @PathVariable int id) {
        Pageable pageable = PageRequest.of(page, limit);
        Page<IOrderProductDetailDto> orderProductDetailDtoPage = orderProductDetailService.findAllById(pageable, id);
        if (orderProductDetailDtoPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(orderProductDetailDtoPage, HttpStatus.OK);
    }

    @GetMapping("/sumTotalPrice/{id}")
    public ResponseEntity<Double> sumTotalPriceById(@PathVariable int id) {
        Double sumTotalPriceById = orderProductDetailService.sumTotalPriceById(id);
        return new ResponseEntity<>(sumTotalPriceById, HttpStatus.OK);
    }

    @PatchMapping("/updateRankAccount")
    public ResponseEntity<String> reduceTheNumberOf(@RequestParam(name = "id", defaultValue = "", required = false) Integer id,
                                                    @RequestParam(name = "number", defaultValue = "", required = false) Integer number) {
        orderProductDetailService.updateRankAccount(id, number);
        return ResponseEntity.ok("Sửa thành công");
    }
}
