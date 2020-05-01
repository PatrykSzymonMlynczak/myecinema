package com.wikingowie.myecinema.infrastructure.register.listener;

import com.wikingowie.myecinema.infrastructure.email.dto.EmailFields;
import com.wikingowie.myecinema.infrastructure.email.dto.TemplateFields;
import com.wikingowie.myecinema.infrastructure.email.service.EmailSender;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import java.util.Collections;
import java.util.Map;

@Component
@PropertySource("classpath:messages.properties")
public class RegistrationListener {

    private final EmailSender emailSender;

    @Value("${registration.email.subject}")
    private String subject;

    @Value("${registration.confirm.url}")
    private String url;

    @Value("${registration.email.template.name}")
    private String templateName;

    @Value("${registration.email.content}")
    private String content;

    public RegistrationListener(EmailSender emailSender) {
        this.emailSender = emailSender;
    }

    @EventListener
    public void handleRegistrationEvent(RegistrationEvent registrationEvent) {
        confirmRegistration(registrationEvent);
    }

    private void confirmRegistration(RegistrationEvent registrationEvent) {
        EmailFields emailFields = buildEmailFields(registrationEvent);
        emailSender.sendEmail(emailFields);
    }

    private EmailFields buildEmailFields(RegistrationEvent registrationEvent) {
        String recipientAddress = registrationEvent.getUserAccount().getEmail();
        Map<String, Object> variables = Map.of("content", urlBuilder(registrationEvent));
        TemplateFields templateFields = new TemplateFields(variables, templateName);
        return new EmailFields(Collections.singletonList(recipientAddress), subject, templateFields);
    }

    private String urlBuilder(RegistrationEvent registrationEvent) {
        return new StringBuilder().append(content)
                .append(registrationEvent.getUrl())
                .append(url)
                .append(registrationEvent.getUserAccount().getActivationToken())
                .toString();
    }

}
