package com.kat.opentimesheet.controller;


import com.kat.opentimesheet.service.interfaces.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.ManagedBean;
import javax.faces.view.ViewScoped;

@ViewScoped
@ManagedBean("login")
public class LoginController {

    @Autowired
    AuthorityService authorityService;

}
