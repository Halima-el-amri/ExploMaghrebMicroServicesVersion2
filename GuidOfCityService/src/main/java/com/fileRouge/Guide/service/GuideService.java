package com.fileRouge.Guide.service;

import com.fileRouge.Guide.dto.GuideTourDTO;
import com.fileRouge.Guide.model.Guide;
import com.fileRouge.Guide.repository.GuideRepository;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;


import java.util.List;

@Service
public class GuideService {

    private final GuideRepository guideRepository;
    private final WebClient webClient;

    @Autowired
    public GuideService(GuideRepository guideRepository, WebClient webClient) {
        this.guideRepository = guideRepository;
        this.webClient = webClient;
    }

    public List<Guide> getAllGuides() {
        return guideRepository.findAll();
    }

    public Guide getGuide(String id) {
        return guideRepository.findById(id).orElse(null);
    }

    public Guide createGuide(Guide guide) {
        return guideRepository.save(guide);
    }

    public Guide updateGuide(String id, Guide guide) {
        guide.setId(id);
        return guideRepository.save(guide);
    }

    public void deleteGuide(String id) {

        guideRepository.deleteById(id);
    }



    public Mono<GuideTourDTO> getGuideTour(String guideTourId) {
        try {
            return webClient.get()
                    .uri("http://localhost:8088/api/guideTours/" + guideTourId)
                    .retrieve()
                    .onStatus(HttpStatus::is4xxClientError, response ->
                            Mono.error(new RuntimeException("Client error: " + response.statusCode() + " " + response.statusCode().getReasonPhrase())))
                    .onStatus(HttpStatus::is5xxServerError, response ->
                            Mono.error(new RuntimeException("Server error: " + response.statusCode() + " " + response.statusCode().getReasonPhrase())))
                    .bodyToMono(GuideTourDTO.class);
        } catch (Exception e) {
            throw new RuntimeException("Error occurred while fetching guide tour: " + e.getMessage());
        }
    }
}