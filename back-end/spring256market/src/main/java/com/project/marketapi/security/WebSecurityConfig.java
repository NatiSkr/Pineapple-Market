package com.project.marketapi.security;

import com.project.marketapi.services.impl.UsersImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
    
    // Password encoding bean
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }

    // Authentication method with encrypted passwords
    @Autowired
    private BCryptPasswordEncoder bcrypt;

    @Autowired
    private UsersImpl userDetailsService;

    @Override
    protected void configure (AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(userDetailsService).passwordEncoder(bcrypt);
    }

    // Customize login requests
    @Override
    protected void configure (HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .anyRequest().authenticated()
            // Custom template login page
            .and()
            .formLogin()
            .loginPage("/login")
            .permitAll();

    }
    
}

