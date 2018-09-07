package com.kat.opentimesheet.common.util;

import org.jboss.logging.Logger;

import javax.faces.context.FacesContext;
import java.io.IOException;

public class FacesUtil {
    public static void redirect(String pagePath){
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect(pagePath);
        } catch (IOException e) {
            Logger.getLogger(FacesUtil.class).warn(String.format("Cannot redirect to [{}] case [{}]", pagePath, e.getMessage()));
        }
    }
}
