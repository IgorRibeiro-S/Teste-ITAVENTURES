package com.teste.Controle.DTO;

import java.io.Serializable;
import java.time.Instant;

import com.teste.Controle.entities.Presenca;
import com.teste.Controle.entities.Usuario;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PresencaDto implements Serializable{
	

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Instant presenca;
	private Usuario user;
	
	public PresencaDto() {
		
	}
	
	public PresencaDto(Presenca objDto) {
		this.id = objDto.getId();
		this.presenca = objDto.getPresenca();
		this.user = objDto.getUser();
	}

}
