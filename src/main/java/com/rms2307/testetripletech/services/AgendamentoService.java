package com.rms2307.testetripletech.services;

import java.util.List;
import java.util.Optional;

import org.hibernate.cfg.beanvalidation.IntegrationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rms2307.testetripletech.domain.Agendamento;
import com.rms2307.testetripletech.domain.Pessoa;
import com.rms2307.testetripletech.domain.PessoaAgendamento;
import com.rms2307.testetripletech.dto.AgendamentoNewDTO;
import com.rms2307.testetripletech.dto.AgendamentoUpdateDTO;
import com.rms2307.testetripletech.repositories.AgendamentoRepository;
import com.rms2307.testetripletech.repositories.PessoaAgendamentoRepository;
import com.rms2307.testetripletech.repositories.PessoaRepository;

@Service
public class AgendamentoService {

	@Autowired
	private AgendamentoRepository repo;

	@Autowired
	private PessoaRepository pessoaRepository;

	@Autowired
	private PessoaAgendamentoRepository pessoaAgendamentoRepository;
	

	public List<Agendamento> listarTodosAgendamentos() {
		return repo.findAll();
	}
	
	public List<Agendamento> listarAgendamentoPorDataHora(String dataInicio, String dataFim) {
		return repo.buscarAgendamentoPorDataHora(dataInicio, dataFim);
	}	

	public Agendamento salvar(Agendamento obj) {
		obj.setId(null);
		List<Agendamento> agendamentos = repo.buscarAgendamentoPorDataHora(obj.getDataInicio(), obj.getDataFim());
		if(!agendamentos.isEmpty()) {
			throw new IntegrationException("Já existe um AGENDAMENTO para este periodo.");
		}
		return repo.save(obj);
	}

	public Agendamento atualizar(Agendamento obj) {
		List<Agendamento> agendamentos = repo.buscarAgendamentoPorDataHora(obj.getDataInicio(), obj.getDataFim());
		if(!agendamentos.isEmpty()) {
			throw new IntegrationException("Já existe um AGENDAMENTO para este periodo.");
		}
		Optional<Agendamento> novoObj = repo.findById(obj.getId());
		atualizarDados(novoObj.orElseThrow(null), obj);
		return repo.save(novoObj.orElseThrow(null));
	}

	public void atualizarDados(Agendamento novoObj, Agendamento obj) {
		novoObj.setDataInicio(obj.getDataInicio());
		novoObj.setDataFim(obj.getDataFim());
	}

	public Agendamento converterObjDTOparaObj(AgendamentoNewDTO objDTO) {
		Agendamento obj = new Agendamento(null, null, objDTO.getDataInicio(), objDTO.getDataFim());
		return obj;
	}

	public Agendamento converterObjDTOparaObj(AgendamentoUpdateDTO objDTO) {
		return new Agendamento(objDTO.getId(), null, objDTO.getDataInicio(), objDTO.getDataFim());
	}

	public void salvarPessoaAgendamento(AgendamentoNewDTO objDTO, Agendamento obj) {
		for (Integer pessoaId : objDTO.getPessoasId()) {
			Optional<Pessoa> pessoa = pessoaRepository.findById(pessoaId);
			PessoaAgendamento pessoaAgendamento = new PessoaAgendamento(pessoa.orElseThrow(null), obj);
			pessoaAgendamentoRepository.save(pessoaAgendamento);
		}
	}

}
