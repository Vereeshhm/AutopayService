package com.example.Autopayservice.serviceImpl;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import com.example.Autopayservice.Apilogentity.ApiLog;
import com.example.Autopayservice.Repository.ApiLogRepository;
import com.google.gson.Gson;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class LoggingInterceptor implements HandlerInterceptor {

	@Autowired
	private ApiLogRepository apiLogRepository;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
		if (!(request instanceof ContentCachingRequestWrapper)) {
			request = new ContentCachingRequestWrapper(request);
		}
		if (!(response instanceof ContentCachingResponseWrapper)) {
			response = new ContentCachingResponseWrapper(response);
		}
		return true;
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws IOException {
		ContentCachingRequestWrapper wrappedRequest = (ContentCachingRequestWrapper) request;
		ContentCachingResponseWrapper wrappedResponse = (ContentCachingResponseWrapper) response;

		String requestBody = new String(wrappedRequest.getContentAsByteArray(), StandardCharsets.UTF_8);
		String responseBody = new String(wrappedResponse.getContentAsByteArray(), StandardCharsets.UTF_8);

		String url = request.getRequestURI();
		int statusCode = response.getStatus();

		Gson gson = new Gson();
		String requestBodyJson = gson.toJson(requestBody);
		String responseBodyJson = gson.toJson(responseBody);

		ApiLog apiLog = new ApiLog();

		apiLog.setUrl(url);
		apiLog.setRequestBody(requestBodyJson);
		apiLog.setResponseBody(responseBodyJson);
		if (statusCode == 200) {
			apiLog.setStatus("SUCCESS");
		} else {
			apiLog.setStatus("FAILURE");
		}
		apiLogRepository.save(apiLog);

		wrappedResponse.copyBodyToResponse();
	}
}
