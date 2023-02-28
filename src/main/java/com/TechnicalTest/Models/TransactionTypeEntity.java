package com.TechnicalTest.Models;

import lombok.Data;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.List;

@Entity
@Table(name = "tb_transaction_type", indexes = {
        @Index(name = "idx_transactiontype", columnList = "transaction_type_id, transaction_code, transaction_name")
}, uniqueConstraints = {
        @UniqueConstraint(name = "uc_transactiontype", columnNames = {"transaction_type_id", "transaction_code"})
})
@Data
public class TransactionTypeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "transaction_type_id", unique = true)
    private BigInteger transactionTypeId;

    @Column(name = "transaction_code", unique = true, nullable = false)
    private String transactionCode;

    @Column(name = "transaction_name", nullable = false)
    private String transactionName;

    @OneToMany(mappedBy = "transactionType", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<TransactionHistoryEntity> TransactionHistory;
}
