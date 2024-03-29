package com.springboot.cashAdvance.controller;

import java.net.URI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.cashAdvance.document.CashAdvance;
import com.springboot.cashAdvance.dto.CashAdvanceEnterDto;
import com.springboot.cashAdvance.dto.CashAdvancePerDto;
import com.springboot.cashAdvance.service.CashAdvanceInterface;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/cashAdvance")
public class CashAdvanceController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CashAdvanceController.class);


	  @Autowired
	 CashAdvanceInterface service;

	  @GetMapping
	  public Mono<ResponseEntity<Flux<CashAdvance>>> toList() {

	    return Mono.just(ResponseEntity.ok()
	          .contentType(MediaType.APPLICATION_JSON).body(service.findAll()));

	  }

	  @GetMapping("/{id}")
	  public Mono<ResponseEntity<CashAdvance>> search(@PathVariable String id) {

	    return service.findById(id).map(e -> ResponseEntity.ok()
	      .contentType(MediaType.APPLICATION_JSON).body(e))
	      .defaultIfEmpty(ResponseEntity.notFound().build());

	  }

	  @PostMapping
	  public Mono<ResponseEntity<CashAdvance>> save(@RequestBody  CashAdvance  cashAdvance) {


	    return service.save(cashAdvance).map(e -> ResponseEntity.created(URI.create("/api/cashAdvance"))
	                  .contentType(MediaType.APPLICATION_JSON).body(e));

	  }

	  @PutMapping("/{id}")
	  public Mono<ResponseEntity<CashAdvance>> update(@RequestBody CashAdvance cashAdvance,
	                    @PathVariable String id) {

	    return service.update(cashAdvance, id)
	             .map(c -> ResponseEntity.created(URI.create("/api/cashAdvance".concat(c.getId())))
	             .contentType(MediaType.APPLICATION_JSON).body(c))
	             .defaultIfEmpty(ResponseEntity.notFound().build());

	  }

	  @DeleteMapping("/{id}")
	  public Mono<ResponseEntity<Void>> delete(@PathVariable String id) {

	    return service.findById(id).flatMap(c -> {
	      return service.delete(c).then(Mono.just(new ResponseEntity<Void>(HttpStatus.ACCEPTED)));
	    }).defaultIfEmpty(new ResponseEntity<Void>(HttpStatus.NOT_FOUND));

	  }
	  
		@PostMapping("/savePer")
		public Mono<ResponseEntity<CashAdvancePerDto>> saveDto(@RequestBody CashAdvancePerDto cashAdvancePerDto) {

			LOGGER.info(cashAdvancePerDto.toString());

			return service.saveDtoPer(cashAdvancePerDto).map(s -> ResponseEntity.created(URI.create("/api/cashAdvance"))
					.contentType(MediaType.APPLICATION_JSON).body(s));

		}
		@PostMapping("/saveEnter")
		public Mono<ResponseEntity<CashAdvanceEnterDto>> saveDto(@RequestBody CashAdvanceEnterDto cashAdvanceEnterDto) {

			LOGGER.info(cashAdvanceEnterDto.toString());

			return service.saveDtoEnter(cashAdvanceEnterDto).map(s -> ResponseEntity.created(URI.create("/api/cashAdvance"))
					.contentType(MediaType.APPLICATION_JSON).body(s));

		}

}
