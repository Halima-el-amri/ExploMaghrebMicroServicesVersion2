package com.fileRouge.booking.service;

import com.fileRouge.booking.dto.BookingRequestDto;
import com.fileRouge.booking.model.BookingModel;
import com.fileRouge.booking.repository.BookingRepository;
import com.fileRouge.booking.service.BookingService;
import com.fileRouge.booking.util.JwtToken;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.core.env.Environment;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class BookingServiceTest {

    @Mock
    private BookingRepository bookingRepository;

    @Mock
    private WebClient webClient;

    @Mock
    private Environment env;

    @Mock
    private JwtToken jwtService;

    @InjectMocks
    private BookingService bookingService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

//    @Test
//    public void roomBooking_returnsSuccessMessage() {
//        BookingRequestDto bookingRequest = new BookingRequestDto();
//        bookingRequest.setCustomerNumber("12345678");
//        bookingRequest.setRoomNumber(1L);
//        bookingRequest.setCheckIn("2024-09-01");
//        bookingRequest.setCheckOut("2024-09-02");
//        bookingRequest.setRoomPrice(100L);
//
//        when(bookingRepository.insert(any(BookingModel.class))).thenReturn(new BookingModel());
//
//        assertEquals("booking success", bookingService.roomBooking(bookingRequest).getMessage());
//    }
//
//    @Test
//    public void roomBooking_throwsExceptionWhenBookingNumberExists() {
//        BookingRequestDto bookingRequest = new BookingRequestDto();
//        bookingRequest.setCustomerNumber("12345678");
//        bookingRequest.setRoomNumber(203L);
//        bookingRequest.setCheckIn("2024-09-01");
//        bookingRequest.setCheckOut("2024-09-02");
//        bookingRequest.setRoomPrice((long) 100.0);
//
//        when(bookingRepository.insert(any(BookingModel.class))).thenThrow(new WebClientResponseException(409, "Conflict", null, null, null));
//
//        assertThrows(WebClientResponseException.class, () -> bookingService.roomBooking(bookingRequest));
//    }

    @Test
    public void getBookingByNumber_returnsBookingResponseDto() {
        String bookingNumber = "12345678";
        BookingModel booking = new BookingModel();
        booking.setBookingNumber(bookingNumber);

        when(bookingRepository.findByBookingNumber(bookingNumber)).thenReturn(Optional.of(booking));

        assertEquals(bookingNumber, bookingService.getBookingByNumber(bookingNumber).getBookingNumber());
    }

    @Test
    public void getBookingByCustomerNumber_returnsBookingResponseDtoList() {
        String customerNumber = "12345678";
        BookingModel booking1 = new BookingModel();
        booking1.setCustomerNumber(customerNumber);
        BookingModel booking2 = new BookingModel();
        booking2.setCustomerNumber(customerNumber);
        List<BookingModel> bookings = Arrays.asList(booking1, booking2);

        when(bookingRepository.findByCustomerNumber(customerNumber)).thenReturn(bookings);

        assertEquals(2, bookingService.getBookingByCustomerNumber(customerNumber).size());
    }

    @Test
    public void isCustomerBooked_returnsTrueWhenCustomerHasBooked() {
        String customerNumber = "12345678";
        BookingModel booking = new BookingModel();
        booking.setCustomerNumber(customerNumber);
        booking.setStatus("BOOKED");
        List<BookingModel> bookings = Arrays.asList(booking);

        when(bookingRepository.findByCustomerNumber(customerNumber)).thenReturn(bookings);

        assertEquals(true, bookingService.isCustomerBooked(customerNumber));
    }

    @Test
    public void isCustomerBooked_returnsFalseWhenCustomerHasNotBooked() {
        String customerNumber = "12345678";
        BookingModel booking = new BookingModel();
        booking.setCustomerNumber(customerNumber);
        booking.setStatus("NOT_BOOKED");
        List<BookingModel> bookings = Arrays.asList(booking);

        when(bookingRepository.findByCustomerNumber(customerNumber)).thenReturn(bookings);

        assertEquals(false, bookingService.isCustomerBooked(customerNumber));
    }
}