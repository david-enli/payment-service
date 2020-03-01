package com.payment.payment.model;

import java.io.Serializable;

public class MakePaymentDTO implements Serializable {
    private String orderId;
    private Integer userId;
    private Double paymentAmount;
    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
    public Double getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(Double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId() {
        this.userId = userId;
    }

}
