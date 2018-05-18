package com.kat.opentimesheet.controller;

import com.kat.opentimesheet.service.interfaces.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import java.io.IOException;

@ViewScoped
@ManagedBean("home")
public class HomeController {
    private String currentPage;
    private String currentTemplate;

    @Autowired
    AuthorityController authorityController;

    @Autowired
    AuthorityService authorityService;

    @PostConstruct
    private void init(){
        currentPage = "/admin/login.xhtml";
    }

    public void checkAuthenicate() throws IOException {
        if(authorityController.getLoggedUser() == null){
            FacesContext.getCurrentInstance().getExternalContext().redirect("/login");
        }
    }

    public String getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(String currentPage) {
        this.currentPage = currentPage;
    }

    public String getCurrentTemplate() {
        if(currentTemplate == null){
            currentTemplate = "default";
        }
        return currentTemplate;
    }

    public void setCurrentTemplate(String currentTemplate) {
        this.currentTemplate = currentTemplate;
    }
}
