package com.example.api.specifications.util;

public class SearchCriteria {
    private String key;
    private String operation;
    private Object value;
    
    public SearchCriteria(String key, String operation, Object value) {
    	this.key = key;
    	this.value = value;
    	this.operation = operation;
    }
    
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	
	public Object getValue() {
		return value;
	}
	public void setValue(Object value) {
		this.value = value;
	}
}
