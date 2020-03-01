package com.payment.payment.model;

import java.io.Serializable;

public class RefundPaymentDTO implements Serializable {
    private String orderId;
    private Integer userId;
    private Double refundAmount;
    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
    public Double getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(Double refundAmount) {
        this.refundAmount = refundAmount;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId() {
        this.userId = userId;
    }

}
