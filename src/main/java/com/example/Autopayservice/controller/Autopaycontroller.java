package com.example.Autopayservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Autopayservice.Responses.DebitResponse;
import com.example.Autopayservice.Responses.InitiatePayResponseEntity;

//import com.example.Autopayservice.Responses.InitiatePayResponse;
//import com.example.Autopayservice.Responses.TransactionResponse;
import com.example.Autopayservice.service.AutopayService;

@RestController
@RequestMapping("/saswat")
public class Autopaycontroller {

	@Autowired
	AutopayService autopayService;

	@PostMapping("/initiate-payment")
	public InitiatePayResponseEntity getInitiate() {

		InitiatePayResponseEntity response = autopayService.fetchInitiate();

		return response;

	}

	@PostMapping("/debitRequest")
	public DebitResponse getDebitrequest() {

		DebitResponse debitResponse = autopayService.fetchDebitRequest();
		return debitResponse;
	}

	@PostMapping("/Transactionstatus")
	public String getTransactionStatus() {

		return autopayService.fetchTransactionstatus();
	}

	@PostMapping("/cancel-mandate")
	public String getCancelmandate() {
		return autopayService.fetchCancelrequest();
	}
}
