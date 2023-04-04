package com.owu.spring.services;

import com.owu.spring.models.Car;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import lombok.AllArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MailService {
    private JavaMailSender javaMailSender;
    public void sendEmail(Car car){
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
        try {
            helper.setTo("barert454@gmail.com");
            helper.setText("<h2> Car "+ car.toString() + " was created </h2>", true);
            helper.setFrom(new InternetAddress("barert454@gmail.com"));
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
        javaMailSender.send(mimeMessage);
    }
}
