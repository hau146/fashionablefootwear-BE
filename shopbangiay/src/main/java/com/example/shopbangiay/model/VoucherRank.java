//package com.example.shopbangiay.model;
//
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//import javax.persistence.*;
//
//@Entity
//@Setter
//@Getter
//@NoArgsConstructor
//@AllArgsConstructor
//public class VoucherRank {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;
//    private String name;
//    private String code;
//    private int discountMoney;
//    @ManyToOne
//    @JoinColumn(name = "id_rank",referencedColumnName = "id")
//    private RankAccount rankAccount;
//}
