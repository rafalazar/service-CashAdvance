package com.rafalazar.bootcamp.app;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class AppConfig {
	@Bean
	@Qualifier("ms-personal")
	public WebClient getCliente() {
		return WebClient.create("http://localhost:8091/api/personal_clients");
	}
}
