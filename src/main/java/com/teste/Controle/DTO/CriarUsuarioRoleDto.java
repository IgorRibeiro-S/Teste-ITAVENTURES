package com.teste.Controle.DTO;

import java.util.List;

import lombok.Data;

@Data
public class CriarUsuarioRoleDto {
	
	private Long idUsuario;
	private List<Long> idsRoles;

}
