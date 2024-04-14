package com.fileRouge.Guide.service;

import com.fileRouge.Guide.model.GuideTour;
import com.fileRouge.Guide.repository.GuideTourRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

public class GuideTourServiceTest {

    @Mock
    private GuideTourRepository guideTourRepository;

    @InjectMocks
    private GuideTourService guideTourService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void getAllGuideTours_returnsGuideTourList() {
        GuideTour guideTour1 = new GuideTour();
        GuideTour guideTour2 = new GuideTour();
        List<GuideTour> guideTourList = Arrays.asList(guideTour1, guideTour2);

        when(guideTourRepository.findAll()).thenReturn(guideTourList);

        List<GuideTour> result = guideTourService.getAllGuideTours();

        assertEquals(guideTourList, result);
        verify(guideTourRepository, times(1)).findAll();
    }

    @Test
    public void getGuideTour_withExistingId_returnsGuideTour() {
        GuideTour guideTour = new GuideTour();
        String id = "1";
        guideTour.setId(id);

        when(guideTourRepository.findById(id)).thenReturn(Optional.of(guideTour));

        GuideTour result = guideTourService.getGuideTour(id);

        assertEquals(guideTour, result);
        verify(guideTourRepository, times(1)).findById(id);
    }

    @Test
    public void getGuideTour_withNonExistingId_returnsNull() {
        String id = "1";

        when(guideTourRepository.findById(id)).thenReturn(Optional.empty());

        GuideTour result = guideTourService.getGuideTour(id);

        assertNull(result);
        verify(guideTourRepository, times(1)).findById(id);
    }

    @Test
    public void createGuideTour_savesAndReturnsGuideTour() {
        GuideTour guideTour = new GuideTour();

        when(guideTourRepository.save(guideTour)).thenReturn(guideTour);

        GuideTour result = guideTourService.createGuideTour(guideTour);

        assertEquals(guideTour, result);
        verify(guideTourRepository, times(1)).save(guideTour);
    }

    @Test
    public void updateGuideTour_savesAndReturnsGuideTour() {
        GuideTour guideTour = new GuideTour();
        String id = "1";
        guideTour.setId(id);

        when(guideTourRepository.save(guideTour)).thenReturn(guideTour);

        GuideTour result = guideTourService.updateGuideTour(id, guideTour);

        assertEquals(guideTour, result);
        verify(guideTourRepository, times(1)).save(guideTour);
    }

    @Test
    public void deleteGuideTour_callsDeleteById() {
        String id = "1";

        guideTourService.deleteGuideTour(id);

        verify(guideTourRepository, times(1)).deleteById(id);
    }
}