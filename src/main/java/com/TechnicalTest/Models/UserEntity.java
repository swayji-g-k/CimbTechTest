package com.TechnicalTest.Models;

import lombok.Data;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.List;

@Entity
@Table(name = "tb_users", indexes = {
        @Index(name = "idx_userentity_user_id", columnList = "user_id, username, account_number")
}, uniqueConstraints = {
        @UniqueConstraint(name = "uc_userentity_user_id", columnNames = {"user_id", "username", "account_number"})
})
@Data
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id", unique = true)
    private BigInteger userId;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(name = "password_hash", nullable = false)
    private String passwordHash;

    @Column(name = "account_number", unique = true)
    private String accountNumber;

    @OneToMany(mappedBy = "userEntity", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<TransactionHistoryEntity> TransactionHistory;
}