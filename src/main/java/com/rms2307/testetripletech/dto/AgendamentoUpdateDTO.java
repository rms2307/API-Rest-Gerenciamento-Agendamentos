package com.rms2307.testetripletech.dto;

public class AgendamentoUpdateDTO {

	private Integer id;
	private String dataInicio;
	private String dataFim;

	public AgendamentoUpdateDTO() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
