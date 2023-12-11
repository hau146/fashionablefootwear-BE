package com.example.shopbangiay.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RankAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @OneToMany(mappedBy = "rankAccount")
    @JsonBackReference
    private Set<Account> accountSet;

//    @OneToMany(mappedBy = "rankAccount")
//    @JsonBackReference
//    private Set<VoucherRank> voucherRankSet;
}
