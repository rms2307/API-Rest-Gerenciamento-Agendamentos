package com.rms2307.testetripletech.dto;

import java.util.ArrayList;
import java.util.List;

public class AgendamentoNewDTO {

	private List<Integer> pessoasId = new ArrayList<>();
	private String dataInicio;
	private String dataFim;

	public AgendamentoNewDTO() {

	}

	public List<Integer> getPessoasId() {
		return pessoasId;
	}

	public void setPessoasId(List<Integer> pessoasId) {
		this.pessoasId = pessoasId;
	}

	public String getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(String dataInicio) {
		this.dataInicio = dataInicio;
	}

	public String getDataFim() {
		return dataFim;
	}

	public void setDataFim(String dataFim) {
		this.dataFim = dataFim;
	}

}
