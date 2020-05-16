package com.wikingowie.myecinema.infrastructure.register.listener;

import com.wikingowie.myecinema.domain.user.UserAccount;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

@Getter
@Setter
public class RegistrationEvent extends ApplicationEvent {

    private UserAccount userAccount;
    private String url;

    public RegistrationEvent(UserAccount userAccount, String url) {
        super(userAccount);
        this.userAccount = userAccount;
        this.url = url;
    }

}
