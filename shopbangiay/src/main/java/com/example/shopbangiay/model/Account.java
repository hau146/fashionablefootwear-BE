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
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String username;
    private String password;
    private String address;
    private boolean gender;
    private String date;
    private String numberPhone;
    private String email;
    private String avatar;

    @Column(name = "is_deleted",columnDefinition = "bit(1) default 0")
    private Boolean isDeleted;

    @ManyToOne
    @JoinColumn(name = "id_role",referencedColumnName = "id")
    private Role role;

    @ManyToOne
    @JoinColumn(name = "id_rank",referencedColumnName = "id")
    private RankAccount rankAccount;

    @OneToMany(mappedBy = "account")
    @JsonBackReference
    private Set<Voucher> voucherSet;

    @OneToMany(mappedBy = "account")
    @JsonBackReference
    private Set<Cart> cartSet;

    @OneToMany(mappedBy = "account")
    @JsonBackReference
    private Set<OrderStatus> orderStatusSet;

    @OneToMany(mappedBy = "account")
    @JsonBackReference
    private Set<OrderProduct> orderProductSet;
}
