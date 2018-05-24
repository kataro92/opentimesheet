package com.kat.opentimesheet.controller;


import com.kat.opentimesheet.common.model.LoggedUser;
import com.kat.opentimesheet.service.interfaces.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.enterprise.context.ConversationScoped;
import javax.faces.annotation.ManagedProperty;
import javax.faces.application.FacesMessage;
import javax.inject.Inject;
import javax.inject.Named;
import javax.faces.context.FacesContext;
import java.io.IOException;
import java.io.Serializable;

@Named("login")
@ConversationScoped
public class LoginController implements Serializable {

    private String txtUsername, txtPassword;
    private boolean remember;

    @Inject
    AuthorityController authorityController;

    @Autowired AuthorityService authorityService;

    public void actLogin() throws IOException {
        LoggedUser loggedUser = authorityService.validateUser(getTxtUsername(), getTxtPassword());
        if(loggedUser == null){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Authenticate error!", "Wrong password."));
        }else{
            authorityController.setLoggedUser(loggedUser);
            FacesContext.getCurrentInstance().getExternalContext().redirect("/home");
        }
    }

    public String getTxtUsername() {
        return txtUsername;
    }

    public void setTxtUsername(String txtUsername) {
        this.txtUsername = txtUsername;
    }

    public String getTxtPassword() {
        return txtPassword;
    }

    public void setTxtPassword(String txtPassword) {
        this.txtPassword = txtPassword;
    }

    public boolean isRemember() {
        return remember;
    }

    public void setRemember(boolean remember) {
        this.remember = remember;
    }
}
