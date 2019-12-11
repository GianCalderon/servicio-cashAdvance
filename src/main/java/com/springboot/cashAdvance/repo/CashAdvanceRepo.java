package com.springboot.cashAdvance.repo;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.springboot.cashAdvance.document.CashAdvance;

public interface CashAdvanceRepo extends ReactiveMongoRepository<CashAdvance, String> {

}
