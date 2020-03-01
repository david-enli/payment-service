package com.payment.payment.dao;

import com.payment.payment.model.DAOFund;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FundDao extends CrudRepository<DAOFund, Integer> {
    DAOFund findOneByUserId(Integer userid) ;
    List<DAOFund> findByUserId(Integer userid);
}



