package com.kat.opentimesheet.controller;


import com.kat.opentimesheet.common.constant.PageConst;
import com.kat.opentimesheet.common.dto.LoggedUser;
import com.kat.opentimesheet.common.dto.LoginReq;
import com.kat.opentimesheet.common.util.FacesUtil;
import com.kat.opentimesheet.common.util.ValidationUtil;
import com.kat.opentimesheet.service.interfaces.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ConversationScoped;
import javax.faces.application.FacesMessage;
import javax.inject.Inject;
import javax.inject.Named;
import javax.faces.context.FacesContext;
import java.io.IOException;
import java.io.Serializable;

@Named("cLogin")
@ConversationScoped
public class LoginController implements Serializable {

    private LoginReq login;

    @Inject
    AuthorityController authorityController;

    @Autowired
    AuthorityService authorityService;

    @PostConstruct
    private void init(){
        login = new LoginReq();
    }

    public void actLogin() {
        LoggedUser loggedUser = authorityService.validateUser(login.getUsername(), login.getPassword());
        if(ValidationUtil.isEmpty(loggedUser)){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Authenticate error!", "Wrong password."));
        }else{
            authorityController.setLoggedUser(loggedUser);
            FacesUtil.redirect(PageConst.HOME_PAGE);
        }
    }

    public void actClear() {
        login = new LoginReq();
    }

    public LoginReq getLogin() {
        return login;
    }

    public void setLogin(LoginReq login) {
        this.login = login;
    }
}
