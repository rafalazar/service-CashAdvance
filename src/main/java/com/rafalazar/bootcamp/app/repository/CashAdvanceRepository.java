package com.rafalazar.bootcamp.app.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.rafalazar.bootcamp.app.document.CashAdvance;

public interface CashAdvanceRepository extends ReactiveMongoRepository<CashAdvance, String>{

}
