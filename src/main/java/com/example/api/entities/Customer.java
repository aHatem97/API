package com.example.api.entities;

import java.util.function.BooleanSupplier;

import javax.persistence.*;

@Entity
@Table(name = "Customers")
@Access(AccessType.FIELD)

public class Customer
{
	
//
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected long customerId;
	
	@Column(name = "name", nullable = false, length=128)
	protected String name;
	
	@Column(name = "phoneNumber", nullable = false, length=128, unique=true)
	protected String phoneNumber;

//
    
public Customer() {} //default constructor

public Customer(String name, String phoneNumber) 
{
    this.name = name;
    this.phoneNumber = phoneNumber;
}

public long getCustomerId() 
{
	return customerId;
}

public void setCustomerId(long customerId) 
{
	this.customerId = customerId;
}

public String getName() 
{
	return name;
}

public void setName(String name) 
{
	this.name = name;
}

public String getPhoneNumber() 
{
	return phoneNumber;
}

public void setPhoneNumber(String phoneNumber) 
{
	this.phoneNumber = phoneNumber;
}

@Override
public String toString() 
{
	return "Customer [customerId=" + customerId + ", name=" + name + ", phoneNumber=" + phoneNumber + "]";
}

public BooleanSupplier matches(String customerName) 
{
	// TODO Auto-generated method stub
	return null;
}

}