package com.cbastos.email_ms.services;

import com.cbastos.email_ms.enums.StatusEmail;
import com.cbastos.email_ms.models.EmailModel;
import com.cbastos.email_ms.repositories.EmailRepository;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class EmailService {

    private final EmailRepository emailRepository;
    public EmailService(EmailRepository emailRepository, JavaMailSender emailSender) {
        this.emailRepository = emailRepository;
        this.emailSender = emailSender;
    }

    private final JavaMailSender emailSender;


    public EmailModel sendEmail(EmailModel emailModel) {

        emailModel.setSendDateEmail(LocalDateTime.now());
        try{
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(emailModel.getEmailFrom());
            message.setTo(emailModel.getEmailTo());
            message.setSubject(emailModel.getSubject());
            message.setText(emailModel.getText());
            emailSender.send(message);

            emailModel.setStatusEmail(StatusEmail.SENT);
        }catch (MailException e){
            emailModel.setStatusEmail(StatusEmail.ERROR);
            System.out.println(e);
        }finally {
            return emailRepository.save(emailModel);
        }
    }
}
