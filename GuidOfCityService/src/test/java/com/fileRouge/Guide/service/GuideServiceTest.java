package com.fileRouge.Guide.service;

import com.fileRouge.Guide.model.Guide;
import com.fileRouge.Guide.repository.GuideRepository;
import com.fileRouge.Guide.service.GuideService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

class GuideServiceTest {

    @Mock
    private GuideRepository guideRepository;

    @Mock
    private WebClient webClient;

    @InjectMocks
    private GuideService guideService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void getAllGuidesReturnsListOfGuides() {
        Guide guide1 = new Guide();
        Guide guide2 = new Guide();
        when(guideRepository.findAll()).thenReturn(Arrays.asList(guide1, guide2));

        List<Guide> result = guideService.getAllGuides();

        assert(result.size() == 2);
    }

    @Test
    public void getGuideReturnsGuideWhenExists() {
        Guide guide = new Guide();
        when(guideRepository.findById("1")).thenReturn(Optional.of(guide));

        Guide result = guideService.getGuide("1");

        assert(result != null);
    }

    @Test
    public void getGuideReturnsNullWhenDoesNotExist() {
        when(guideRepository.findById("1")).thenReturn(Optional.empty());

        Guide result = guideService.getGuide("1");

        assert(result == null);
    }

    @Test
    public void createGuideReturnsCreatedGuide() {
        Guide guide = new Guide();
        when(guideRepository.save(guide)).thenReturn(guide);

        Guide result = guideService.createGuide(guide);

        assert(result != null);
    }

    @Test
    public void updateGuideReturnsUpdatedGuide() {
        Guide guide = new Guide();
        when(guideRepository.save(guide)).thenReturn(guide);

        Guide result = guideService.updateGuide("1", guide);

        assert(result != null);
    }

    @Test
    public void deleteGuideExecutesWithoutError() {
        doNothing().when(guideRepository).deleteById("1");
        guideService.deleteGuide("1");
        verify(guideRepository, times(1)).deleteById("1");
    }
}