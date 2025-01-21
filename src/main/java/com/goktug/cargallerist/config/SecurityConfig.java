package com.goktug.cargallerist.config;

import com.goktug.cargallerist.handler.AuthEntryPoint;
import com.goktug.cargallerist.jwt.JWTAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    public static final String REGISTER = "/register";
    public static final String AUTHENTICATE = "/authenticate";
    public static final String REFRESH_TOKEN = "/refreshToken";

    @Autowired
    private DaoAuthenticationProvider daoAuthenticationProvider;

    @Autowired
    private AuthEntryPoint authEntryPoint;

    @Autowired
    private JWTAuthenticationFilter jwtAuthenticationFilter;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable) // CSRF yapılandırması
                .authorizeHttpRequests(request ->
                        request
                                .requestMatchers(REGISTER, AUTHENTICATE, REFRESH_TOKEN).permitAll()
                                .anyRequest().authenticated()
                )
                .exceptionHandling(exception ->
                        exception
                                .authenticationEntryPoint(authEntryPoint) // Özel AuthenticationEntryPoint tanımlama
                )
                .sessionManagement(session ->
                        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )
                .authenticationProvider(daoAuthenticationProvider)
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}

