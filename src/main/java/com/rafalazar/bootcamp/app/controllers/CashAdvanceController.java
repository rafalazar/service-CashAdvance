package com.rafalazar.bootcamp.app.controllers;

import java.net.URI;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rafalazar.bootcamp.app.document.CashAdvance;
import com.rafalazar.bootcamp.app.dto.PersonalDto;
import com.rafalazar.bootcamp.app.service.CashAdvanceService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/cashAdvance")
public class CashAdvanceController {
	
	@Autowired
	private CashAdvanceService service;
	
	@GetMapping("/findAll")
	Flux<CashAdvance> findAll(){
		return service.findAll();
	}
	
	@GetMapping("/findById/{id}")
	Mono<CashAdvance> findById(@PathVariable("id") String id){
		return service.findById(id);
	}
	
	@PostMapping("/create")
	public Mono<ResponseEntity<CashAdvance>> create(@RequestBody CashAdvance cadvance){
		if(cadvance.getDateM() == null) {
			cadvance.setDateM(new Date());
		}
		
		return service.save(cadvance)
				.map(c -> ResponseEntity.created(URI.create("/cashAdvance/".concat(c.getId())))
						.contentType(MediaType.APPLICATION_JSON).body(c));
	}
	
	@DeleteMapping("delete/{id}")
	public Mono<ResponseEntity<Void>> delete(@PathVariable String id){
		return service.findById(id).flatMap(c -> {
			return service.delete(c).then(Mono.just(new ResponseEntity<Void>(HttpStatus.NO_CONTENT)));
		}).defaultIfEmpty(new ResponseEntity<Void>(HttpStatus.NOT_FOUND));
	}
	
	@PutMapping("/update/{id}")
	Mono<CashAdvance> update(@PathVariable String id, @RequestBody CashAdvance cadvance) {
		return service.update(cadvance);
	}
	//-------Métodos compartidos------------//
	@GetMapping("/findAllClients")
	Flux<PersonalDto> findAllClients(){
		return service.findAllClients();
	}
	
	@PostMapping("/createById/{id}")
	Mono<CashAdvance> createById(@PathVariable("id") String id){
		
		return service.createById(id).flatMap(c -> {
			return service.save(
					new CashAdvance(c.getName(),3000.0,450.0)
					);
			
		});
	}

}
