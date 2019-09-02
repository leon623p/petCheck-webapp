package com.petcheck.petcheck;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.security.Principal;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
//todo alot of these will not be needed but keeping this for now
    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/home").setViewName("home");
//        registry.addViewController("/").setViewName("home");
//        registry.addViewController("/hello").setViewName("hello");
//        registry.addViewController("/login").setViewName("login");
//        registry.addViewController("/tasks").setViewName("tasks")



    }

    @RequestMapping(value = "/username", method = RequestMethod.GET)

    @ResponseBody

    public String currentUserName(Principal principal) {

        return principal.getName();

    }

}

