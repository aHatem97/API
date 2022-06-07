package com.example.api.entities;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "Orders")
@Access(AccessType.FIELD)

public class Order
{
	
//
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected long orderId;
	
	@ManyToOne(cascade = {CascadeType.MERGE})
	@JoinColumn(name="productId",referencedColumnName="productId")
	protected Product product;
	
	@ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "Order_Product", 
      joinColumns = @JoinColumn(name = "orderId"), 
      inverseJoinColumns = @JoinColumn(name = "productId"))
    private List<Product> products;
	
	@ManyToOne(cascade = {CascadeType.MERGE})
	@JoinColumn(name="customerId",referencedColumnName="customerId")
	protected Customer customer;

	@Column(name = "notes", nullable = false)
	protected String notes;

	@Column(name = "amountpaid", nullable = false)
	protected long amount;
	
	@Column(name = "trxreference", nullable = false, unique = true)
	protected String trxid;
	
	@Column(name = "isDeleted")
	protected boolean isDeleted = Boolean.FALSE;

//

public Order() {
	customer = new Customer();
	product = new Product();
}; //default constructor

public Order(Customer customer,Product product, String note, long amount) 
{
	this.customer = customer;
	this.product = product;
	this.amount = amount;
	this.notes = note;
}

public Order(Customer customer,Product product, String note, long amount, String trx) 
{
	this.customer = customer;
	this.product = product;
	this.amount = amount;
	this.notes = note;
	this.trxid = trx;
}

public String getNotes() 
{
	return notes;
}

public void setNotes(String notes) 
{
	this.notes = notes;
}

public long getAmount() 
{
	return amount;
}

public void setAmount(long amount) 
{
	this.amount = amount;
}

public long getOrderId() 
{
	return orderId;
}

public void setOrderId(long orderId) 
{
	this.orderId = orderId;
}

public Product getProduct()
{
	return product;
}

public void setProduct(Product product) 
{
	this.product = product;
}

public Customer getCustomer() 
{
	return customer;
}

public void setCustomer(Customer customer) 
{
	this.customer = customer;
}

public String getTrxid() 
{
	return trxid;
}

public void setTrxid(String trxid) 
{
	this.trxid = trxid;
}

public boolean isDeleted() 
{
	return isDeleted;
}

public void setDeleted(boolean isDeleted) 
{
	this.isDeleted = isDeleted;
}

@Override
public String toString() 
{
	return "Order [orderId=" + orderId + ", productId=" + product.getProductId() + ","
			+ " customerId=" + customer.getCustomerId() + ", name=" + customer.getName()
			+ ", phoneNumber=" + customer.getPhoneNumber() + "]";
}

}