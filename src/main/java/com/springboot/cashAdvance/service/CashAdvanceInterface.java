package com.springboot.cashAdvance.service;

import com.springboot.cashAdvance.document.CashAdvance;
import com.springboot.cashAdvance.dto.CashAdvanceEnterDto;
import com.springboot.cashAdvance.dto.CashAdvancePerDto;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CashAdvanceInterface {

	  public Flux<CashAdvance> findAll();
	  
	  public Mono<CashAdvance> findById(String id);
	  
	  public Mono<CashAdvance> save(CashAdvance cashAdvance);
	  
	  public Mono<CashAdvance> update(CashAdvance cashAdvance,String id);
	  
	  public Mono<Void> delete(CashAdvance cashAdvance);
	  
	  public Mono<CashAdvancePerDto> saveDtoPer(CashAdvancePerDto cashAdvancePerDto);
	  
	  public Mono<CashAdvanceEnterDto> saveDtoEnter(CashAdvanceEnterDto cashAdvanceEnterDto);
  

	
	
}
