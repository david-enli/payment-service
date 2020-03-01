package com.payment.payment.dao;


import com.payment.payment.model.DAOFund;
import com.payment.payment.model.DAOPaymentHistory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentHistoryDao extends CrudRepository<DAOPaymentHistory, Integer> {

}

