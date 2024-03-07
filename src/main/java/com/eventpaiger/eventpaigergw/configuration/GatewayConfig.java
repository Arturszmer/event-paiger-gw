package com.eventpaiger.eventpaigergw.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Value("${eventpaiger.users}")
    private String usersId;

    @Value("${eventpaiger.events}")
    private String eventsId;

    @Value("${eventpaiger.users.uri}")
    private String usersUri;

    @Value("${eventpaiger.events.uri}")
    private String eventsUri;

    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder){
        return builder.routes()
                .route(usersId, r ->
                        r.path("/eventpaigerusers/api/auth/**", "/eventpaigerusers/api/v1/**")
                                .uri(usersUri))
                .route(eventsId, r ->
                        r.path("/eventpaigerevents/api/v1/**")
                                .uri(eventsUri))
                .build();
    }
}
