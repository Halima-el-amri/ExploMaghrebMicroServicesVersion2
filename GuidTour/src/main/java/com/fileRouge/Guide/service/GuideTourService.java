package com.fileRouge.Guide.service;

import com.fileRouge.Guide.model.GuideTour;
import com.fileRouge.Guide.repository.GuideTourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuideTourService {

    private final GuideTourRepository guideTourRepository;

    @Autowired
    public GuideTourService(GuideTourRepository guideTourRepository) {
        this.guideTourRepository = guideTourRepository;
    }

    public List<GuideTour> getAllGuideTours() {
        return guideTourRepository.findAll();
    }

    public GuideTour getGuideTour(String id) {
        return guideTourRepository.findById(id).orElse(null);
    }

    public GuideTour createGuideTour(GuideTour guideTour) {
        return guideTourRepository.save(guideTour);
    }

    public GuideTour updateGuideTour(String id, GuideTour guideTour) {
        guideTour.setId(id);
        return guideTourRepository.save(guideTour);
    }

    public void deleteGuideTour(String id) {
        guideTourRepository.deleteById(id);
    }
}