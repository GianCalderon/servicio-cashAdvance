package com.springboot.cashAdvance.dto;

import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.Id;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class CashAdvancePerDto {
	
	@Id
	private String id;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private String date;
	
	@NotBlank
	private String cashAmount;
	
	@NotBlank
	private Double tea;
	
	@NotBlank
	private int cantShare;
	
	private PersonalDto holder;
	

}
