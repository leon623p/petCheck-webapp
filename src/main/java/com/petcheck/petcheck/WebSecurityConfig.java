package com.petcheck.petcheck;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/", "/index", "/api/tasks").permitAll()
                .antMatchers("/css/**", "/js/**","/img/**").permitAll().anyRequest().permitAll()
                .anyRequest().authenticated()
                .and()
                .oauth2Login();
    }
}
