package com.devsuperior.DesafioParaEntregar.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.devsuperior.DesafioParaEntregar.dto.ClientDTO;
import com.devsuperior.DesafioParaEntregar.services.ClientService;

@RestController
@RequestMapping(value = "/clients")
public class ClientResourse {
	
	@Autowired
	private ClientService service;
	
	@GetMapping											//SERVE PARA FAZER PESQUISA COMPLETA DO BANCO
	public ResponseEntity<List<ClientDTO>> findAll() {
		List<ClientDTO> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}") 						//SERVE PARA FAZER PESQUISA POR ID DO BANCO
	public ResponseEntity<ClientDTO> findById(@PathVariable Long id) { //ANOTAÇÃO SERVE PARA CASAR COM A ANOTAÇÃO DO ID EM CIMA
		ClientDTO dto = service.findById(id);
		return ResponseEntity.ok().body(dto);
	}

	@PostMapping // quando for inserir um novo recurso inserir um metodo POST e não um GET
	public ResponseEntity<ClientDTO> insert(@RequestBody ClientDTO dto) {
		dto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}") 
				.buildAndExpand(dto.getId()).toUri(); //Codigo mas correto para essa função é o 201, pois ele cria serviço
		return ResponseEntity.created(uri).body(dto);
	}
	
}
