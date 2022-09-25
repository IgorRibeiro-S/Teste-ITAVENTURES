package com.teste.Controle.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teste.Controle.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	
}
