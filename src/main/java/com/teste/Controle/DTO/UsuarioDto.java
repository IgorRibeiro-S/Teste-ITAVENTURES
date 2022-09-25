package com.teste.Controle.DTO;

import java.io.Serializable;

import com.teste.Controle.entities.Usuario;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioDto implements Serializable{
	

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nome;
	private String cpf;
	private Integer Acesso;
	private String senha;
	
	public UsuarioDto() {
		
	}
	
	public UsuarioDto(Usuario obj) {
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.cpf = obj.getCpf();
		this.Acesso = obj.getAcesso();
		this.senha = obj.getSenha();
	}
}
