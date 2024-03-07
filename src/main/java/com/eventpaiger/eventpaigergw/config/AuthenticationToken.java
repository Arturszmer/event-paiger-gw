package com.eventpaiger.eventpaigergw.config;

import lombok.Getter;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;

@Getter
public class AuthenticationToken extends JwtAuthenticationToken {

    private final String username;
    private final String email;
    private final String eventOrganizerId;
    private final String scope;

    AuthenticationToken(Jwt jwt, TokenClaims tokenClaims){
        super(jwt, tokenClaims.getAuthorities());
        this.username = tokenClaims.getUsername();
        this.email = tokenClaims.getEmail();
        this.eventOrganizerId = tokenClaims.getEventOrganizerId();
        this.scope = tokenClaims.getScope();
    }
}
