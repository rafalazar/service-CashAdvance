package com.rafalazar.bootcamp.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rafalazar.bootcamp.app.document.CashAdvance;
import com.rafalazar.bootcamp.app.repository.CashAdvanceRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CashAdvanceServiceImpl implements CashAdvanceService{

	@Autowired
	private CashAdvanceRepository repo;
	
	@Override
	public Flux<CashAdvance> findAll() {
		return null;
	}

	@Override
	public Mono<CashAdvance> findById(String id) {
		return null;
	}

	@Override
	public Mono<CashAdvance> save(CashAdvance cadvance) {
		return null;
	}

	@Override
	public Mono<CashAdvance> update(CashAdvance cadvance) {
		return null;
	}

	@Override
	public Mono<Void> delete(CashAdvance cadvance) {
		return null;
	}

}
