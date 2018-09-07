package com.kat.opentimesheet;

import com.kat.opentimesheet.rewrite.KatRewriteConfiguration;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.primefaces.webapp.filter.FileUploadFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import javax.servlet.DispatcherType;

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
            servletContext.setInitParameter("primefaces.THEME", "omega");
            servletContext.setInitParameter("primefaces.UPLOADER", "commons");
            servletContext.setInitParameter("javax.faces.STATE_SAVING_METHOD", "server");
            servletContext.setInitParameter("com.ocpsoft.pretty.DISABLE_SERVLET_3.0_SUPPORT", "true");
        };
    }
    @Bean
    public ModelMapper modelMapper(){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper;
    }
    @Configuration
    public class MvcConfig extends WebMvcConfigurerAdapter {
        @Override
        public void addResourceHandlers(ResourceHandlerRegistry registry){
            registry.addResourceHandler("/**")
                    .addResourceLocations("/")
                    .setCachePeriod(0);
        }
    }

    @Bean
    public FilterRegistrationBean someFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        FileUploadFilter uploadFilter = new FileUploadFilter();
        registration.setFilter(uploadFilter);
        registration.setDispatcherTypes(DispatcherType.FORWARD);
        return registration;
    }
}
