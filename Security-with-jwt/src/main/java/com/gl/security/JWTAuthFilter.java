package com.gl.security;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//this will be called foe every api request--- to verify tokens
@Component
public class JWTAuthFilter extends OncePerRequestFilter {
    @Autowired
    CustomUserDetailService customUserDetailService;
    @Autowired 
    JWTService jwtService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String authHeader = request.getHeader("Authorization");

        // read token from autthorization head
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;//stop the request
        }
        String jwt = authHeader.substring(7);
        String  username = jwtService.extractUsername(jwt);
        
        //there must be some username
        if (username != null ) {
            UserDetails userDetails = customUserDetailService.loadUserByUsername(username);

            if (jwtService.isTokenValid(jwt, userDetails.getUsername()) && !jwtService.isTokenExpired(jwt)) {
            	//authToken from jwtToken
            	//forwarding the control to the controller
                UsernamePasswordAuthenticationToken authToken =
                        new UsernamePasswordAuthenticationToken(
                                userDetails,
                                null,
                                userDetails.getAuthorities()
                        );
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                //we will read this token from this context in the controller files
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }
        filterChain.doFilter(request, response);
        return;//stop request
		
	}


}
