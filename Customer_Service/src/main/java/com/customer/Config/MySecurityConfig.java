package com.customer.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@Configuration
@EnableWebSecurity

public class MySecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http

                .csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
                .and()

                .authorizeRequests()
                .antMatchers("/customer/customers").permitAll()
                .antMatchers("/customer/**").hasRole("Normal")
                .anyRequest()
                .authenticated()
                .and()

                .formLogin();
    }



    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

          auth.inMemoryAuthentication().withUser("john").password(this.passwordEncoder().encode("durgesh")).roles("Normal");
        auth.inMemoryAuthentication().withUser("miller").password(this.passwordEncoder().encode("millers")).roles("Admin");
    }



    @Bean
    public PasswordEncoder passwordEncoder(){

        return new BCryptPasswordEncoder(10);
    }
}
