package com.softib.TransactionManager.entity;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "transaction")
public class Transaction {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int transactionId;
	private String debitAccount;
	private String creditAccount;
	private float amount;
	private String motif;
	private Timestamp transactionDate;
	private String creditcardcodenumber;
	private String chequenumber;
	private int depositorCinNumber;
	private String bankAgenceAdress;
	@Enumerated(EnumType.STRING)
	private DepositType depositType;
	@Enumerated(EnumType.STRING)
	private TransactionType transactionType;
	@Enumerated(EnumType.STRING)
	private WithdrawType withdrawType;
	
	
	
	
	
	
	
public Transaction() {
	// TODO Auto-generated constructor stub
}



public Transaction(int transactionId, String debitAccount, String creditAccount, float amount, String motif,
		Timestamp transactionDate, String creditcardcodenumber, String chequenumber, int depositorCinNumber,
		String bankAgenceAdress, DepositType depositType, TransactionType transactionType, WithdrawType withdrawType) {
	super();
	this.transactionId = transactionId;
	this.debitAccount = debitAccount;
	this.creditAccount = creditAccount;
	this.amount = amount;
	this.motif = motif;
	this.transactionDate = transactionDate;
	this.creditcardcodenumber = creditcardcodenumber;
	this.chequenumber = chequenumber;
	this.depositorCinNumber = depositorCinNumber;
	this.bankAgenceAdress = bankAgenceAdress;
	this.depositType = depositType;
	this.transactionType = transactionType;
	this.withdrawType = withdrawType;
}







public String getDebitAccount() {
	return debitAccount;
}






public void setDebitAccount(String debitAccount) {
	this.debitAccount = debitAccount;
}






public String getCreditAccount() {
	return creditAccount;
}






public void setCreditAccount(String creditAccount) {
	this.creditAccount = creditAccount;
}






public float getAmount() {
	return amount;
}






public void setAmount(float amount) {
	this.amount = amount;
}






public String getMotif() {
	return motif;
}






public void setMotif(String motif) {
	this.motif = motif;
}






public Timestamp getTransactionDate() {
	return transactionDate;
}






public void setTransactionDate(Timestamp transactionDate) {
	this.transactionDate = transactionDate;
}






public TransactionType getTransactionType() {
	return transactionType;
}






public void setTransactionType(TransactionType transactionType) {
	this.transactionType = transactionType;
}






public String getCreditcardcodenumber() {
	return creditcardcodenumber;
}






public void setCreditcardcodenumber(String creditcardcodenumber) {
	this.creditcardcodenumber = creditcardcodenumber;
}






public String getChequenumber() {
	return chequenumber;
}






public void setChequenumber(String chequenumber) {
	this.chequenumber = chequenumber;
}






public int getDepositorCinNumber() {
	return depositorCinNumber;
}






public void setDepositorCinNumber(int depositorCinNumber) {
	this.depositorCinNumber = depositorCinNumber;
}






public DepositType getDepositType() {
	return depositType;
}






public void setDepositType(DepositType depositType) {
	this.depositType = depositType;
}






public WithdrawType getWithdrawType() {
	return withdrawType;
}






public void setWithdrawType(WithdrawType withdrawType) {
	this.withdrawType = withdrawType;
}






public String getBankAgenceAdress() {
	return bankAgenceAdress;
}






public void setBankAgenceAdress(String bankAgenceAdress) {
	this.bankAgenceAdress = bankAgenceAdress;
}






public int getTransactionId() {
	return transactionId;
}



}
