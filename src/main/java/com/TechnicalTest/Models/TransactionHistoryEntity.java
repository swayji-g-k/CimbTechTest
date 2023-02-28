package com.TechnicalTest.Models;

import lombok.Data;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;

@Entity
@Table(name = "tb_transaction_history", uniqueConstraints = {
        @UniqueConstraint(name = "uc_transactionhistory", columnNames = {"transaction_history_id"})
})
@Data
public class TransactionHistoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "transaction_history_id", unique = true)
    private BigInteger TransactionHistoryId;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "activity_date", unique = true, nullable = false)
    private Date activityDate;

    @Column(nullable = false)
    private BigInteger amount;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "transaction_type_id")
    private TransactionTypeEntity transactionType;
}
