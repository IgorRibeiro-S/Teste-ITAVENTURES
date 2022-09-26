package com.teste.Controle.controllers;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.teste.Controle.DTO.PresencaDto;
import com.teste.Controle.entities.Presenca;
import com.teste.Controle.services.PresencaService;

@RestController
@RequestMapping(value = "/presenca")
public class PresencaController {

	@Autowired
	private PresencaService presencaService;

	@GetMapping
	public ResponseEntity<List<Presenca>> listarPresencas() {
		List<Presenca> lista = presencaService.buscarTodos();
		return ResponseEntity.ok().body(lista);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Presenca> buscarPeloId(@PathVariable("id") Long id) {
		Presenca presenca = presencaService.buscarPorId(id);
		return ResponseEntity.ok().body(presenca);
	}

	@GetMapping(value = "/data")
	public ResponseEntity<List<Presenca>> buscarPorData(@RequestParam Date start, @RequestParam Date end){
		List<Presenca> presenca = presencaService.buscarPorData(start, end);
		return ResponseEntity.ok().body(presenca);
	}

	@PostMapping
	public ResponseEntity<Presenca> novoPresenca(@RequestBody PresencaDto presenca) {
		Presenca pre = presencaService.fromDto(presenca);
		pre = presencaService.novoPresenca(pre);
		return new ResponseEntity<>(pre, HttpStatus.CREATED);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Presenca> atualizarPresenca(@PathVariable("id") Long id, @RequestBody Presenca obj) {
		obj.setId(id);
		presencaService.atualizarPresenca(obj);
		return ResponseEntity.noContent().build();

	}

	public ResponseEntity<Presenca> deletar(Long id) {
		presencaService.buscarPorId(id);
		presencaService.deletarPresenca(id);
		return ResponseEntity.noContent().build();

	}

}
