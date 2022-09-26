package com.teste.Controle.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teste.Controle.DTO.CriarUsuarioRoleDto;
import com.teste.Controle.entities.Roles;
import com.teste.Controle.entities.Usuario;
import com.teste.Controle.repositories.UsuarioRepository;

@Service
public class CriarRoleUsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public Usuario criar(CriarUsuarioRoleDto criarUsuarioRoleDto) {
		Optional<Usuario> usuarioExiste = usuarioRepository.findById(criarUsuarioRoleDto.getIdUsuario());
		List<Roles> roles = new ArrayList<>();

		if (usuarioExiste.isEmpty()) {
			throw new Error("Usuario não existe");
		}

		roles = criarUsuarioRoleDto.getIdsRoles().stream().map(role -> {
			return new Roles(role);
		}).collect(Collectors.toList());
		Usuario usuario = usuarioExiste.get();
		usuario.setRoles(roles);
		usuarioRepository.save(usuario);
		
		return usuario;
	}
}
