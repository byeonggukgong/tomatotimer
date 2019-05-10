package com.example.tomatotimer.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();

        http.headers().frameOptions().disable();

        http.authorizeRequests()
            .antMatchers("/**")
            .permitAll();

        http.formLogin()
            .loginPage("/login")
            .loginProcessingUrl("/authenticate")
            .failureUrl("/login?error")
            .defaultSuccessUrl("/")
            .usernameParameter("email")
            .passwordParameter("password")
            .permitAll();

        http.logout()
            .logoutUrl("/logout")
            .logoutSuccessUrl("/")
            .invalidateHttpSession(true)
            .permitAll();
    }
}
