package com.teste.Controle.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.teste.Controle.entities.Presenca;
import com.teste.Controle.entities.Roles;
import com.teste.Controle.entities.Usuario;
import com.teste.Controle.repositories.RoleRepository;
import com.teste.Controle.services.UsuarioService;

@Configuration
public class TestConfig implements CommandLineRunner {

	
	@Autowired
	private UsuarioService userService;

	@Autowired
	private RoleRepository roleRepository;
	

	
	@Override
	public void run(String... args) throws Exception {
		Usuario novo = new Usuario(null, "Jorge", "4545454545", "5252");
		Usuario novo2 = new Usuario(null, "Douglas", "123456789", "1233");
		Presenca pres = new Presenca(null, null, novo);
		Presenca pres2 = new Presenca(null, null, novo2);
		Roles rol1 = new Roles(null, "ADMIN");
		Roles rol2 = new Roles(null, "USER");
		
		
		
		
		
		userService.novoUsuario(novo);
		userService.novoUsuario(novo2);
		novo.setPresenca(pres);
		novo2.setPresenca(pres2);
		userService.novoUsuario(novo);
		userService.novoUsuario(novo2);
		roleRepository.save(rol1);
		roleRepository.save(rol2);

	}

}