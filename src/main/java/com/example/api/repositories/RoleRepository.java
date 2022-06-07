package com.example.api.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.api.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>
{
}
