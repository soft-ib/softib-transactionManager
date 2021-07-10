package com.softib.TransactionManager.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.softib.TransactionManager.entity.Transaction;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Integer>
{

}
