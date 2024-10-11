package com.sosauto_backend.filter;




import com.sosauto_backend.service.Interface.IPersonneService;
import com.sosauto_backend.service.securitySevice.JwtService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {


    private final JwtService jwtService;
    private final IPersonneService userServiceImpl;

    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request,
                                    @NonNull HttpServletResponse response,
                                    @NonNull FilterChain filterChain) throws ServletException, IOException {

        String authHeader = request.getHeader("Authorization");

        if(authHeader == null || !authHeader.startsWith("Bearer ")){
            filterChain.doFilter(request,response);
            return;
        }

        String token = authHeader.substring("Bearer ".length());
        String numTelephone = jwtService.extractnumTelephone(token);

        if(numTelephone != null && SecurityContextHolder.getContext().getAuthentication() == null){
            UserDetails userDetails = userServiceImpl.loadUserByUsername(numTelephone);

            // Validate the token
            if(jwtService.isValid(token,userDetails)){
                // Create authentication token
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                        userDetails,null,userDetails.getAuthorities()
                );
                // Set authentication details
                authToken.setDetails(
                        new WebAuthenticationDetailsSource().buildDetails(request)
                );
                // Set the authentication token in the security context
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }
        // Continue filter chain
        filterChain.doFilter(request,response);

    }
}
