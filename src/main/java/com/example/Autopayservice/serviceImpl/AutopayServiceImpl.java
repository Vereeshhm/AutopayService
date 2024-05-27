package com.example.Autopayservice.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.Autopayservice.Utils.CancelRequest;
import com.example.Autopayservice.Utils.DebitRequest;
import com.example.Autopayservice.Utils.InitiateRequest;
import com.example.Autopayservice.Utils.PropertiesConfig;
import com.example.Autopayservice.Utils.TransactionStatusRequest;
import com.example.Autopayservice.service.AutopayService;

@Service
public class AutopayServiceImpl implements AutopayService {

	private final RestTemplate restTemplate;

	private final String token;

	@Autowired
	PropertiesConfig config;

	public AutopayServiceImpl(RestTemplate restTemplate, @Value("${token}") String token) {
		this.restTemplate = restTemplate;
		this.token = token;
	}

	@Override
	public String fetchInitiate(InitiateRequest initiateRequest) {

		String Url = config.getInitiateUrl();

		initiateRequest.getAddress1();
		initiateRequest.getAddress2();
		initiateRequest.getAmount();
		initiateRequest.getCity();
		initiateRequest.getCountry();
		initiateRequest.getEmail();
		initiateRequest.getFailureRedirectUrl();
		initiateRequest.getFinalCollectionDate();
		initiateRequest.getFirstName();
		initiateRequest.getMaxAmount();
		initiateRequest.getPhone();
		initiateRequest.getProductInfo();
//		initiateRequest.getShowPaymentMode();
		initiateRequest.getState();
		initiateRequest.getSubMerchantId();
		initiateRequest.getSuccessRedirectUrl();
		initiateRequest.getUserDefinedField1();
		initiateRequest.getUserDefinedField2();
		initiateRequest.getUserDefinedField3();
		initiateRequest.getZipcode();

		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", token);
		headers.set("Content-Type", "application/json");
		HttpEntity<String> requestEntity = new HttpEntity(initiateRequest, headers);
		String Response = restTemplate.postForObject(Url, requestEntity, String.class);
		return Response;
	}

	
	
	
	@Override
	public String fetchDebitRequest(DebitRequest debitRequest) {
		
		String Url=config.getDebitUrl();
		
		debitRequest.getFirstName();
		debitRequest.getAmount();
		debitRequest.getCallbackUrl();
		debitRequest.getCustomerAuthenticationId();
		debitRequest.getEmail();
		debitRequest.getFailureRedirectUrl();
		debitRequest.getFinalCollectionDate();
		debitRequest.getMaxAmount();
		debitRequest.getPhone();
		debitRequest.getProductInfo();
		debitRequest.getSubMerchantId();
		debitRequest.getSuccessRedirectUrl();
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", token);
		headers.set("Content-Type", "application/json");
		HttpEntity<String> requestEntity = new HttpEntity(debitRequest, headers);
		String Response = restTemplate.postForObject(Url, requestEntity, String.class);
		return Response;
	}

	@Override
	public String fetchTransactionstatus(TransactionStatusRequest request) {
		
		
		String Url=config.getTransactionUrl();
		
		
		request.getTxnId();
		request.getAmount();
		request.getEmail();
		request.getPhone();
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", token);
		headers.set("Content-Type", "application/json");
		HttpEntity<String> requestEntity = new HttpEntity(request, headers);
		String Response = restTemplate.postForObject(Url, requestEntity, String.class);
		return Response;
	}

	@Override
	public String fetchCancelrequest(CancelRequest cancelRequest) {
		
		
		String Url=config.getCancelUrl();
		
		cancelRequest.getCustomerAuthenticationId();
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", token);
		headers.set("Content-Type", "application/json");
		HttpEntity<String> requestEntity = new HttpEntity(cancelRequest, headers);
		String Response = restTemplate.postForObject(Url, requestEntity, String.class);
		return Response;
		
	}
}
