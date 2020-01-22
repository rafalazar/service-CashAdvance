package com.rafalazar.bootcamp.app.document;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
@Document(collection="cashAdvance_clients")
public class CashAdvance {
	
	@Id
	private String id;
	private String nameA;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date dateM;
	private Double totalAvailable;
	private Double amountAdvance;
	
	public CashAdvance() {
		
	}
	
	public CashAdvance(String nameA,Double totalAvailable,Double amountAdvance) {
		this.nameA = nameA;
		this.totalAvailable = totalAvailable;
		this.amountAdvance = amountAdvance;
		total();
	}
	
	public void total() {
		this.totalAvailable = this.totalAvailable - this.amountAdvance;
		this.amountAdvance = 0.0;
	}
	
	

}
