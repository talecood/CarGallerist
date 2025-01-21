package com.goktug.cargallerist.jwt;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.goktug.cargallerist.config.SecurityConfig;
import com.goktug.cargallerist.exception.BaseException;
import com.goktug.cargallerist.exception.ErrorMessage;
import com.goktug.cargallerist.exception.MessageType;

import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JWTAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String requestPath = request.getRequestURI();
        if (requestPath.equals(SecurityConfig.REGISTER) || requestPath.equals(SecurityConfig.AUTHENTICATE)) {
            filterChain.doFilter(request, response);
            return;
        }

        String header = request.getHeader("Authorization");
        if (header == null || !header.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }

        String token = header.substring(7);
        try {
            String username = jwtService.getUsernameByToken(token);
            if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                UserDetails userDetails = userDetailsService.loadUserByUsername(username);
                if (userDetails != null && jwtService.isTokenValid(token)) {
                    UsernamePasswordAuthenticationToken authenticationToken = new
                            UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                }
            }
        } catch (ExpiredJwtException ex) {
            throw new BaseException(new ErrorMessage(ex.getMessage(), MessageType.TOKEN_IS_EXPIRED));
        } catch (Exception e) {
            throw new BaseException(new ErrorMessage(e.getMessage(), MessageType.GENERAL_EXCEPTION));
        }
        filterChain.doFilter(request, response);
    }
}


