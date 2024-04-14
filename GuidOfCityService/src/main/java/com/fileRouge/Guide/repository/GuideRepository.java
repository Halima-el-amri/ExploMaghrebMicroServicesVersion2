package com.fileRouge.Guide.repository;

import com.fileRouge.Guide.model.Guide;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GuideRepository extends MongoRepository<Guide, String> {
}