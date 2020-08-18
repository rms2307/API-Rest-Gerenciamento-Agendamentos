package com.rms2307.testetripletech.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rms2307.testetripletech.domain.Pessoa;
import com.rms2307.testetripletech.services.PessoaService;

@RestController
@RequestMapping(value = "/pessoas")
public class PessoaResource {
	
	@Autowired
	private PessoaService service;
	
	@GetMapping
	public ResponseEntity<List<Pessoa>> listaTodasPessoas(){
		List<Pessoa> pessoas = service.listaTodasPessoas();
		return ResponseEntity.ok().body(pessoas);
	}
}
