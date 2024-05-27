package com.example.Autopayservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Autopayservice.Utils.CancelRequest;
import com.example.Autopayservice.Utils.DebitRequest;
import com.example.Autopayservice.Utils.InitiateRequest;
import com.example.Autopayservice.Utils.TransactionStatusRequest;
import com.example.Autopayservice.service.AutopayService;


@RestController
@RequestMapping("/saswat")
public class Autopaycontroller {

	
	
	@Autowired
	AutopayService autopayService;
	
	
	@PostMapping("/initiate-payment")
	public String getInitiate(@RequestBody InitiateRequest initiateRequest) {
		return autopayService.fetchInitiate(initiateRequest);

	}
	
	@PostMapping("/debitRequest")
	public String getDebitrequest(@RequestBody DebitRequest debitRequest)
	{
		return autopayService.fetchDebitRequest(debitRequest);
	}

    @PostMapping("/Transactionstatus")	
	public String getTransactionStatus(@RequestBody TransactionStatusRequest request) {
		return autopayService.fetchTransactionstatus(request);
	}
	
    @PostMapping("/cancel-mandate")
    public String getCancelmandate(@RequestBody CancelRequest cancelRequest)
    {
    	return autopayService.fetchCancelrequest(cancelRequest);
    }
}
