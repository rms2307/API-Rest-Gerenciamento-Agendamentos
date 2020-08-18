package com.rms2307.testetripletech.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rms2307.testetripletech.domain.Agendamento;
import com.rms2307.testetripletech.services.AgendamentoService;

@RestController
@RequestMapping(value = "/agendamentos")
public class AgendamentoResource {

	@Autowired
	private AgendamentoService service;

	@GetMapping
	public ResponseEntity<List<Agendamento>> listaTodosAgendamentos() {
		List<Agendamento> agendamentos = service.listaTodosAgendamentos();
		return ResponseEntity.ok().body(agendamentos);
	}

}
