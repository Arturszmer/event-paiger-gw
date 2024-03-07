package com.eventpaiger.eventpaigergw.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.oauth2.jwt.Jwt;
import reactor.core.publisher.Mono;

@Configuration
public class JwtAuthenticationConverter implements Converter<Jwt, Mono<AbstractAuthenticationToken>>{

    @Override
    public Mono<AbstractAuthenticationToken> convert(Jwt jwt){

        TokenClaims tokenClaims = TokenAssembler.mapTokenClaims(jwt.getClaims());

        return Mono.just(new AuthenticationToken(jwt, tokenClaims));
    }
}
