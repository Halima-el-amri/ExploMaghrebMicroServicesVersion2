package com.fileRouge.payment.service;

import com.fileRouge.payment.dto.TransactionRequestDto;
import com.fileRouge.payment.dto.TransactionResponseDto;
import com.fileRouge.payment.model.TransactionModel;
import com.fileRouge.payment.repository.TransactionRepository;

import com.fileRouge.payment.util.JwtToken;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.core.env.Environment;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class TransactionServiceTest {

    @Mock
    private TransactionRepository transactionRepository;

    @Mock
    private WebClient webClient;

    @Mock
    private Environment env;

    @Mock
    private JwtToken jwtService;

    @InjectMocks
    private TransactionService transactionService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }



    @Test
    public void cardTransactionThrowsExceptionWhenBookingNumberInvalid() {
        TransactionRequestDto transactionRDto = new TransactionRequestDto();
        transactionRDto.setBookingNumber("123");
        transactionRDto.setAmount(100.0);

        when(jwtService.token(any(String.class))).thenReturn("token");
        when(env.getProperty(any(String.class), any(String.class))).thenReturn("http://127.0.0.1:8081");
        when(webClient.get()).thenThrow(new WebClientResponseException("Not found", 404, "Not found", null, null, null));

        try {
            transactionService.cardTransaction(transactionRDto);
        } catch (Exception e) {
            assert(e instanceof ResponseStatusException);
        }
    }

    @Test
    public void getBookingTransactionReturnsTransactionModel() {
        TransactionModel transactionModel = new TransactionModel();
        when(transactionRepository.findById(1L)).thenReturn(Optional.of(transactionModel));

        TransactionModel result = transactionService.getBookingTransaction(1L);

        assert(result != null);
    }

    @Test
    public void getBookingTransactionThrowsExceptionWhenTransactionNotFound() {
        when(transactionRepository.findById(1L)).thenReturn(Optional.empty());

        try {
            transactionService.getBookingTransaction(1L);
        } catch (Exception e) {
            assert(e instanceof ResponseStatusException);
        }
    }
}