package com.example.api.entities.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class OrderConfirmRequest {
	
	private long UserId;
	private long amount;
	private long product_id;
	private String notes;
	private String trx_id;
	
	@JsonCreator
	public OrderConfirmRequest(
			@JsonProperty("user_id") long UID, 
			@JsonProperty("amount") long amount, 
			@JsonProperty("product_id") long productid, 
			@JsonProperty("notes") String notes, 
			@JsonProperty("trx_id") String trxid) {
		this.UserId = UID;
		this.amount = amount;
		this.product_id = productid;
		this.notes = notes;
		this.trx_id = trxid;
	}
	
	public long getUserId() {
		return UserId;
	}
	public void setUserId(long userId) {
		UserId = userId;
	}
	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
	}
	public long getProduct_id() {
		return product_id;
	}
	public void setProduct_id(long product_id) {
		this.product_id = product_id;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public String getTrx_id() {
		return trx_id;
	}
	public void setTrx_id(String trx_id) {
		this.trx_id = trx_id;
	}

}
