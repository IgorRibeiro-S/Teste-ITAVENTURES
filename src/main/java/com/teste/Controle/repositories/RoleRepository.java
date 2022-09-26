package com.teste.Controle.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teste.Controle.entities.Roles;

public interface RoleRepository extends JpaRepository<Roles, Long>{

	
}
