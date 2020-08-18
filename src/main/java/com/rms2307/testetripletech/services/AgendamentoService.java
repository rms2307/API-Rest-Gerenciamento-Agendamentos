package com.rms2307.testetripletech.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rms2307.testetripletech.domain.Agendamento;
import com.rms2307.testetripletech.repositories.AgendamentoRepository;

@Service
public class AgendamentoService {
	
	@Autowired
	private AgendamentoRepository repo;
	
	public List<Agendamento> listaTodosAgendamentos() {
		return repo.findAll();
	}

}
