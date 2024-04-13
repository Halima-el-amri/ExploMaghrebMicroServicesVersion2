//package com.fileRouge.review.service;
//
//import com.fileRouge.review.dto.CustomerResponseDto;
//import com.fileRouge.review.dto.ReviewRequestDto;
//import com.fileRouge.review.message.ResponseMessage;
//import com.fileRouge.review.model.ReviewModel;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.web.reactive.function.client.WebClient;
//import org.springframework.core.env.Environment;
//import com.fileRouge.review.repository.ReviewRepository;
//import com.fileRouge.review.util.JwtToken;
//import reactor.core.publisher.Mono;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.ArgumentMatchers.anyString;
//import static org.mockito.Mockito.*;
//
//@ExtendWith(MockitoExtension.class)
//public class ReviewServiceTest {
//
//    @Mock
//    private ReviewRepository reviewRepository;
//
//    @Mock
//    private WebClient webClient;
//
//    @Mock
//    private Environment env;
//
//    @Mock
//    private JwtToken jwtService;
//
//    @InjectMocks
//    private ReviewService reviewService;
//
//    @Test
//    void testCreateReview() {
//        // Arrange
//        ReviewRequestDto reviewRequest = new ReviewRequestDto("title", "description", 5.0, "customerNumber");
//        CustomerResponseDto customer = new CustomerResponseDto("customerNumber", "firstName", "lastName", "email");
//        when(jwtService.token(anyString())).thenReturn("token");
//        when(env.getProperty(anyString(), anyString())).thenReturn("http://localhost:8080");
//        when(webClient.get().uri(anyString()).retrieve().bodyToMono(CustomerResponseDto.class)).thenReturn(Mono.just(customer));
//        when(reviewRepository.insert(any(ReviewModel.class))).thenReturn(new ReviewModel());
//
//        // Act
//        ResponseMessage response = reviewService.createReview(reviewRequest);
//
//        // Assert
//        assertEquals("success", response.getMessage());
//        verify(reviewRepository, times(1)).insert(any(ReviewModel.class));
//    }
//}
