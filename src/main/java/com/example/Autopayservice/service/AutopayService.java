package com.example.Autopayservice.service;

import com.example.Autopayservice.Utils.CancelRequest;
import com.example.Autopayservice.Utils.DebitRequest;
import com.example.Autopayservice.Utils.InitiateRequest;
import com.example.Autopayservice.Utils.TransactionStatusRequest;

public interface AutopayService {

	public String fetchInitiate(InitiateRequest initiateRequest);

	public String fetchDebitRequest(DebitRequest debitRequest);

	public String fetchTransactionstatus(TransactionStatusRequest request);

	public String fetchCancelrequest(CancelRequest cancelRequest);

}
