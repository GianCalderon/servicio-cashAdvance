package com.springboot.cashAdvance.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.cashAdvance.client.EnterpriseClient;
import com.springboot.cashAdvance.client.PersonalClient;
import com.springboot.cashAdvance.document.CashAdvance;
import com.springboot.cashAdvance.dto.CashAdvanceEnterDto;
import com.springboot.cashAdvance.dto.CashAdvancePerDto;
import com.springboot.cashAdvance.repo.CashAdvanceRepo;
import com.springboot.cashAdvance.util.UtilConvert;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CashAdvanceImpl implements CashAdvanceInterface {

	
	private static final Logger LOGGER = LoggerFactory.getLogger(CashAdvanceImpl.class);
	
	@Autowired
	CashAdvanceRepo repo;
	
	@Autowired
	UtilConvert convert;
	
	@Autowired
	PersonalClient webClientPer;
	
	@Autowired
	EnterpriseClient webClientEnter;
	
	
	
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
	
	@Override
	public Mono<CashAdvancePerDto> saveDtoPer(CashAdvancePerDto cashAdvancePerDto) {
	

		LOGGER.info("service:"+cashAdvancePerDto.toString());

		return save(convert.convertCashAdvancePer(cashAdvancePerDto)).flatMap(sa -> {

			cashAdvancePerDto.getHolder().setIdCuenta(sa.getId());
			webClientPer.save(cashAdvancePerDto.getHolder()).block();
			

			return Mono.just(cashAdvancePerDto);
		});
	}

	@Override
	public Mono<CashAdvanceEnterDto> saveDtoEnter(CashAdvanceEnterDto cashAdvanceEnterDto) {
		
		
		LOGGER.info("service:"+cashAdvanceEnterDto.toString());

		return save(convert.convertCashAdvanceEnter(cashAdvanceEnterDto)).flatMap(sa -> {

			cashAdvanceEnterDto.getHolder().setIdCuenta(sa.getId());
			cashAdvanceEnterDto.getHolder().setNameAccount(sa.getName());
			webClientEnter.save(cashAdvanceEnterDto.getHolder()).block();
			

			return Mono.just(cashAdvanceEnterDto);
		});
		
		
	}

}
