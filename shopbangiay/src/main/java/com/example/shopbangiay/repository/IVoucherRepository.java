package com.example.shopbangiay.repository;

import com.example.shopbangiay.model.Voucher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface IVoucherRepository extends JpaRepository<Voucher,Integer> {

    @Transactional
    @Modifying
    @Query(value = "UPDATE voucher SET status_voucher = 0 WHERE id = :id", nativeQuery = true)
    void setStatusVoucher(@Param("id") Integer id);

    @Query(value = "select * from voucher where id_account = :id", nativeQuery = true)
    List<Voucher> findAllById(@Param("id") Integer id);
    @Query(value = "select * from voucher where id_account = :id and `code` = :code", nativeQuery = true)
    Voucher findByCode(@Param("id") Integer id, @Param("code") String code);
}
