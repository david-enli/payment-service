package com.payment.payment.service;

import com.payment.payment.dao.PaymentMethodDao;
import com.payment.payment.model.DAOPaymentMethod;
import com.payment.payment.model.PaymentMethodDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentMethodManagementService {
    @Autowired PaymentMethodDao paymentMethodDao;

    public DAOPaymentMethod addPaymentMethod(PaymentMethodDTO paymentMethod) {
        DAOPaymentMethod newPaymentMethod = new DAOPaymentMethod();
        newPaymentMethod.setBillingAddress(paymentMethod.getBillingAddress());
        newPaymentMethod.setCardNumber(paymentMethod.getCardNumber());
        newPaymentMethod.setFullName(paymentMethod.getFullName());
        newPaymentMethod.setPaymentType(paymentMethod.getPaymentType());
        newPaymentMethod.setUserID(paymentMethod.getUserId());
        return paymentMethodDao.save(newPaymentMethod);

    }

    public PaymentMethodDTO getPaymentMethod(Integer userID) {
        DAOPaymentMethod paymentMethod = paymentMethodDao.findOneByUserId(userID);
        PaymentMethodDTO result = new PaymentMethodDTO();
        result.setBillingAddress(paymentMethod.getBillingAddress());
        result.setCardNumber(paymentMethod.getCardNumber());
        result.setPaymentType(paymentMethod.getPaymentType());
        result.setFullName(paymentMethod.getFullName());
        result.setUserID(paymentMethod.getUserID());
        return result;
    }
}
