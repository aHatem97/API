package com.example.api.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.api.entities.Customer;

@RepositoryRestResource(collectionResourceRel = "Customer", path = "Customer")
public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long> 
{
	Customer findByPhoneNumber(@Param("phoneNumber") String phoneNumber);
}
