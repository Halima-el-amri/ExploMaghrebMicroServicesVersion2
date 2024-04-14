import com.fileRouge.review.dto.CustomerResponseDto;
import com.fileRouge.review.dto.ReviewRequestDto;
import com.fileRouge.review.dto.ReviewResponseDto;
import com.fileRouge.review.model.ReviewModel;
import com.fileRouge.review.repository.ReviewRepository;
import com.fileRouge.review.service.ReviewService;
import com.fileRouge.review.util.JwtToken;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.core.env.Environment;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class ReviewServiceTest {

    @Mock
    private ReviewRepository reviewRepository;

    @Mock
    private WebClient webClient;

    @Mock
    private Environment env;

    @Mock
    private JwtToken jwtService;

    @InjectMocks
    private ReviewService reviewService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

//    @Test
//    public void createReviewReturnsSuccessMessage() {
//        ReviewRequestDto reviewRequest = new ReviewRequestDto();
//        reviewRequest.setCustomerNumber("123");
//        reviewRequest.setTitle("Title");
//        reviewRequest.setDescription("Description");
//        reviewRequest.setRate(5.0);
//
//        when(jwtService.token(any(String.class))).thenReturn("token");
//        when(env.getProperty(any(String.class), any(String.class))).thenReturn("http://127.0.0.1:8080");
//        when(webClient.get()).thenReturn(mock(WebClient.RequestHeadersUriSpec.class));
//        when(reviewRepository.insert(any(ReviewModel.class))).thenReturn(new ReviewModel());
//
//        var result = reviewService.createReview(reviewRequest);
//
//        assert(result.getMessage().equals("success"));
//    }

    @Test
    public void updateReviewReturnsSuccessMessage() {
        ReviewRequestDto reviewRequest = new ReviewRequestDto();
        reviewRequest.setCustomerNumber("123");
        reviewRequest.setTitle("Title");
        reviewRequest.setDescription("Description");
        reviewRequest.setRate(5.0);

        when(reviewRepository.findByCustomerNumber(any(String.class))).thenReturn(Optional.of(new ReviewModel()));
        when(reviewRepository.save(any(ReviewModel.class))).thenReturn(new ReviewModel());

        var result = reviewService.updateReview(reviewRequest);

        assert(result.getMessage().equals("success"));
    }

    @Test
    public void getReviewByCustomerNumberReturnsReviewResponseDto() {
        when(reviewRepository.findByCustomerNumber(any(String.class))).thenReturn(Optional.of(new ReviewModel()));

        ReviewResponseDto result = reviewService.getReviewByCustomerNumber("123");

        assert(result != null);
    }

    @Test
    public void getReviewsReturnsListOfReviewResponseDto() {
        when(reviewRepository.findAll()).thenReturn(Arrays.asList(new ReviewModel(), new ReviewModel()));

        List<ReviewResponseDto> result = reviewService.getReviews();

        assert(result.size() == 2);
    }

    @Test
    public void deleteReviewReturnsSuccessMessage() {
        when(reviewRepository.findByCustomerNumber(any(String.class))).thenReturn(Optional.of(new ReviewModel()));
        doNothing().when(reviewRepository).delete(any(ReviewModel.class));

        var result = reviewService.deleteReview("123");

        assert(result.getMessage().equals("Review deleted successfully"));
    }
}