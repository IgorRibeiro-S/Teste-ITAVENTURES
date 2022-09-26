package com.teste.Controle.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teste.Controle.DTO.CriarUsuarioRoleDto;
import com.teste.Controle.DTO.UsuarioDto;
import com.teste.Controle.entities.Usuario;
import com.teste.Controle.services.CriarRoleUsuarioService;
import com.teste.Controle.services.UsuarioService;

@RestController
@CrossOrigin
@RequestMapping(value = "/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private CriarRoleUsuarioService criarRoleUsuarioService;

	@GetMapping
	public ResponseEntity<List<Usuario>> listarUsuarios() {
		List<Usuario> lista = usuarioService.buscarTodos();
		return ResponseEntity.ok().body(lista);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Usuario> buscarPeloId(@PathVariable("id") Long id) {
		Usuario usuario = usuarioService.buscarPorId(id);
		return ResponseEntity.ok().body(usuario);
	}

	@PostMapping("/novo")
	public ResponseEntity<Usuario> novoUsuario(@RequestBody UsuarioDto usuario) {
		
		Usuario novo = usuarioService.fromDto(usuario);
		novo = usuarioService.novoUsuario(novo);
		return new ResponseEntity<>(novo, HttpStatus.CREATED);
	}
	
	@PostMapping("/role")
	public ResponseEntity<Usuario> role(@RequestBody CriarUsuarioRoleDto criarUsuarioRoleDto){
		Usuario novo =  criarRoleUsuarioService.criar(criarUsuarioRoleDto);
		return new ResponseEntity<>(novo, HttpStatus.CREATED);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Usuario> atualizarUsuario(@PathVariable("id") Long id, @RequestBody Usuario obj) {
		obj.setId(id);
		usuarioService.atualizarUsuario(obj);
		return ResponseEntity.noContent().build();

	}

	public ResponseEntity<Usuario> deletar(Long id) {
		usuarioService.buscarPorId(id);
		usuarioService.deletarUsuario(id);
		return ResponseEntity.noContent().build();

	}

}
