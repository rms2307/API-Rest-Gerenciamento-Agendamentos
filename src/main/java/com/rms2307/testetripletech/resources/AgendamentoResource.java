package com.rms2307.testetripletech.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.rms2307.testetripletech.domain.Agendamento;
import com.rms2307.testetripletech.dto.AgendamentoNewDTO;
import com.rms2307.testetripletech.dto.AgendamentoPorAnoMesDTO;
import com.rms2307.testetripletech.dto.AgendamentoUpdateDTO;
import com.rms2307.testetripletech.services.AgendamentoService;
import com.rms2307.testetripletech.services.CSVService;

@RestController
@RequestMapping(value = "/agendamentos")
public class AgendamentoResource {

	@Autowired
	private AgendamentoService service;

	@Autowired
	private CSVService csvService;

	@GetMapping
	public ResponseEntity<List<Agendamento>> listarTodosAgendamentos() {
		List<Agendamento> agendamentos = service.listarTodosAgendamentos();
		return ResponseEntity.ok().body(agendamentos);
	}

	@GetMapping(value = "/buscarporanoemes")
	public ResponseEntity<List<Agendamento>> listarAgendamentosPorAnoMes(@RequestBody AgendamentoPorAnoMesDTO objDTO) {
		List<Agendamento> agendamentos = service.listarAgendamentoPorAnoMes(objDTO.getAno(), objDTO.getMes());
		return ResponseEntity.ok().body(agendamentos);
	}

	@PostMapping
	public ResponseEntity<Void> inserirDeUmObj(@RequestBody AgendamentoNewDTO objDTO) {
		Agendamento obj = service.converterObjDTOparaObj(objDTO);
		obj = service.salvar(obj);
		service.salvarPessoaAgendamento(objDTO, obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@PostMapping(value = "/csv")
	public ResponseEntity<Void> inserirDeUmCSV(@RequestParam(name = "arquivo") MultipartFile arquivo) {
		List<String> dados = csvService.processarCSV(arquivo);
		AgendamentoNewDTO objDTO = service.converterListParaObj(dados);
		Agendamento obj = service.converterObjDTOparaObj(objDTO);
		obj = service.salvar(obj);
		service.salvarPessoaAgendamento(objDTO, obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> atualizar(@RequestBody AgendamentoUpdateDTO objDTO, @PathVariable Integer id) {
		Agendamento obj = service.converterObjDTOparaObj(objDTO);
		obj.setId(id);
		obj = service.atualizar(obj);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(value = "/csv")
	public ResponseEntity<Void> atualizarDeUmCSV(@RequestParam(name = "arquivo") MultipartFile arquivo) {
		List<String> dados = csvService.processarCSV(arquivo);
		AgendamentoUpdateDTO objDTO = service.converterListParaObjUpdate(dados);
		Agendamento obj = service.converterObjDTOparaObj(objDTO);
		obj.setId(obj.getId());
		obj = service.atualizar(obj);
		return ResponseEntity.noContent().build();
	}

}
