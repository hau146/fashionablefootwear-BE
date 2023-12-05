package com.example.shopbangiay.repository;

import com.example.shopbangiay.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface IAccountRepository extends JpaRepository<Account, Integer> {
    @Transactional
    @Query(value = "SELECT * FROM shopbangiay.account WHERE\n" +
            "    username = :username and is_deleted = 0;",nativeQuery = true)
    Account findAccountByName(@Param("username") String username);

    @Query(value = "SELECT * from shopbangiay.account au WHERE username = :userName",nativeQuery = true)
    Account findIdByUserName(@Param("userName") String userName);
}
