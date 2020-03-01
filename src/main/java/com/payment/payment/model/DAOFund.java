package com.payment.payment.model;

import javax.persistence.*;

@Entity
@Table(name = "Funds")
public class DAOFund {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private Double fund;
    @Column
    private Integer userId;

    public Integer getUserID() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public Double getFund() {
        return fund;
    }

    public void setFund(Double fund) {
        this.fund = fund;
    }



}
