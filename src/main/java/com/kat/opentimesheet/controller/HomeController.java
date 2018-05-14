package com.kat.opentimesheet.controller;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;

@ViewScoped
@ManagedBean("home")
public class HomeController {
    private String currentPage;
    private String currentTemplate;

    @PostConstruct
    private void init(){
        currentPage = "/admin/login.xhtml";
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
