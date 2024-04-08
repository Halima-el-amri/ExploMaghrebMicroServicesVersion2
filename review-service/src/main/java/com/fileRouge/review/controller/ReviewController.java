package com.fileRouge.review.controller;

import java.util.List;
import javax.validation.Valid;
import com.fileRouge.review.dto.ReviewRequestDto;
import com.fileRouge.review.dto.ReviewResponseDto;
import com.fileRouge.review.message.ResponseMessage;
import com.fileRouge.review.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class ReviewController {

  @Autowired
  private ReviewService reviewService;

  @PostMapping("/review/create")
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseMessage createReview(@Valid @RequestBody ReviewRequestDto reviewRequest) {
    return reviewService.createReview(reviewRequest);
  }

  @PutMapping("/review/update")
  @ResponseStatus(HttpStatus.OK)
  public ResponseMessage updateReview(@Valid @RequestBody ReviewRequestDto reviewRequest) {
    return reviewService.updateReview(reviewRequest);
  }

  @GetMapping("/review/customer/{number}")
  @ResponseStatus(HttpStatus.OK)
  public ReviewResponseDto getReviewDetail(@PathVariable String number) {
    return reviewService.getReviewByCustomerNumber(number);
  }

  @GetMapping("/reviews")
  @ResponseStatus(HttpStatus.OK)
  public List<ReviewResponseDto> getReviewsDetail() {
    return reviewService.getReviews();
  }
}
