package com.example.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.api.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product>
{
	@Query("SELECT p FROM Product p WHERE p.isDeleted=false AND p.productName=:productName")
	Product findByProductName(@Param("productName") String productName);
	
	@Query("SELECT p FROM Product p WHERE p.isDeleted=false AND p.posTerminalId=:posTerminalId")
	Product findByPosTerminalId(@Param("posTerminalId") String posTerminalId);
	
	@Override
	@Query("SELECT p FROM Product p WHERE p.isDeleted=false")
	List<Product> findAll();

	//recycle bin
	@Query("SELECT p FROM Product p WHERE p.isDeleted=true")
	List<Product> recycleBin(); 

	@Query("UPDATE FROM Product p SET p.isDeleted=true WHERE p.productId=:pid")
	@Modifying
	@Transactional
	void softDelete(@Param("pid") long pid); 
}
