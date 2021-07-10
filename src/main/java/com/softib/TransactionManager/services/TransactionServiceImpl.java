package com.softib.TransactionManager.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softib.TransactionManager.entity.Transaction;
import com.softib.TransactionManager.repositories.TransactionRepository;

@Service
public class TransactionServiceImpl implements ITransactionService{
	
	@Autowired
	TransactionRepository transactionRepository;
	
	@Override
	public List<Transaction> getAllTransactions() {
		List<Transaction> result = new ArrayList<>();
		//transactionRepository.findAll().f
		transactionRepository.findAll().forEach(result::add);
		return result;
	}

	@Override
	public List<Transaction> getTransactionByAccount() {
	//	Transaction transaction = new Transaction();
	//	trantransactionRepository.findById(transactionId);
		return null;
	}

	@Override
	public Transaction updateTransaction(Transaction transaction) {
		return transactionRepository.save(transaction);
	}

	@Override
	public Transaction addTransaction(Transaction transaction) {
		return transactionRepository.save(transaction);
	}

	@Override
	public List<Transaction> getTransactionsbydate() {
		// TODO Auto-generated method stub
		return null;
	}

}
