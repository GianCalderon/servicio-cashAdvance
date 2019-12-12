package com.springboot.cashAdvance.util;

import org.springframework.stereotype.Component;

import com.springboot.cashAdvance.document.CashAdvance;
import com.springboot.cashAdvance.dto.CashAdvanceEnterDto;
import com.springboot.cashAdvance.dto.CashAdvancePerDto;

@Component
public class UtilConvert {
	
	
	public CashAdvance convertCashAdvancePer(CashAdvancePerDto cashAdvancePerDto) {

		CashAdvance  cashAdvance= new CashAdvance();

		cashAdvance.setName("Adelanto-Efectivo-Personal");
		cashAdvance.setCashAmount(cashAdvancePerDto.getCashAmount());
		cashAdvance.setDate(cashAdvancePerDto.getDate());
		cashAdvance.setTea(cashAdvancePerDto.getTea());
		cashAdvance.setCantShare(cashAdvancePerDto.getCantShare());

		return cashAdvance;

	}
	
	public CashAdvance convertCashAdvanceEnter(CashAdvanceEnterDto cashAdvanceEnterDto) {

		CashAdvance  cashAdvance = new CashAdvance();

		cashAdvance.setName("Adelanto-Efectivo-Empresarial");
		cashAdvance.setCashAmount(cashAdvanceEnterDto.getCashAmount());
		cashAdvance.setDate(cashAdvanceEnterDto.getDate());
		cashAdvance.setTea(cashAdvanceEnterDto.getTea());
		cashAdvance.setCantShare(cashAdvanceEnterDto.getCantShare());
		
		return cashAdvance;

	}

}
