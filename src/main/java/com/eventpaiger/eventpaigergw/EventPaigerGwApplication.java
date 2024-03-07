package com.eventpaiger.eventpaigergw;

import com.eventpaiger.eventpaigergw.config.RsaKeyPublic;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(RsaKeyPublic.class)
public class EventPaigerGwApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventPaigerGwApplication.class, args);
	}

}
