package com.cybage.model;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component

public class Account {
	
	private String accountNumber ;
	private String accountHolderName;
	public CardDetails cardDetails ;
//	private String cardNumber ;
//	private String cardHoldersName ;
//	private Date cardExpirDate;
//	private int cvv;
	


//	public String getCardHoldersName() {
//		return cardHoldersName;
//	}
//
//	public void setCardHoldersName(String cardHoldersName) {
//		this.cardHoldersName = cardHoldersName;
//	}

	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Account(String accountNumber, String accountHolderName, CardDetails cardDetails) {
		super();
		this.accountNumber = accountNumber;
		this.accountHolderName = accountHolderName;
		this.cardDetails = cardDetails;
	}
	

	public Account(String accountNumber, String accountHolderName, String cardNumber, String cardHoldersName,
			Date cardExpirDate, int cvv) {
		super();
		this.accountNumber = accountNumber;
		this.accountHolderName = accountHolderName;
		this.cardDetails = cardDetails;
//		this.cardNumber = cardNumber;
//		this.cardHoldersName = cardHoldersName;
//		this.cardExpirDate = cardExpirDate;
//		this.cvv = cvv;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		
		this.accountNumber = accountNumber;
	}

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}
//	public String getCardNumber() {
//		return cardNumber;
//	}
//
//	public void setCardNumber(String cardNumber) {
//		this.cardNumber = cardNumber;
//	}
//
//	public Date getCardExpirDate() {
//		return cardExpirDate;
//	}
//
//	public void setCardExpirDate(Date date) {
//		this.cardExpirDate = date;
//	}
//
//	public int getCvv() {
//		return cvv;
//	}
//
//	public void setCvv(int cvv) {
//		this.cvv = cvv;
//	}

	public CardDetails getCardDetails() {
		return cardDetails;
	}

	public void setCardDetails(CardDetails cardDetails) {
		this.cardDetails = cardDetails;
	}

	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", accountHolderName=" + accountHolderName + ", cardDetails="
				+ cardDetails + "]";
	}
	

}
