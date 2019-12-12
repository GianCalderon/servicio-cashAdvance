package com.springboot.cashAdvance.dto;

import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class CashAdvanceEnterDto {
	
	
	@NotBlank
	private String cashAmount;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private String date;
	
	@NotBlank
	private Double tea;
	
	@NotBlank
	private int cantShare;
	
	private EnterpriseDto holder;
	

}
