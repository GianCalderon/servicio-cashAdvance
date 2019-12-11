package com.springboot.cashAdvance.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.cashAdvance.document.CashAdvance;
import com.springboot.cashAdvance.repo.CashAdvanceRepo;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CashAdvanceImpl implements CashAdvanceInterface {

	@Autowired
	CashAdvanceRepo repo;
	
	
	@Override
	public Flux<CashAdvance> findAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Mono<CashAdvance> findById(String id) {
		// TODO Auto-generated method stub
		return repo.findById(id);
	}

	@Override
	public Mono<CashAdvance> save(CashAdvance cashAdvance) {
		// TODO Auto-generated method stub
		return repo.save(cashAdvance);
	}

	@Override
	public Mono<CashAdvance> update(CashAdvance cashAdvance, String id) {
		// TODO Auto-generated method stub
	    return repo.findById(id).flatMap(c -> {

	    	c.setCashAmount(cashAdvance.getCashAmount());
	    	c.setCantShare(cashAdvance.getCantShare());
	    	c.setDate(cashAdvance.getDate());
	    	c.setTea(cashAdvance.getTea());
	    	
	        return repo.save(c);

	      });
	}

	@Override
	public Mono<Void> delete(CashAdvance cashAdvance) {
		// TODO Auto-generated method stub
		return repo.delete(cashAdvance);
	}

}
