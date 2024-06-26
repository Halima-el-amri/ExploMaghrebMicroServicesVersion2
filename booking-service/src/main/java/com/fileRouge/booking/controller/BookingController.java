package com.fileRouge.booking.controller;

import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import com.fileRouge.booking.dto.BookingRequestDto;
import com.fileRouge.booking.dto.BookingResponseDto;
import com.fileRouge.booking.dto.BookingTransactionRequestDto;
import com.fileRouge.booking.message.ResponseMessage;
import com.fileRouge.booking.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class BookingController {

  @Autowired
  private BookingService bookingService;

  @PostMapping("/booking")
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseMessage roomBooking(@Valid @RequestBody BookingRequestDto bookingRequest) {
    return bookingService.roomBooking(bookingRequest);
  }

  @GetMapping("/booking/{number}")
  @ResponseStatus(HttpStatus.OK)
  public BookingResponseDto bookingDetail(@PathVariable String number) {
    return bookingService.getBookingByNumber(number);
  }

  @GetMapping("/customer-booked/{number}")
  @ResponseStatus(HttpStatus.OK)
  public Boolean isCustomerBooked(@PathVariable String number) {
    return bookingService.isCustomerBooked(number);
  }

  @GetMapping("/booking")
  @ResponseStatus(HttpStatus.OK)
  public List<BookingResponseDto> customerBookingDetail(@RequestParam Optional<String> number) {
    if (!number.isEmpty()) {
      return bookingService.getBookingByCustomerNumber(number.get());
    }

    return null;
  }

  @PostMapping("/booking/transaction")
  @ResponseStatus(HttpStatus.CREATED)
  public BookingResponseDto bookingTransaction(
      @Valid @RequestBody BookingTransactionRequestDto bookingTransaction) {
    return bookingService.bookingTransaction(bookingTransaction);
  }
}
