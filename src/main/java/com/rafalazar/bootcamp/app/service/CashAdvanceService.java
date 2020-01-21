package com.rafalazar.bootcamp.app.service;

import com.rafalazar.bootcamp.app.document.CashAdvance;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CashAdvanceService {
	
	public Flux<CashAdvance> findAll();
	
	public Mono<CashAdvance> findById(String id);
	
	public Mono<CashAdvance> save(CashAdvance cadvance);
	
	public Mono<CashAdvance> update(CashAdvance cadvance);
	
	public Mono<Void> delete(CashAdvance cadvance);

}
