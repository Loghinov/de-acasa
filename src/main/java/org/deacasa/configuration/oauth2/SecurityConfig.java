package org.deacasa.configuration.oauth2;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfig {


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorizeRequest->authorizeRequest
                        .requestMatchers("/register", "/login").permitAll()
                        .anyRequest().permitAll()
                )
                .formLogin(form->form
                    .loginPage("/login")  // Custom login page
                    .permitAll()
                )
                .logout(LogoutConfigurer::permitAll);
        return http.build();
    }

}





