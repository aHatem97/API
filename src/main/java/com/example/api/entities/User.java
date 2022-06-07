package com.example.api.entities;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "Users")
@Access(AccessType.FIELD)

public class User
{
	
//
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected long userId;
	
	@Column(name = "username", nullable = false, length=128, unique=true)
	protected String username;
	
	@Column(name = "password", nullable = false)
	protected String password;
	
    @Transient
    private String passwordConfirm;
    
	@OneToMany(mappedBy = "user")
	protected List<Product> products;

    @ManyToMany
    private Set<Role> roles;
    
	@Column(name = "isDeleted")
	protected boolean isDeleted = Boolean.FALSE;

//
public User() {}; //default constructor
public User(User u, String generatedPassword) {}; 

public User(String username, String password) 
{
    this.username = username;
    this.password = password;
}

public static String hashPassword(String password, byte[] salt) 
{
    String generatedPassword = null;
    try 
    {
        MessageDigest md = MessageDigest.getInstance("SHA-512");
        md.update(salt);
        byte[] bytes = md.digest(password.getBytes(StandardCharsets.UTF_8));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) 
        {
            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
        }
        generatedPassword = sb.toString();
    } catch (NoSuchAlgorithmException e) 
    {
        e.printStackTrace();
    }
    return new String(generatedPassword);
}

public static byte[] getSalt() throws NoSuchAlgorithmException 
{
    SecureRandom random = new SecureRandom();
    byte[] salt = new byte[16];
    random.nextBytes(salt);
    return salt;
}

public Long getUserId() 
{
    return userId;
}

public void setUserId(long userID) 
{
    this.userId = userID;
}

public String getUsername() 
{
    return username;
}
public void setUsername(String username) 
{
    this.username = username;
}

public String getPassword()
{
    return password;
}

public void setPassword(String password) 
{
    this.password = password;
}

public Set<Role> getRoles() 
{
	return roles;
}

public void setRoles(Set<Role> roles) 
{
	this.roles = roles;
}

public String getPasswordConfirm() 
{
	return passwordConfirm;
}

public void setPasswordConfirm(String passwordConfirm) 
{
	this.passwordConfirm = passwordConfirm;
}

public boolean isDeleted() 
{
	return isDeleted;
}

public void setDeleted(boolean isDeleted) 
{
	this.isDeleted = isDeleted;
}

}