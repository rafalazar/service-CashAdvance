package com.rafalazar.bootcamp.app.client;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.rafalazar.bootcamp.app.dto.PersonalDto;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PersonalClient {
	
	@Autowired
	@Qualifier("ms-personal")
	private WebClient client;
	
	public Flux<PersonalDto> findAllClients(){
		return client.get().uri("/selectAll")
				.retrieve()
				.bodyToFlux(PersonalDto.class);
	}
	
	public Mono<PersonalDto> createById(String id){
		return client.get().uri("/{id}",Collections.singletonMap("id", id))
				.retrieve()
				.bodyToMono(PersonalDto.class);
	}

}
