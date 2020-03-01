package com.payment.payment.dao;

import com.payment.payment.model.DAOPaymentMethod;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PaymentMethodDao extends CrudRepository<DAOPaymentMethod, Integer> {
    DAOPaymentMethod findOneByUserId(Integer userId);
}



