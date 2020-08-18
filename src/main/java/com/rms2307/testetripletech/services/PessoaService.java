package com.rms2307.testetripletech.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rms2307.testetripletech.domain.Pessoa;
import com.rms2307.testetripletech.repositories.PessoaRepository;

@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository repo;
	
	public List<Pessoa> listaTodasPessoas() {
		return repo.findAll();
	}

}
