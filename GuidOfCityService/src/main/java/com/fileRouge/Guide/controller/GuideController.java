package com.fileRouge.Guide.controller;


import com.fileRouge.Guide.dto.GuideTourDTO;
import com.fileRouge.Guide.model.Guide;
import com.fileRouge.Guide.service.GuideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/guides")
public class GuideController {

    private final GuideService guideService;

    @Autowired
    public GuideController(GuideService guideService) {
        this.guideService = guideService;
    }


    @GetMapping
    public List<Guide> getAllGuides() {
        return guideService.getAllGuides();
    }

    @GetMapping("/{id}")
    public Guide getGuide(@PathVariable String id) {
        return guideService.getGuide(id);
    }

    @PostMapping
    public Guide createGuide(@RequestBody Guide guide) {
        return guideService.createGuide(guide);
    }

    @PutMapping("/{id}")
    public Guide updateGuide(@PathVariable String id, @RequestBody Guide guide) {
        return guideService.updateGuide(id, guide);
    }

    @DeleteMapping("/{id}")
    public void deleteGuide(@PathVariable String id) {
        guideService.deleteGuide(id);
    }

    @GetMapping("/tours/{guideTourId}")
    public Mono<GuideTourDTO> getGuideTour(@PathVariable String guideTourId) {
        return guideService.getGuideTour(guideTourId);
    }
}

