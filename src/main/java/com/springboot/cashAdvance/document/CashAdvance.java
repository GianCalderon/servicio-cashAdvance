package com.springboot.cashAdvance.document;

import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
@Document(collection="cashAdvance")
public class CashAdvance {
	
	@Id
	private String id;
	
	@NotBlank
	private String name; 
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private String date;
	
	@NotBlank
	private String cashAmount;
	
	@NotBlank
	private Double tea;
	
	@NotBlank
	private int cantShare;
	

}
