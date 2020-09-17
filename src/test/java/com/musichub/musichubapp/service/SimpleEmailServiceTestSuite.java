package com.musichub.musichubapp.service;


import com.musichub.musichubapp.domain.Mail;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.times;


import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import java.util.Date;

@RunWith(MockitoJUnitRunner.class)
public class SimpleEmailServiceTestSuite {

    @InjectMocks
    private SimpleEmailService simpleEmailService;

    @Mock
    private JavaMailSender javaMailSender;

    @Test
    public void testSend(){

        //Given

        Mail mail = new Mail("kasia.nowak@o2.pl", "Order", "When will my order arrive?", "andrzej.nowak@o2.pl");

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

        simpleMailMessage.setTo(mail.getMailTo());
        simpleMailMessage.setSubject(mail.getSubject());
        simpleMailMessage.setText(mail.getMessage());
        simpleMailMessage.setCc(mail.getToCC());

        //When

        simpleEmailService.send(mail);

        //Then
        Mockito.verify(javaMailSender,times(1)).send(simpleMailMessage);

    }



}
