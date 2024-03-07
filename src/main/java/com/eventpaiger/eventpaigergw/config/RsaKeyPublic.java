package com.eventpaiger.eventpaigergw.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.security.interfaces.RSAPublicKey;

@ConfigurationProperties(prefix = "rsa")
public record RsaKeyPublic(RSAPublicKey publicKey) {
}
