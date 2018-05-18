package com.kat.opentimesheet.controller;


import com.kat.opentimesheet.common.model.LoggedUser;
import org.springframework.web.context.annotation.SessionScope;

import javax.annotation.ManagedBean;

@SessionScope
@ManagedBean("authority")
public class AuthorityController {
    private LoggedUser loggedUser;

    public LoggedUser getLoggedUser() {
        return loggedUser;
    }

    public void setLoggedUser(LoggedUser loggedUser) {
        this.loggedUser = loggedUser;
    }
}
