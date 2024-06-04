package com.example.Autopayservice.Apilogentity;

import java.time.LocalDateTime;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.vladmihalcea.hibernate.type.json.JsonType;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "api_logss")

public class ApiLog {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String url;

//	@Type(JsonBinaryType.class)
//	@Column(name = "request_body", columnDefinition = "jsonb")
	@Type(JsonType.class)
	@JdbcTypeCode(SqlTypes.JSON)
	private String requestBody;

//	@Type(JsonBinaryType.class)
//	@Column(name = "response_body", columnDefinition = "jsonb")
	@Type(JsonType.class)
	@JdbcTypeCode(SqlTypes.JSON)
	private String responseBody;

	private String status;
	private LocalDateTime timestamp = LocalDateTime.now();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public String getRequestBody() {
		return requestBody;
	}

	public void setRequestBody(String requestBody) {
		this.requestBody = requestBody;
	}

	public String getResponseBody() {
		return responseBody;
	}

	public void setResponseBody(String responseBody) {
		this.responseBody = responseBody;
	}

}
