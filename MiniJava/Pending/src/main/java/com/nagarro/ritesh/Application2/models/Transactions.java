package com.nagarro.ritesh.Application2.models;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "transactions")
public class Transactions {
	
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
		public Long id; 
		@Column(name="account_number")
		public String accountNumber;
		@Column(name="transaction_id")
		public String transactionId;
		@Column(name="status")
		public String status;
		@Column(name="amt")
		public String amt;
		@Column(name="date")
		public String date;
		
		
		
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getAccountNumber() {
			return accountNumber;
		}
		public void setAccountNumber(String accountNumber) {
			this.accountNumber = accountNumber;
		}
		public String getTransactionId() {
			return transactionId;
		}
		public void setTransactionId(String transactionId) {
			this.transactionId = transactionId;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public String getAmt() {
			return amt;
		}
		public void setAmt(String amt) {
			this.amt = amt;
		}
		public String getDate() {
			return date;
		}
		public void setDate(String date) {
			this.date = date;
		}
		
		

}
