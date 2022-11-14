package com.authentication.configurations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import static org.springframework.http.HttpMethod.GET;

/**
 *
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Value("${api.unsecuredURL}")
    private String[] unsecuredURL;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                    // exclude api document end points
                    .antMatchers(GET, unsecuredURL)
                        .permitAll()

                    // authenticate other requests
                    .anyRequest()
                        .authenticated()
                    .and()
                .formLogin()
                    .and()
                .httpBasic();
    }
}
