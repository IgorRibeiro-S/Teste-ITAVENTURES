package com.teste.Controle.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teste.Controle.DTO.UsuarioDto;
import com.teste.Controle.entities.Usuario;
import com.teste.Controle.repositories.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuario;
	
	public List<Usuario> buscarTodos(){
		return usuario.findAll();
	}
	
	public Usuario buscarPorId(Long id){
		Optional <Usuario> obj = usuario.findById(id);
		return obj.get();
	}
	
	public Usuario novoUsuario(Usuario user) {
		Usuario novoUsu = usuario.save(user);
		return novoUsu;
	}
	
	public Usuario atualizarUsuario(Usuario obj) {
		Usuario novoUsuario = buscarPorId(obj.getId());
		updateData(novoUsuario, obj);
		return usuario.save(novoUsuario);
		
	}

	private void updateData(Usuario novoUsuario, Usuario obj) {
		novoUsuario.setNome(obj.getNome());
		novoUsuario.setAcesso(obj.getAcesso());
	}
	
	public void deletarUsuario(Long id) {
		buscarPorId(id);
		usuario.deleteById(id);
	}
	
	public Usuario fromDto(UsuarioDto objDto) {
		return new Usuario(objDto.getId(), objDto.getNome(), objDto.getCpf(), objDto.getAcesso(), objDto.getSenha());
	}

}
