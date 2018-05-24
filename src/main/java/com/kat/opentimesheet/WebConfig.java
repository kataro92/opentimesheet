package com.kat.opentimesheet;

import com.kat.opentimesheet.rewrite.KatRewriteConfiguration;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@Configuration
@EnableCaching
@ComponentScan(basePackages = {
        "com.kat.opentimesheet.controller",
        "com.kat.opentimesheet.repository",
        "com.kat.opentimesheet.rewrite"
})
public class WebConfig {

    @Bean
    public KatRewriteConfiguration katRewriteConfiguration(){
        KatRewriteConfiguration katRewriteConfiguration = new KatRewriteConfiguration();
        return katRewriteConfiguration;
    }

    @Bean
    public ServletContextInitializer servletContextInitializer() {
        return servletContext -> {
            servletContext.setInitParameter("primefaces.THEME", "cupertino");
            servletContext.setInitParameter("com.ocpsoft.pretty.DISABLE_SERVLET_3.0_SUPPORT", "true");
        };
    }

}
