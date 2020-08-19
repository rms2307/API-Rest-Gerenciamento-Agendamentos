package com.rms2307.testetripletech.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rms2307.testetripletech.domain.Agendamento;

@Repository
public interface AgendamentoRepository extends JpaRepository<Agendamento, Integer> {

	@Query(value = "SELECT id, local, datainicio, datafim FROM agendamento a "
			+ "WHERE :datainicio BETWEEN TIMESTAMP(a.datainicio) AND TIMESTAMP(a.datafim) "
			+ "OR :datafim BETWEEN TIMESTAMP(a.datainicio) AND TIMESTAMP(a.datafim)", nativeQuery = true)
	List<Agendamento> buscarAgendamentoPorDataHora(@Param("datainicio") String dataInicio,
			@Param("datafim") String dataFim);

	@Query(value = "SELECT id, local, datainicio, datafim FROM agendamento a "
			+ "WHERE YEAR(DATE(a.datainicio)) = :ano " + "AND MONTH (DATE(a.datainicio)) = :mes", nativeQuery = true)
	List<Agendamento> buscarAgendamentoPorMesAno(@Param("ano") String ano, @Param("mes") String mes);

}
