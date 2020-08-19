package com.rms2307.testetripletech.dto;

public class BuscarAgendamentoPorDataHoraDTO {

	private String dataInicio;
	private String dataFim;

	public BuscarAgendamentoPorDataHoraDTO() {

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
