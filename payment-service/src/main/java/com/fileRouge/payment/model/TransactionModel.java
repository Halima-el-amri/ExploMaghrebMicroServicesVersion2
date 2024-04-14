package com.fileRouge.payment.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "transaction")
public class TransactionModel {
  @Id
  private Long id;

  @NotNull
  private String bookingNumber;

  private String cardNumber;

  private String cardType;

  private String paymentMode;

  private String bankName;

  private Double amount;

  private LocalDateTime createdAt;
}
