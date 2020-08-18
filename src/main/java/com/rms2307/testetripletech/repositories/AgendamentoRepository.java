package com.rms2307.testetripletech.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rms2307.testetripletech.domain.Agendamento;

@Repository
public interface AgendamentoRepository extends JpaRepository<Agendamento, Integer>{

}
