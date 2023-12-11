package com.example.shopbangiay.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Voucher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String code;
    private int discountMoney;
    @Column(name = "status_voucher",columnDefinition = "bit(1) default 1")
    private boolean status;
    @ManyToOne
    @JoinColumn(name = "id_account",referencedColumnName = "id")
    private Account account;
}
