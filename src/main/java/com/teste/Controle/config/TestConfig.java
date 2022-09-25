package com.teste.Controle.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.teste.Controle.entities.Presenca;
import com.teste.Controle.entities.Usuario;
import com.teste.Controle.repositories.UsuarioRepository;

@Configuration
public class TestConfig implements CommandLineRunner{
	
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	

	@Override
	public void run(String... args) throws Exception {
		Usuario novo = new Usuario(null, "Jorge", "4545454545", 1, null);
		Usuario novo2 = new Usuario(null, "gege", "4545454545", 1, null);
		Presenca pres = new Presenca(null, null, novo);
		usuarioRepository.save(novo);
		usuarioRepository.save(novo2);
		novo.setPresenca(pres);
		usuarioRepository.save(novo);
	}
	
}