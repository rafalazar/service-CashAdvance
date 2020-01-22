package com.rafalazar.bootcamp.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rafalazar.bootcamp.app.client.PersonalClient;
import com.rafalazar.bootcamp.app.document.CashAdvance;
import com.rafalazar.bootcamp.app.dto.PersonalDto;
import com.rafalazar.bootcamp.app.repository.CashAdvanceRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CashAdvanceServiceImpl implements CashAdvanceService{

	@Autowired
	private PersonalClient client;
	
	@Autowired
	private CashAdvanceRepository repo;
	
	@Override
	public Flux<CashAdvance> findAll() {
		return repo.findAll();
	}

	@Override
	public Mono<CashAdvance> findById(String id) {
		return repo.findById(id);
	}

	@Override
	public Mono<CashAdvance> save(CashAdvance cadvance) {
		return repo.save(cadvance);
	}

	@Override
	public Mono<CashAdvance> update(CashAdvance cadvance) {
		return repo.findById(cadvance.getId())
				.map(c -> cadvance)
				.flatMap(repo::save);
	}

	@Override
	public Mono<Void> delete(CashAdvance cadvance) {
		return repo.delete(cadvance);
	}

	@Override
	public Mono<PersonalDto> createById(String id) {
		return client.createById(id);
	}

	@Override
	public Flux<PersonalDto> findAllClients() {
		return client.findAllClients();
	}

	@Override
	public Mono<CashAdvance> amountAdvance(String id) {
		return repo.amountAdvance(id);
	}

//	@Override
//	public Mono<CashAdvance> saveA(Object objeto) {
//		return repo.saveA(objeto);
//	}

}
