package com.example.Autopayservice.Responses;

import jakarta.persistence.*;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "initiate_pay_response")
public class InitiatePayResponseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@JsonIgnore
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Embedded
	private Result result;

	// Getters and setters
	public Result getResult() {
		return result;
	}

	public void setResult(Result result) {
		this.result = result;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Embeddable
	public static class Result implements Serializable {

		private static final long serialVersionUID = 1L;

		@Column(name = "txn_id")
		private String txnId;

		@Column(name = "amount")
		private String amount;

		@Column(name = "product_info")
		private String productInfo;

		@Column(name = "first_name")
		private String firstName;

		@Column(name = "phone")
		private String phone;

		@Column(name = "email")
		private String email;

		@Column(name = "customer_authentication_id")
		private String customerAuthenticationId;

		@Column(name = "data")
		private String data;

		// Getters and setters
		public String getTxnId() {
			return txnId;
		}

		public void setTxnId(String txnId) {
			this.txnId = txnId;
		}

		public String getAmount() {
			return amount;
		}

		public void setAmount(String amount) {
			this.amount = amount;
		}

		public String getProductInfo() {
			return productInfo;
		}

		public void setProductInfo(String productInfo) {
			this.productInfo = productInfo;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getPhone() {
			return phone;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getCustomerAuthenticationId() {
			return customerAuthenticationId;
		}

		public void setCustomerAuthenticationId(String customerAuthenticationId) {
			this.customerAuthenticationId = customerAuthenticationId;
		}

		public String getData() {
			return data;
		}

		public void setData(String data) {
			this.data = data;
		}

		@Override
		public String toString() {
			return "Result [txnId=" + txnId + ", amount=" + amount + ", productInfo=" + productInfo + ", firstName="
					+ firstName + ", phone=" + phone + ", email=" + email + ", customerAuthenticationId="
					+ customerAuthenticationId + ", data=" + data + "]";
		}

	}
}
