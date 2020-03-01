package com.payment.payment.model;

import javax.persistence.*;

@Entity
@Table(name = "PaymentMethods")
public class DAOPaymentMethod {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private Integer userId;
    @Column
    private String fullName;
    @Column
    private String paymentType;
    @Column
    private String cardNumber;
    @Column
    private String billingAddress;

    public Integer getUserID() {
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
