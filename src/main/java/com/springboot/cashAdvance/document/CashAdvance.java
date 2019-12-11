package com.springboot.cashAdvance.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection="cashAdvance")
public class CashAdvance {
	
	@Id
	private String id;
	private String date;
	private String cashAmount;
	private Double tea;
	private int cantShare;
	

}
