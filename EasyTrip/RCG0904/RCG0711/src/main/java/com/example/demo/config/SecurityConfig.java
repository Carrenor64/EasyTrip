package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig {
    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration authenticationConfiguration)
            throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(requests -> requests

        .antMatchers("/webjars/**", "/css/**", "/img/**", "/js/**").permitAll() 
        .antMatchers("/", "/lugares").permitAll()
        .antMatchers("/valoracion/new/**").hasRole("USER")
        .antMatchers("/valoracion/**").permitAll()
        .antMatchers("/usuario/new/**").permitAll()
        .antMatchers("/pais").permitAll()
        .antMatchers("/pais/new/**").hasRole("ADMIN")
        .antMatchers("/lugares/new/**").hasRole("ADMIN")

        .antMatchers("/usuario/**", "/new/**", "/edit/**", "/delete/**").hasRole("ADMIN")
        .anyRequest().authenticated()
        .and())
        .formLogin(login -> login.loginPage("/login").permitAll())
        .logout(logout -> logout.logoutUrl("/logout").logoutSuccessUrl("/login").permitAll())
        .exceptionHandling(handling -> handling.accessDeniedPage("/accessError"));
        
        return http.build();
    }
}