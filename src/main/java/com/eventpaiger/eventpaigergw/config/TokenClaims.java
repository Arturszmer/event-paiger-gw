package com.eventpaiger.eventpaigergw.config;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class TokenClaims {

    private Collection<GrantedAuthority> authorities;
    @JsonProperty(value = "sub")
    private String username;
    private String email;
    @JsonProperty(value = "event_organizer_id")
    private String eventOrganizerId;
    private String scope;
}
