package com.softib.TransactionManager.services;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.softib.TransactionManager.entity.Transaction;
import com.softib.TransactionManager.repositories.TransactionRepository;

@Service
public class TransactionServiceImpl implements ITransactionService{
	
	@Autowired
	TransactionRepository transactionRepository;

	 @Autowired
	 private JavaMailSender emailSender;
	 
	@Override
	public List<Transaction> getAllTransactions() {
		List<Transaction> result = new ArrayList<>();
		transactionRepository.findAll().forEach(result::add);
		return result;
	}

	@Override
	public List<Transaction> getTransactionByAccount() {
		Transaction transaction = new Transaction();
	//	trantransactionRepository.findById(transactionId);
		return null;
	}

	@Override
	public Transaction updateTransaction(Transaction transaction) {
		return transactionRepository.save(transaction);
	}

	@Override
	public Transaction addTransaction(Transaction transaction) {
//		User user = getCurrentUser();
//		user.setActivationKey(Utility.generateActivationKey());
//		userRepository.save(user);
		
        SimpleMailMessage message = new SimpleMailMessage(); 
        message.setFrom("noreply@baeldung.com");
        message.setTo("Haytheem.najjar@gmail.com"); 
        message.setSubject("Transaction réussi"); 
        message.setText(" Your transaction with the amount"+transaction.getAmount()+ " to the accounut "+ transaction.getDebitAccount()+"succeded");
        emailSender.send(message);
		
		transaction.setTransactionDate(new Timestamp(System.currentTimeMillis()));
		return transactionRepository.save(transaction);
	}

	@Override
	public List<Transaction> findTransactionByPeriod(String datedebut, String datefin) {
		return (List<Transaction>) transactionRepository.findTransactionByPeriod(datedebut, datefin);
	}

	@Override
	public List<Transaction> getTransactionsbydate() {
		// TODO Auto-generated method stub
		return null;
	}

}
