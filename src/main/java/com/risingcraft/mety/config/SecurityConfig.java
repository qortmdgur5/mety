package com.risingcraft.mety.config;

import com.risingcraft.mety.config.auth.OrganizationDetailsService;
import com.risingcraft.mety.config.auth.PrincipalDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@RequiredArgsConstructor

public class SecurityConfig {
    private final PrincipalDetailsService principalDetailsService;
    private final OrganizationDetailsService organizationDetailsService;


    @Bean
    public BCryptPasswordEncoder encode() {
        return new BCryptPasswordEncoder();
    }


    @EnableWebSecurity
    @Order(Ordered.HIGHEST_PRECEDENCE)
    class UserSecurityConfig extends WebSecurityConfigurerAdapter {

        @Override
        protected void configure(HttpSecurity http) throws Exception {

            http.csrf().disable();
            http.requestMatchers()
                    .antMatchers("/user/**","/","/api/user/**")
                    .and()
                    .authorizeRequests()
                    .antMatchers("/user/signup", "/org/signup", "/user/login", "/org/login", "/").permitAll()
                    .antMatchers("/user/**").hasAnyRole("USER", "ADMIN", "GUEST")
                    .anyRequest().authenticated()
                    .and()
                    .formLogin()
                    .loginPage("/user/login")
                    .loginProcessingUrl("/user/login")
                    .defaultSuccessUrl("/");
        }

        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth.userDetailsService(principalDetailsService).passwordEncoder(encode());
        }

    }

    @EnableWebSecurity
    class OrgSecurityConfig extends WebSecurityConfigurerAdapter {

        @Override
        protected void configure(HttpSecurity http) throws Exception {

            http.csrf().disable();
            http.requestMatchers()
                    .antMatchers("/org/**","/","/api/org/**")
                    .and()
                    .authorizeRequests()
                    .antMatchers("/user/signup", "/org/signup", "/user/login", "/org/login").permitAll()
                    .antMatchers("/org/**").hasAnyRole("ORG", "PREORG")
                    .anyRequest().authenticated()
                    .and()
                    .formLogin()
                    .usernameParameter("orgname")
                    .passwordParameter("password")
                    .loginPage("/org/login")
                    .loginProcessingUrl("/org/login")
                    .defaultSuccessUrl("/");
        }

        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth.userDetailsService(organizationDetailsService).passwordEncoder(encode());
        }
    }

}



