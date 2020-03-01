package com.payment.payment.model;

import java.io.Serializable;

public class PaymentMethodDTO implements Serializable {
    private Integer userId;
    private String fullName;
    private String paymentType;
    private String cardNumber;
    private String billingAddress;

    public Integer getUserId() {
        return userId;
    }

    public void setUserID(Integer userId) {
        this.userId = userId;
    }
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(String billingAddress) {
        this.billingAddress = billingAddress;
    }


}