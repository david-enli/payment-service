package com.payment.payment.model;


import java.io.Serializable;

public class AddFundDTO implements Serializable {
    private Double fund;
    private Integer userId;

    public Integer getUserId() {
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
