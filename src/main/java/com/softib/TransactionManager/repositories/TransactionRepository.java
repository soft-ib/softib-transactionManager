package com.softib.TransactionManager.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.softib.TransactionManager.entity.Transaction;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Integer>
{
	@Query("SELECT u FROM Transaction u WHERE u.transactionDate>datedebut and u.transactionDate<datefin")
    public Transaction findTransactionByPeriod(@Param("datedebut")String datedebut,@Param("datefin")String datefin);
}
