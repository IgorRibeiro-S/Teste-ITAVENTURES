package com.teste.Controle.services;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teste.Controle.DTO.PresencaDto;
import com.teste.Controle.entities.Presenca;
import com.teste.Controle.repositories.PresencaRepository;

@Service
public class PresencaService {
	
	@Autowired
	private PresencaRepository presenca;
	
	public List<Presenca> buscarTodos(){
		return presenca.findAll();
	}
	
	public Presenca buscarPorId(Long id){
		Optional <Presenca> obj = presenca.findById(id);
		return obj.get();
	}
	
	public Presenca novoPresenca(Presenca pre) {
		Presenca novoObj = presenca.save(pre);
		return novoObj;
	}
	
	public Presenca atualizarPresenca(Presenca obj) {
		Presenca novoPresenca = buscarPorId(obj.getId());
		updateData(novoPresenca, obj);
		return presenca.save(novoPresenca);
		
	}

	private void updateData(Presenca novoPresenca, Presenca obj) {
		novoPresenca.setPresenca(obj.getPresenca());
		novoPresenca.setUser(obj.getUser());
	}
	
	public void deletarPresenca(Long id) {
		buscarPorId(id);
		presenca.deleteById(id);
	}

	public Presenca fromDto(PresencaDto obj) {
		return new Presenca(obj.getId(), obj.getPresenca(), obj.getUser());
	}


	public List<Presenca> buscarPorData(Date start, Date end){
		return presenca.findByPresencaBetween(start, end);
	}
}
