package com.eventpaiger.eventpaigergw.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.oauth2.jwt.NimbusReactiveJwtDecoder;
import org.springframework.security.oauth2.jwt.ReactiveJwtDecoder;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
public class WebSecurityConfig {

    @Value("${eventpaiger.users}")
    private String userPrePath;
    @Value("${eventpaiger.events}")
    private String eventsPrePath;

    private final RsaKeyPublic rsaKeyPublic;

    public WebSecurityConfig(RsaKeyPublic rsaKeyPublic) {
        this.rsaKeyPublic = rsaKeyPublic;
    }

    @Bean
    SecurityWebFilterChain securityFilterChain(ServerHttpSecurity http) {
        JwtAuthenticationConverter jwtAuthenticationConverter = new JwtAuthenticationConverter();
        final String[] WHITE_LIST = {
                eventsPrePath + "/api/v1/events/search/**",
                userPrePath + "/api/auth/**"
        };
        return http
                .csrf(ServerHttpSecurity.CsrfSpec::disable)
                .authorizeExchange(exchanges ->
                        exchanges
                                .pathMatchers(WHITE_LIST).permitAll()
                                .pathMatchers("/api/v1/events/manage/**").authenticated()
                                .anyExchange().authenticated()
                )
                .oauth2ResourceServer(oauth2ResourceServer ->
                        oauth2ResourceServer.jwt(jwt ->
                                jwt.jwtAuthenticationConverter(jwtAuthenticationConverter)
                        )
                )
                .build();
    }

    @Bean
    public ReactiveJwtDecoder jwtDecoder(){
        return NimbusReactiveJwtDecoder.withPublicKey(rsaKeyPublic.publicKey()).build();
    }

}
