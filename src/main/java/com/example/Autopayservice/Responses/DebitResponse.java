package com.example.Autopayservice.Responses;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "debit_response")
public class DebitResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@JsonIgnore
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Embedded
	private Resultt result;

	public int getId() {
		return id;
	}

	public Resultt getResult() {
		return result;
	}

	public void setResult(Resultt result) {
		this.result = result;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Embeddable
	public static class Resultt implements Serializable {

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

		@Column(name = "auto_debit_access_key")
		private String autoDebitAccessKey;

		@Column(name = "signzy_id")
		private String signzyId;

		@Column(name = "merchant_debit_id")
		private String merchantDebitId;

		@Embedded
		private Data data;

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

		public String getAutoDebitAccessKey() {
			return autoDebitAccessKey;
		}

		public void setAutoDebitAccessKey(String autoDebitAccessKey) {
			this.autoDebitAccessKey = autoDebitAccessKey;
		}

		public String getSignzyId() {
			return signzyId;
		}

		public void setSignzyId(String signzyId) {
			this.signzyId = signzyId;
		}

		public String getMerchantDebitId() {
			return merchantDebitId;
		}

		public void setMerchantDebitId(String merchantDebitId) {
			this.merchantDebitId = merchantDebitId;
		}

		public Data getData() {
			return data;
		}

		public void setData(Data data) {
			this.data = data;
		}

		@Embeddable
		public static class Data implements Serializable {

			private static final long serialVersionUID = 1L;

			@Column(name = "status")
			private int status;

			@Column(name = "data")
			private String data;

			// Getters and setters
			public int getStatus() {
				return status;
			}

			public void setStatus(int status) {
				this.status = status;
			}

			public String getData() {
				return data;
			}

			public void setData(String data) {
				this.data = data;
			}

		}

		@Override
		public String toString() {
			return "Resultt [txnId=" + txnId + ", amount=" + amount + ", productInfo=" + productInfo + ", firstName="
					+ firstName + ", phone=" + phone + ", email=" + email + ", customerAuthenticationId="
					+ customerAuthenticationId + ", autoDebitAccessKey=" + autoDebitAccessKey + ", signzyId=" + signzyId
					+ ", merchantDebitId=" + merchantDebitId + ", data=" + data + "]";
		}

	}

}
