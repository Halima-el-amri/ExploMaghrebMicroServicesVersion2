package com.fileRouge.Guide.repository;

import com.fileRouge.Guide.model.GuideTour;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GuideTourRepository extends MongoRepository<GuideTour,String> {
}
