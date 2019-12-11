package com.springboot.cashAdvance.service;

import com.springboot.cashAdvance.document.CashAdvance;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CashAdvanceInterface {

	  public Flux<CashAdvance> findAll();
	  
	  public Mono<CashAdvance> findById(String id);
	  
	  public Mono<CashAdvance> save(CashAdvance cashAdvance);
	  
	  public Mono<CashAdvance> update(CashAdvance cashAdvance,String id);
	  
	  public Mono<Void> delete(CashAdvance cashAdvance);
	  
//	  public Mono<CashAdvance> saveDto(CashAdvance cashAdvance);


	
}
