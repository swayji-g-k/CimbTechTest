package com.TechnicalTest.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;

@Entity
@Table(name = "tb_transaction_history")
@Data
public class TransactionHistoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "transaction_history_id", unique = true)
    private BigInteger TransactionHistoryId;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "activity_date", nullable = false)
    private Date activityDate;

    @Column(nullable = false)
    private BigInteger amount;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private UserEntity userEntity;

    @ManyToOne
    @JoinColumn(name = "transaction_type_id")
    @JsonIgnore
    private TransactionTypeEntity transactionType;
}
