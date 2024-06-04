//package com.example.Autopayservice.Responses;
//
//public class TransactionResponse {
//
//	private Msg msg;
//	
//	
//	
//	 public Msg getMsg() {
//		return msg;
//	}
//	public void setMsg(Msg msg) {
//		this.msg = msg;
//	}
//	
//	public static class Msg{
//	private String txnId;
//	    private String firstName;
//	    private String phone;
//	    private String email;
//	    private String mode;
//	    private String unmappedstatus;
//	    private String cardCategory;
//	    private String addedon;
//	    private String paymentSource;
//	    private String pgType;
//	    private String bankRefNum;
//	    private String bankcode;
//	    private String error;
//	    private String errorMessage;
//	    private String nameOnCard;
//	    private String upiva;
//	    private String cardnum;
//	    private String issuingbank;
//	    private String amount;
//	    private String netAmountDebit;
//	    private String cashBackPercentage;
//	    private String deductionPercentage;
//	    private String merchantLogo;
//	    private String successCallbackUrl;
//	    private String failureCallbackUrl;
//	    private String productinfo;
//	    private String signzyId;
//	    private String userDefinedField1;
//	    private String userDefinedField2;
//	    private String userDefinedField3;
//	    private String cardType;
//	    private String status;
//	    private String bankName;
//	    private String authCode;
//		public String getTxnId() {
//			return txnId;
//		}
//		public void setTxnId(String txnId) {
//			this.txnId = txnId;
//		}
//		public String getFirstName() {
//			return firstName;
//		}
//		public void setFirstName(String firstName) {
//			this.firstName = firstName;
//		}
//		public String getPhone() {
//			return phone;
//		}
//		public void setPhone(String phone) {
//			this.phone = phone;
//		}
//		public String getEmail() {
//			return email;
//		}
//		public void setEmail(String email) {
//			this.email = email;
//		}
//		public String getMode() {
//			return mode;
//		}
//		public void setMode(String mode) {
//			this.mode = mode;
//		}
//		public String getUnmappedstatus() {
//			return unmappedstatus;
//		}
//		public void setUnmappedstatus(String unmappedstatus) {
//			this.unmappedstatus = unmappedstatus;
//		}
//		public String getCardCategory() {
//			return cardCategory;
//		}
//		public void setCardCategory(String cardCategory) {
//			this.cardCategory = cardCategory;
//		}
//		public String getAddedon() {
//			return addedon;
//		}
//		public void setAddedon(String addedon) {
//			this.addedon = addedon;
//		}
//		public String getPaymentSource() {
//			return paymentSource;
//		}
//		public void setPaymentSource(String paymentSource) {
//			this.paymentSource = paymentSource;
//		}
//		public String getPgType() {
//			return pgType;
//		}
//		public void setPgType(String pgType) {
//			this.pgType = pgType;
//		}
//		public String getBankRefNum() {
//			return bankRefNum;
//		}
//		public void setBankRefNum(String bankRefNum) {
//			this.bankRefNum = bankRefNum;
//		}
//		public String getBankcode() {
//			return bankcode;
//		}
//		public void setBankcode(String bankcode) {
//			this.bankcode = bankcode;
//		}
//		public String getError() {
//			return error;
//		}
//		public void setError(String error) {
//			this.error = error;
//		}
//		public String getErrorMessage() {
//			return errorMessage;
//		}
//		public void setErrorMessage(String errorMessage) {
//			this.errorMessage = errorMessage;
//		}
//		public String getNameOnCard() {
//			return nameOnCard;
//		}
//		public void setNameOnCard(String nameOnCard) {
//			this.nameOnCard = nameOnCard;
//		}
//		public String getUpiva() {
//			return upiva;
//		}
//		public void setUpiva(String upiva) {
//			this.upiva = upiva;
//		}
//		public String getCardnum() {
//			return cardnum;
//		}
//		public void setCardnum(String cardnum) {
//			this.cardnum = cardnum;
//		}
//		public String getIssuingbank() {
//			return issuingbank;
//		}
//		public void setIssuingbank(String issuingbank) {
//			this.issuingbank = issuingbank;
//		}
//		public String getAmount() {
//			return amount;
//		}
//		public void setAmount(String amount) {
//			this.amount = amount;
//		}
//		public String getNetAmountDebit() {
//			return netAmountDebit;
//		}
//		public void setNetAmountDebit(String netAmountDebit) {
//			this.netAmountDebit = netAmountDebit;
//		}
//		public String getCashBackPercentage() {
//			return cashBackPercentage;
//		}
//		public void setCashBackPercentage(String cashBackPercentage) {
//			this.cashBackPercentage = cashBackPercentage;
//		}
//		public String getDeductionPercentage() {
//			return deductionPercentage;
//		}
//		public void setDeductionPercentage(String deductionPercentage) {
//			this.deductionPercentage = deductionPercentage;
//		}
//		public String getMerchantLogo() {
//			return merchantLogo;
//		}
//		public void setMerchantLogo(String merchantLogo) {
//			this.merchantLogo = merchantLogo;
//		}
//		public String getSuccessCallbackUrl() {
//			return successCallbackUrl;
//		}
//		public void setSuccessCallbackUrl(String successCallbackUrl) {
//			this.successCallbackUrl = successCallbackUrl;
//		}
//		public String getFailureCallbackUrl() {
//			return failureCallbackUrl;
//		}
//		public void setFailureCallbackUrl(String failureCallbackUrl) {
//			this.failureCallbackUrl = failureCallbackUrl;
//		}
//		public String getProductinfo() {
//			return productinfo;
//		}
//		public void setProductinfo(String productinfo) {
//			this.productinfo = productinfo;
//		}
//		public String getSignzyId() {
//			return signzyId;
//		}
//		public void setSignzyId(String signzyId) {
//			this.signzyId = signzyId;
//		}
//		public String getUserDefinedField1() {
//			return userDefinedField1;
//		}
//		public void setUserDefinedField1(String userDefinedField1) {
//			this.userDefinedField1 = userDefinedField1;
//		}
//		public String getUserDefinedField2() {
//			return userDefinedField2;
//		}
//		public void setUserDefinedField2(String userDefinedField2) {
//			this.userDefinedField2 = userDefinedField2;
//		}
//		public String getUserDefinedField3() {
//			return userDefinedField3;
//		}
//		public void setUserDefinedField3(String userDefinedField3) {
//			this.userDefinedField3 = userDefinedField3;
//		}
//		public String getCardType() {
//			return cardType;
//		}
//		public void setCardType(String cardType) {
//			this.cardType = cardType;
//		}
//		public String getStatus() {
//			return status;
//		}
//		public void setStatus(String status) {
//			this.status = status;
//		}
//		public String getBankName() {
//			return bankName;
//		}
//		public void setBankName(String bankName) {
//			this.bankName = bankName;
//		}
//		public String getAuthCode() {
//			return authCode;
//		}
//		public void setAuthCode(String authCode) {
//			this.authCode = authCode;
//		}
//		
//	    
//	}	    
//	    
//}
