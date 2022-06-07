package com.example.api.entities.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class OrderConfirmResponse {

	private String Status;
	private String ApprovalCode;
	
	@JsonCreator
	public OrderConfirmResponse(
			@JsonProperty("status") String status, 
			@JsonProperty("approvalCode") String code) {
		this.Status = status;
		this.ApprovalCode = code;
	
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public String getApprovalCode() {
		return ApprovalCode;
	}

	public void setApprovalCode(String approvalCode) {
		ApprovalCode = approvalCode;
	}
	
	

}