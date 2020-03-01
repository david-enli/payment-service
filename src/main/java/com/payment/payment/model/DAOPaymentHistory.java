package com.payment.payment.model;

import javax.persistence.*;

@Entity
@Table(name = "paymentHistory")
public class DAOPaymentHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String orderId;
    @Column
    private Integer userId;
    @Column
    private String paymentType;
    @Column
    private String paymentMethod;
    @Column
    private Double paymentAmount;


    public Integer getUserID() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getOrderId() {
        return userId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Double getPaymentAmount() {
        return paymentAmount;
    }

    public void getPaymentAmount(Double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }
}
