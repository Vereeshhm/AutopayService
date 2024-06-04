package com.example.Autopayservice.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.Autopayservice.Repository.DebitRequestRepository;
import com.example.Autopayservice.Repository.InitiatePayRepository;
import com.example.Autopayservice.Repository.InitiatePayResponseRepository;
import com.example.Autopayservice.Responses.DebitResponse;
import com.example.Autopayservice.Responses.DebitResponse.Resultt;
import com.example.Autopayservice.Responses.InitiatePayResponseEntity;
import com.example.Autopayservice.Responses.InitiatePayResponseEntity.Result;
import com.example.Autopayservice.Utils.CancelRequest;
import com.example.Autopayservice.Utils.DebitRequest;
import com.example.Autopayservice.Utils.InitiateRequest;
import com.example.Autopayservice.Utils.PropertiesConfig;
import com.example.Autopayservice.Utils.TransactionStatusRequest;
import com.example.Autopayservice.service.AutopayService;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class AutopayServiceImpl implements AutopayService {

	private final RestTemplate restTemplate;

	private final String token;

	@Autowired
	InitiatePayRepository initiatePayRepository;

	@Autowired
	InitiatePayResponseRepository initiatePayResponseRepository;

	@Autowired
	DebitRequestRepository debitRequestRepository;

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	PropertiesConfig config;

	public AutopayServiceImpl(RestTemplate restTemplate, @Value("${token}") String token) {
		this.restTemplate = restTemplate;
		this.token = token;
	}

	@Override
	public InitiatePayResponseEntity fetchInitiate() {

		String Url = config.getInitiateUrl();

		// Fetch all initiate request entities from the repository
		List<InitiateRequest> initiateRequests = initiatePayRepository.findAll();

		if (initiateRequests.isEmpty()) {
			throw new RuntimeException("No initiate request found");
		}

		InitiateRequest initiateRequest = initiateRequests.get(0);

		System.out.println("Initiate Request Data: " + initiateRequest.toString());

		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", token);
		headers.set("Content-Type", "application/json");

		HttpEntity<InitiateRequest> requestEntity = new HttpEntity<>(initiateRequest, headers);

		// Perform the HTTP POST request
		InitiatePayResponseEntity response;
		try {
			response = restTemplate.postForObject(Url, requestEntity, InitiatePayResponseEntity.class);
		} catch (Exception e) {
			// Log the error for debugging
			System.err.println("Error during API call: " + e.getMessage());
			throw e;
		}

		// Log the response for debugging
		System.out.println("API Response: " + response);
		initiatePayResponseRepository.save(response);
		return response;
	}

	@Override
	public DebitResponse fetchDebitRequest() {

		String Url = config.getDebitUrl();

		List<InitiateRequest> initiateRequests = initiatePayRepository.findAll();

		if (initiateRequests.isEmpty()) {
			throw new RuntimeException("No initiate request found");
		}

		List<InitiatePayResponseEntity> responseEntities = initiatePayResponseRepository.findFirstByOrderByIdDesc();

		if (responseEntities.isEmpty()) {
			throw new RuntimeException("No initiate pay response found");
		}

		// Get the first initiate request and response entities from the list
		InitiateRequest initiateRequest = initiateRequests.get(0);

		InitiatePayResponseEntity initiatePayResponseEntity = responseEntities.stream()
				.filter(entity -> entity.getResult() != null).findFirst()
				.orElseThrow(() -> new RuntimeException("No valid result found in initiate pay response entities"));

		// Log the initiate request data for debugging
		System.out.println("Initiate Request Data: " + initiateRequest.toString());

		DebitRequest debitRequest = new DebitRequest();
		// Log the response entity data for debugging
		System.out.println("Initiate Pay Response Entity: " + initiatePayResponseEntity.toString());

		Result result = initiatePayResponseEntity.getResult();
		if (result == null) {
			throw new RuntimeException("Result not found in initiate pay response entity");
		}

		// Log the result data for debugging
		System.out.println("Result Data: " + result.toString());

		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", token);
		headers.set("Content-Type", "application/json");

		// Set the fields in the debit request from initiateRequest and
		// initiatePayResponseEntity
		debitRequest.setFirstName(initiateRequest.getFirstName());
		debitRequest.setAmount(initiateRequest.getAmount());
		debitRequest.setCallbackUrl(initiateRequest.getCallbackUrl());
		debitRequest.setCustomerAuthenticationId(result.getCustomerAuthenticationId());
		debitRequest.setEmail(initiateRequest.getEmail());
		debitRequest.setFailureRedirectUrl(initiateRequest.getFailureRedirectUrl());
		debitRequest.setFinalCollectionDate(initiateRequest.getFinalCollectionDate());
		debitRequest.setPhone(initiateRequest.getPhone());
		debitRequest.setProductInfo(initiateRequest.getProductInfo());
		debitRequest.setMaxAmount(initiateRequest.getMaxAmount());
		debitRequest.setSubMerchantId(initiateRequest.getSubMerchantId());
		debitRequest.setSuccessRedirectUrl(initiateRequest.getSuccessRedirectUrl());

		HttpEntity<DebitRequest> requestEntity = new HttpEntity<>(debitRequest, headers);
		DebitResponse response;

		try {
			response = restTemplate.postForObject(Url, requestEntity, DebitResponse.class);
		} catch (Exception e) {
			// Log the error for debugging
			System.err.println("Error during API call: " + e.getMessage());
			throw e;
		}

		System.out.println("API Response: " + response);

		debitRequestRepository.save(response);

		return response;
	}

	@Override
	public String fetchTransactionstatus() {

		String Url = config.getTransactionUrl();

		TransactionStatusRequest request = new TransactionStatusRequest();
		List<DebitResponse> responseEntities = debitRequestRepository.findFirstByOrderByIdDesc();

		if (responseEntities.isEmpty()) {
			throw new RuntimeException("No debit pay response found");
		}
		DebitResponse debitResponse = responseEntities.stream().filter(entity -> entity.getResult() != null).findFirst()
				.orElseThrow(() -> new RuntimeException("No valid result found in initiate pay response entities"));

		Resultt result = debitResponse.getResult();
		if (result == null) {
			throw new RuntimeException("Result not found in initiate pay response entity");
		}

		System.out.println("Result Data: " + result.toString());
		// DebitRequest debitRequest=new DebitRequest();

		request.setTxnId(result.getTxnId());
		request.setAmount(result.getAmount());
		request.setEmail(result.getEmail());
		request.setPhone(result.getPhone());

		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", token);
		headers.set("Content-Type", "application/json");
		HttpEntity<String> requestEntity = new HttpEntity(request, headers);
		String Response = restTemplate.postForObject(Url, requestEntity, String.class);
		return Response;
	}

	@Override
	public String fetchCancelrequest() {

		String Url = config.getCancelUrl();
		CancelRequest cancelRequest = new CancelRequest();

		List<InitiatePayResponseEntity> responseEntities = initiatePayResponseRepository.findFirstByOrderByIdDesc();

		if (responseEntities.isEmpty()) {
			throw new RuntimeException("No initiate pay response found");
		}

		InitiatePayResponseEntity initiatePayResponseEntity = responseEntities.stream()
				.filter(entity -> entity.getResult() != null).findFirst()
				.orElseThrow(() -> new RuntimeException("No valid result found in initiate pay response entities"));

		Result result = initiatePayResponseEntity.getResult();
		if (result == null) {
			throw new RuntimeException("Result not found in initiate pay response entity");
		}

		// Log the result data for debugging
		System.out.println("Result Data: " + result.toString());

		cancelRequest.setCustomerAuthenticationId(result.getCustomerAuthenticationId());

		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", token);
		headers.set("Content-Type", "application/json");
		HttpEntity<String> requestEntity = new HttpEntity(cancelRequest, headers);
		String Response = restTemplate.postForObject(Url, requestEntity, String.class);

		return Response;

	}
}
