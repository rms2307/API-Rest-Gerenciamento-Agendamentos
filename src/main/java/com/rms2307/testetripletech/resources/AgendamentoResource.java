package com.rms2307.testetripletech.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.rms2307.testetripletech.domain.Agendamento;
import com.rms2307.testetripletech.dto.AgendamentoNewDTO;
import com.rms2307.testetripletech.services.AgendamentoService;

@RestController
@RequestMapping(value = "/agendamentos")
public class AgendamentoResource {

	@Autowired
	private AgendamentoService service;

	@GetMapping
	public ResponseEntity<List<Agendamento>> listaTodosAgendamentos() {
		List<Agendamento> agendamentos = service.listarTodosAgendamentos();
		return ResponseEntity.ok().body(agendamentos);
	}

	@PostMapping
	public ResponseEntity<Void> inserir(@RequestBody AgendamentoNewDTO objDTO) {
		Agendamento obj = service.converterObjDTOparaObj(objDTO);
		obj = service.salvar(obj);
		service.salvarPessoaAgendamento(objDTO, obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

}
