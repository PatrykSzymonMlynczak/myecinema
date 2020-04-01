package com.wikingowie.myecinema.infrastructure.email.service;

public interface EmailSender {
    void sendEmail(String to, String subject, String content, boolean isHtmlContent);
}
