package com.payment.payment.controllers;

import com.payment.payment.model.AddFundDTO;
import com.payment.payment.model.MakePaymentDTO;
import com.payment.payment.model.PaymentMethodDTO;
import com.payment.payment.model.RefundPaymentDTO;
import com.payment.payment.service.FundService;
import com.payment.payment.service.PaymentMethodManagementService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController


@Api(value = "Payment Management System", description = "Operations pertaining to profile Payment")
public class PaymentControllers {
    @Autowired
    PaymentMethodManagementService paymentService;

    @Autowired
    FundService fundService;


    @ApiOperation(value = "Add a payment method")
    @RequestMapping(value = "/addPaymentMethod", method = RequestMethod.POST)
    public void addPaymentMethod(@RequestBody PaymentMethodDTO paymentMethod) throws Exception {

        paymentService.addPaymentMethod(paymentMethod);
    }


    @ApiOperation(value = "retrieve a payment method given userId")
    @RequestMapping(value = "/getPaymentMethod", method = RequestMethod.GET)
    public PaymentMethodDTO getPaymentMethod(@ApiParam(value = "given userId", required = true)@RequestParam Integer userID) throws Exception {
        return paymentService.getPaymentMethod(userID);
    }

    @ApiOperation(value = "add fund")
    @RequestMapping(value = "/addFund", method = RequestMethod.POST)
    public void addFund(@RequestBody AddFundDTO fund) throws Exception {
        fundService.addFund(fund);
    }

    @ApiOperation(value = "get available fund")
    @RequestMapping(value = "/getFund", method = RequestMethod.GET)
    public Double getFund(@ApiParam(value = "given userId", required = true) @RequestParam Integer userId) throws Exception {
        return fundService.getAvailableFund(userId);
    }

    @ApiOperation(value = "make a payment")
    @RequestMapping(value = "/makePayment", method = RequestMethod.POST)
    public void makePayment(@RequestBody MakePaymentDTO makePaymentDTO) throws Exception {
        System.out.println("in contrller, orderid is" + makePaymentDTO.getOrderId());
        System.out.println("in contrller, userid is" + makePaymentDTO.getUserId());
        System.out.println("in contrller, paymentAmount is" + makePaymentDTO.getPaymentAmount());
        fundService.makePayment(makePaymentDTO);
    }

    @ApiOperation(value = "refund an order")
    @RequestMapping(value = "/processRefund", method = RequestMethod.POST)
    public void processRefund(@RequestBody RefundPaymentDTO refundPaymentDTO) throws Exception {
        fundService.refund(refundPaymentDTO);
    }

}
