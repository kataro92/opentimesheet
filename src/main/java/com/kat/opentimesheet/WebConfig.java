package com.kat.opentimesheet;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.tuckey.web.filters.urlrewrite.UrlRewriteFilter;

import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;


@EnableWebMvc
@Configuration
@EnableCaching
@ComponentScan(basePackages = {
        "com.kat.opentimesheet.controller",
        "com.kat.opentimesheet.repository"
})
public class WebConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addRedirectViewController("/","/home");
    }

    @Bean
    public UrlRewriteFilter urlRewriteFilter(final ServletContext servletContext) throws ServletException {
        UrlRewriteFilter urlRewriteFilter = new UrlRewriteFilter();
        urlRewriteFilter.init(new FilterConfig() {
            private final Map<String, String> params = new HashMap<String, String>();
            {
                params.put("confPath", "urlrewrite.xml");
            }

            @Override
            public String getFilterName() {
                return "UrlReriteFilter";
            }

            @Override
            public ServletContext getServletContext() {
                return servletContext;
            }

            @Override
            public String getInitParameter(String name) {
                return params.get(name);
            }

            @Override
            public Enumeration<String> getInitParameterNames() {
                return Collections.enumeration(params.keySet());
            }
        });

        return urlRewriteFilter;
    }

}
