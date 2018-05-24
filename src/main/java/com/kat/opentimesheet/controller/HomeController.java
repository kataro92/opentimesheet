package com.kat.opentimesheet.controller;

import com.kat.opentimesheet.service.interfaces.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.faces.annotation.ManagedProperty;
import javax.inject.Inject;
import javax.inject.Named;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.enterprise.context.ConversationScoped;
import java.io.IOException;
import java.io.Serializable;

@Named("home")
@ConversationScoped
public class HomeController implements Serializable {
    private String currentPage;
    private String currentTemplate;

    @Inject AuthorityController authorityController;

    @Autowired AuthorityService authorityService;

    @PostConstruct
    private void init(){
        currentPage = "/admin/login.xhtml";
    }

    public void checkAuthenicate() throws IOException {
        if(authorityController.getLoggedUser() == null){
            FacesContext.getCurrentInstance().getExternalContext().redirect("/login");
        }else{
            currentPage = "/pages/dashboard.xhtml";
        }
    }

    public void checkLoggedAuthenicate() throws IOException {
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
