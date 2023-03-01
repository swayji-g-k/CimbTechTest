package com.TechnicalTest.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.List;

@Entity
@Table(name = "tb_transaction_type", indexes = {
        @Index(name = "idx_transactiontype", columnList = "transaction_type_id, transaction_code, transaction_name")
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

    @ToString.Exclude
    @OneToMany(mappedBy = "transactionType", cascade = CascadeType.ALL)
    private List<TransactionHistoryEntity> transHistoryList;

    @ManyToMany(mappedBy = "userTransTypeList")
    @JsonIgnore
    private List<UserEntity> userList;
}
