package com.example.api.entities;

import javax.persistence.*;

@Entity
@Table(name = "Products")
@Access(AccessType.FIELD)

public class Product
{
	
//
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected long productId;
	
	@Column(name = "posTerminalId", length=128, unique=true)
	protected String posTerminalId;
	
	@Column(name = "productName", nullable = false)
	protected String productName;
	
	@Column(name = "price", nullable = false)
	protected long price;
	
	@Column(name = "isReservable", nullable = false)
	protected boolean isReservable;
	
	@Column(name = "isPayable", nullable = false)
	protected boolean isPayable;
	
	@ManyToOne
	@JoinColumn(name="userId", referencedColumnName="userId")
	protected User user;
	
	@Column(name = "isDeleted")
	protected boolean isDeleted = Boolean.FALSE;

//

public Product() {}; //default constructor    

public Product(String productName, long price, String posTerminalId, boolean isReservable, boolean isPayable, User user) 
{
    this.productName = productName;
    this.price = price;
    this.posTerminalId = posTerminalId;
    this.isReservable = isReservable;
    this.isPayable = isPayable;
    this.user = user;
}

public long getProductId() 
{
	return productId;
}

public void setProductId(long productId) 
{
	this.productId = productId;
}

public String getProductName() 
{
	return productName;
}

public void setProductName(String productName) 
{
	this.productName = productName;
}

public long getPrice() 
{
	return price;
}

public void setPrice(long price) 
{
	this.price = price;
}

public boolean getIsReservable() 
{
	return isReservable;
}

public void setIsReservable(boolean isReservable) 
{
	this.isReservable = isReservable;
}

public boolean getIsPayable() 
{
	return isPayable;
}

public void setIsPayable(boolean isPayable) 
{
	this.isPayable = isPayable;
}

public String getPosTerminalId() 
{
	return posTerminalId;
}

public void setPosTerminalId(String posTerminalId) 
{
	this.posTerminalId = posTerminalId;
}

public User getUser() 
{
	return user;
}

public void setUser(User user) 
{
	this.user = user;
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
	return "Product [productId=" + productId + ", posTerminalId=" + posTerminalId + ", productName=" + productName
			+ ", price=" + price + ", isReservable=" + isReservable + ", isPayable=" + isPayable + ", user=" + user
			+"]";
}

}