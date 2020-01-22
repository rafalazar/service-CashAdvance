package com.rafalazar.bootcamp.app.service;

import com.rafalazar.bootcamp.app.document.CashAdvance;
import com.rafalazar.bootcamp.app.dto.PersonalDto;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CashAdvanceService {
	
	public Flux<CashAdvance> findAll();
	
	public Mono<CashAdvance> findById(String id);
	
	public Mono<CashAdvance> save(CashAdvance cadvance);
	
//	public Mono<CashAdvance> saveA(Object objeto);
	
	public Mono<CashAdvance> update(CashAdvance cadvance);
	
	public Mono<Void> delete(CashAdvance cadvance);
	//-------------------------------------------->
	public Mono<PersonalDto> createById(String id);
	
	public Flux<PersonalDto> findAllClients();
	
	// ---------------------------->>>>>>>>>>>
	
	public Mono<CashAdvance> amountAdvance(String id);

}
