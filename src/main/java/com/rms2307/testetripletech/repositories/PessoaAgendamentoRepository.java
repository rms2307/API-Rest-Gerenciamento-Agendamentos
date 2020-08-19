package com.rms2307.testetripletech.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rms2307.testetripletech.domain.PessoaAgendamento;

@Repository
public interface PessoaAgendamentoRepository extends JpaRepository<PessoaAgendamento, Integer> {

}
