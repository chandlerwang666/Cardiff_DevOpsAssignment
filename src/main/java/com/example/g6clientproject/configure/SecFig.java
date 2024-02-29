package com.example.g6clientproject.configure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;


@EnableWebSecurity
@Configuration
public class SecFig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .csrf().disable()
                .authorizeRequests()
                .mvcMatchers("/css/**").permitAll()
                .mvcMatchers("/Welcome/**").hasRole("ADMIN")
                .mvcMatchers("/Application").hasRole("ADMIN")
                .mvcMatchers("/SoftwareTable").hasRole("ADMIN")
                .mvcMatchers("/HardwareView").hasRole("ADMIN")
                .mvcMatchers("/CommentsPage").hasRole("ADMIN")
                .mvcMatchers("/Profile").hasRole("ADMIN")
                .mvcMatchers("/AssetValue").hasRole("ADMIN")
                .mvcMatchers("/AssetTable").hasRole("ADMIN")
                .mvcMatchers("/WelcomeSuper/**").hasRole("SUPER")
                .mvcMatchers("/UserInfo").hasRole("SUPER")
                .and()
                .formLogin()
                .loginPage("/Home")
                .and()
                .logout()
                .logoutSuccessUrl("/");
    }
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
        auth
                .inMemoryAuthentication()
                .withUser("admin").password("{noop}adminlogin").roles("ADMIN")
                .and()
                .withUser("Super").password("{noop}superlogin").roles("SUPER", "ADMIN");
    }
}


