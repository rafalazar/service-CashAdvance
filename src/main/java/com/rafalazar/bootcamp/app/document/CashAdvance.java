package com.rafalazar.bootcamp.app.document;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection="cashAdvance_clients")
public class CashAdvance {
	
	@Id
	private String id;
	private String nameA;
	private Date dateM;
	private Double totalAvailable;
	private Double amountAdvance;
	
	public CashAdvance() {
		
	}
	
	public CashAdvance(String nameA,Double totalAvailable) {
		this.nameA = nameA;
		this.totalAvailable = totalAvailable;
	}
	
	//Restamos lo solicitado a la cantidad existente.
	
	public CashAdvance(Double amountAdvance) {
		this.amountAdvance = amountAdvance;
		totalAvailable = totalAvailable - amountAdvance;
	}
	

}
