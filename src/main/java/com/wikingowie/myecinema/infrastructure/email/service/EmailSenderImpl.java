package com.wikingowie.myecinema.infrastructure.email.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class EmailSenderImpl implements EmailSender {

    private final JavaMailSender javaMailSender;
    private static final Logger LOGGER = LoggerFactory.getLogger(EmailSenderImpl.class);

    public EmailSenderImpl(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Override
    public void sendEmail(String to, String subject, String content, boolean isHtmlContent) {

        MimeMessage mail = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(mail, true);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content, isHtmlContent);
        } catch (MessagingException e) {
            LOGGER.warn(String.format("Email not sended. An exception occured! %s", e.getMessage()));
        }
        javaMailSender.send(mail);
        LOGGER.info("Email was sent successfully!");
    }
}
