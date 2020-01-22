package com.rafalazar.bootcamp.app.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.rafalazar.bootcamp.app.document.CashAdvance;

import reactor.core.publisher.Mono;

public interface CashAdvanceRepository extends ReactiveMongoRepository<CashAdvance, String>{

	public Mono<CashAdvance> amountAdvance(String id);
//	public Mono<CashAdvance> saveA(Object objeto);
}
