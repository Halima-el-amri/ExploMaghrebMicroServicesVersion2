package com.fileRouge.review.repository;

import java.util.Optional;
import com.fileRouge.review.model.ReviewModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReviewRepository extends MongoRepository<ReviewModel, String> {

  Optional<ReviewModel> findByCustomerNumber(String customerNumber);
}
