package com.fileRouge.Guide.controller;

import com.fileRouge.Guide.model.GuideTour;
import com.fileRouge.Guide.service.GuideTourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/guideTours")
public class GuideTourController {

    private final GuideTourService guideTourService;

    @Autowired
    public GuideTourController(GuideTourService guideTourService) {
        this.guideTourService = guideTourService;
    }

    @GetMapping
    public List<GuideTour> getAllGuideTours() {
        return guideTourService.getAllGuideTours();
    }

    @GetMapping("/{id}")
    public GuideTour getGuideTour(@PathVariable String id) {
        return guideTourService.getGuideTour(id);
    }

    @PostMapping
    public GuideTour createGuideTour(@RequestBody GuideTour guideTour) {
        return guideTourService.createGuideTour(guideTour);
    }

    @PutMapping("/{id}")
    public GuideTour updateGuideTour(@PathVariable String id, @RequestBody GuideTour guideTour) {
        return guideTourService.updateGuideTour(id, guideTour);
    }

    @DeleteMapping("/{id}")
    public void deleteGuideTour(@PathVariable String id) {
        guideTourService.deleteGuideTour(id);
    }
}