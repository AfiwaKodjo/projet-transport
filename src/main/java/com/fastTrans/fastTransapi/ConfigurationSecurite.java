package com.fastTrans.fastTransapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.fastTrans.fastTransapi.service.QuartierService;

@EnableWebSecurity
@Configuration
public class ConfigurationSecurite{

   @Autowired
   QuartierService quartierService;

    @Autowired
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
       auth.inMemoryAuthentication()
                  .withUser("afiwa")
                  .password("soulager")
                  .roles("ADMIN");

    }
    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return NoOpPasswordEncoder.getInstance();       
    }

    @Bean
    protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.authorizeRequests()
        .antMatchers(HttpMethod.GET).permitAll()
        .antMatchers(HttpMethod.POST).permitAll()
        .antMatchers(HttpMethod.DELETE).permitAll()
        .antMatchers(HttpMethod.PUT).permitAll()
        .antMatchers("/api/**","/swagger-ui/**").hasRole("ADMIN")
        .anyRequest().authenticated()
        .and()
        .csrf()
        .disable() 
        .formLogin();
        return http.build();
    }

    
}
