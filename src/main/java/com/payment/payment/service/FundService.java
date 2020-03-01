package com.payment.payment.service;

import com.payment.payment.dao.FundDao;
import com.payment.payment.dao.PaymentHistoryDao;
import com.payment.payment.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FundService {
    @Autowired
    FundDao fundDao;

    @Autowired
    PaymentHistoryDao paymentHistoryDao;

    @Value("${service.url.orderService}")
    private String uri;

    private RestTemplate restTemplate = new RestTemplate();

    public DAOFund addFund(AddFundDTO fund) {
        List<DAOFund> list = fundDao.findByUserId(fund.getUserId());
        DAOFund daoAddFund = new DAOFund();

        daoAddFund.setUserId(fund.getUserId());
        if(list.size() == 0) {
            daoAddFund.setFund(fund.getFund());
            return fundDao.save(daoAddFund);
        }else {
            DAOFund currentFund = fundDao.findOneByUserId(fund.getUserId());
            Double avaliableFund = currentFund.getFund();
            currentFund.setFund(avaliableFund + fund.getFund());
            return fundDao.save(currentFund);
        }


    }

    public void makePayment(MakePaymentDTO makePaymentDTO) throws Exception {
        System.out.println("handling orderid = " + makePaymentDTO.getOrderId());
        DAOFund currentFund = fundDao.findOneByUserId(makePaymentDTO.getUserId());
        System.out.println("avaliable fund is " + currentFund.getFund());
        Double paymountAmount = makePaymentDTO.getPaymentAmount();
        Double avaliableFund = currentFund.getFund();
        if (paymountAmount <= avaliableFund) {
            currentFund.setFund(avaliableFund - paymountAmount);
            fundDao.save(currentFund);
        } else {
            throw new Exception();
        }
        HttpEntity<?> entity = new HttpEntity<>(currentFund);

        String finalUri = String.format(uri, makePaymentDTO.getOrderId(), "PAID");

        ResponseEntity result = restTemplate.exchange(finalUri, HttpMethod.PUT, entity, String.class);

        //track payment history.
        DAOPaymentHistory paymentHistory = new DAOPaymentHistory();
        paymentHistory.setOrderId(makePaymentDTO.getOrderId());
        paymentHistory.setPaymentMethod("Cash");
        paymentHistory.setPaymentType("Payment");
        paymentHistory.setUserId(makePaymentDTO.getUserId());
        paymentHistoryDao.save(paymentHistory);



    }

    public Double getAvailableFund(Integer userId) {
        DAOFund daofund = fundDao.findOneByUserId(userId);
        return daofund.getFund();
    }

    public void refund(RefundPaymentDTO refundPaymentDTO) throws Exception {
        DAOFund currentFund = fundDao.findOneByUserId(refundPaymentDTO.getUserId());
        System.out.println("currentFund = " + currentFund.getFund());
        Double refundAmount = refundPaymentDTO.getRefundAmount();
        Double avaliableFund = currentFund.getFund();
        currentFund.setFund(avaliableFund + refundAmount);
        fundDao.save(currentFund);

        DAOPaymentHistory refundHistory = new DAOPaymentHistory();
        refundHistory.setOrderId(refundPaymentDTO.getOrderId());
        refundHistory.setPaymentMethod("n/a");
        refundHistory.setPaymentType("Refund");
        refundHistory.setUserId(refundPaymentDTO.getUserId());
        paymentHistoryDao.save(refundHistory);
        HttpEntity<?> entity = new HttpEntity<>(currentFund);

        String finalUri = String.format(uri, refundPaymentDTO.getOrderId(), "Refunded");

        ResponseEntity result = restTemplate.exchange(finalUri, HttpMethod.PUT, entity, String.class);

    }


}

