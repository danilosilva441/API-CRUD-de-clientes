package com.devsuperior.DesafioParaEntregar.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.DesafioParaEntregar.entities.ClientCadastro;

@RestController
@RequestMapping(value = "/clients")
public class ClientResourse {
	
	@GetMapping
	public ResponseEntity<List<ClientCadastro>> findAll() {
		List<ClientCadastro> list = new ArrayList<>();
		list.add(new ClientCadastro(1L, "Danilo da Silva"));
		list.add(new ClientCadastro(2L, "Érica Alves"));
		return ResponseEntity.ok().body(list);
	}

}
