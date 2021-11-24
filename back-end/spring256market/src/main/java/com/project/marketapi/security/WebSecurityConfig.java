package com.project.marketapi.security;

import com.project.marketapi.security.jwt.AuthEntryPointJwt;
import com.project.marketapi.security.jwt.AuthTokenFilter;
import com.project.marketapi.services.impl.UserDetailsServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
        // securedEnabled = true,
        // jsr250Enabled = true,
        prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @Autowired
    private AuthEntryPointJwt unauthorizedHandler;

    @Bean
    public AuthTokenFilter authenticationJwtTokenFilter() {
        return new AuthTokenFilter();
    }

    @Override
    public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable()
                // Disable csrf to test API, enable at deployment
                .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                
                // Order of antMatchers matters. Go from specific to general
                .authorizeRequests()

                // Creation requests
                .antMatchers("/api/auth/**").anonymous()
                .antMatchers("/api/test/**").permitAll()
                
                .antMatchers(HttpMethod.POST,"/api/categories/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST,"/api/products/**").hasRole("ADMIN")
                
                // Read requests
                .antMatchers(HttpMethod.GET,"/api/categories/**").hasAnyRole("ADMIN", "USER")
                .antMatchers(HttpMethod.GET,"/api/users/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET,"/api/products/**").hasAnyRole("ADMIN", "USER")

                // Update requests
                .antMatchers(HttpMethod.PUT,"/api/categories/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT,"/api/users/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT,"/api/products/**").hasRole("ADMIN")

                // Delete requests
                .antMatchers(HttpMethod.DELETE,"/api/categories/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE,"/api/users/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE,"/api/products/**").hasRole("ADMIN")
                
                // AUTHORIZE ALL OTHER GET REQUESTS CASES
                .antMatchers("/").permitAll()
                .anyRequest().authenticated();
                

        http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
    }
}

