package com.softib.TransactionManager.services;

import java.util.List;

import com.softib.TransactionManager.entity.Transaction;

public interface ITransactionService {
	
	
	public List<Transaction> getAllTransactions();

	public List<Transaction> getTransactionByAccount();
	
	public List<Transaction> getTransactionsbydate();
	
	public Transaction updateTransaction(Transaction transaction);

	public Transaction addTransaction(Transaction transaction);

//	public void deleteTransaction(Transaction transaction);
}
