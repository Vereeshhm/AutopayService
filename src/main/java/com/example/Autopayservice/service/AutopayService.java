package com.example.Autopayservice.service;

import com.example.Autopayservice.Responses.DebitResponse;
import com.example.Autopayservice.Responses.InitiatePayResponseEntity;

public interface AutopayService {

	public InitiatePayResponseEntity fetchInitiate();

	public DebitResponse fetchDebitRequest();

	public String fetchTransactionstatus();

	public String fetchCancelrequest();

}
