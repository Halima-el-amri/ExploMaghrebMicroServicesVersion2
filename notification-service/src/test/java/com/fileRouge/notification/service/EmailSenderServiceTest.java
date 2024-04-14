//package com.fileRouge.notification.service;
//
//import com.fileRouge.notification.service.EmailSenderService;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.mail.javamail.MimeMessageHelper;
//import org.springframework.mail.javamail.MimeMessagePreparator;
//import org.thymeleaf.spring5.SpringTemplateEngine;
//import org.thymeleaf.context.Context;
//
//import javax.mail.internet.MimeMessage;
//import java.util.HashMap;
//import java.util.Map;
//
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.*;
//
//class EmailSenderServiceTest {
//
//    @Mock
//    private JavaMailSender emailSender;
//
//    @Mock
//    private SpringTemplateEngine templateEngine;
//
//    @InjectMocks
//    private EmailSenderService emailSenderService;
//
//    @BeforeEach
//    public void setup() {
//        MockitoAnnotations.openMocks(this);
//    }
//
//    @Test
//    public void sendEmailMessageSendsEmail() {
//        Map<String, Object> properties = new HashMap<>();
//        properties.put("key", "value");
//
//        when(templateEngine.process(any(String.class), any(Context.class))).thenReturn("email content");
//
//        emailSenderService.sendEmailMessage("from@test.com", "to@test.com", "subject", "template", properties);
//
//        verify(emailSender, times(1)).send(any(MimeMessagePreparator.class));
//    }
//
//    @Test
//    public void sendEmailMessageThrowsExceptionWhenEmailSendingFails() {
//        Map<String, Object> properties = new HashMap<>();
//        properties.put("key", "value");
//
//        when(templateEngine.process(any(String.class), any(Context.class))).thenReturn("email content");
//        doThrow(new RuntimeException()).when(emailSender).send(any(MimeMessagePreparator.class));
//
//        try {
//            emailSenderService.sendEmailMessage("from@test.com", "to@test.com", "subject", "template", properties);
//        } catch (Exception e) {
//            assert(e instanceof RuntimeException);
//        }
//
//        verify(emailSender, times(1)).send(any(MimeMessagePreparator.class));
//    }
//}