package com.fileRouge.customer.repository;

import java.util.Optional;
import com.fileRouge.customer.model.CustomerModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<CustomerModel, String> {

  Optional<CustomerModel> findByCustNumber(String customerNumber);

  Optional<CustomerModel> findByEmail(String email);
}
