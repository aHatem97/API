package com.example.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.api.entities.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> 
{
	@Query("SELECT o FROM Order o WHERE o.isDeleted=false")
	Order findByOrderId(@Param("order_id") String name);

	@Query("SELECT o FROM Order o WHERE o.isDeleted=false")
	Order findByTrxid(@Param("trxid") String trxid);
	
	@Override
	@Query("SELECT o FROM Order o WHERE o.isDeleted=false")
	List<Order> findAll();

	//recycle bin
	@Query("SELECT o FROM Order o WHERE o.isDeleted=true")
	List<Order> recycleBin(); 

	@Query("UPDATE FROM Order o SET o.isDeleted=true WHERE o.orderId=:oid")
	@Modifying
	@Transactional
	void softDelete(@Param("oid") long oid); 
}
