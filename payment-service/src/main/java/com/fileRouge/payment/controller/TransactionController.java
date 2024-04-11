package com.fileRouge.payment.controller;

import javax.validation.Valid;
import com.fileRouge.payment.dto.TransactionRequestDto;
import com.fileRouge.payment.dto.TransactionResponseDto;
import com.fileRouge.payment.model.TransactionModel;
import com.fileRouge.payment.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class TransactionController {

  @Autowired
  private TransactionService transactionService;

  @PostMapping("/transaction")
  @ResponseStatus(HttpStatus.CREATED)
  public TransactionResponseDto cardTransaction(
      @Valid @RequestBody TransactionRequestDto transactionRDto) {
    return transactionService.cardTransaction(transactionRDto);
  }

  @GetMapping("/transaction/{id}")
  @ResponseStatus(HttpStatus.OK)
  public TransactionModel bookingTransaction(@PathVariable Long id) {
    return transactionService.getBookingTransaction(id);
  }
}
