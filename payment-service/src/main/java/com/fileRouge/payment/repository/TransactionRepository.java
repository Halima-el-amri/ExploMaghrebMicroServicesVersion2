package com.fileRouge.payment.repository;

import com.fileRouge.payment.model.TransactionModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends MongoRepository<TransactionModel, Long> {

}
