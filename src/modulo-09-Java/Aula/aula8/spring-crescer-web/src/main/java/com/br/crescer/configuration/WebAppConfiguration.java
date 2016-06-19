package com.br.crescer.configuration;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andrews
 */
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@EnableWebMvc
@Configuration
public class WebAppConfiguration extends WebMvcConfigurerAdapter {
	
	@Bean
	@Description("Spring message resolver")
        public ResourceBundleMessageSource messageSource() {  
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();  
        messageSource.setBasename("messages");  

        return messageSource;  
    }
}
