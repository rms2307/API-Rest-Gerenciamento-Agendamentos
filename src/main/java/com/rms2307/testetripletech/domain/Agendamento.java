package com.rms2307.testetripletech.domain;

import java.io.Serializable;
import java.util.Date;

public class Agendamento implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String local;
	private Date dataInicio;
	private Date dataFim;
	
	public Agendamento() {
	}

	public Agendamento(Integer id, String local, Date dataInicio, Date dataFim) {
		super();
		this.id = id;
		this.local = local;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public Date getDatainicio() {
		return dataInicio;
	}

	public void setDatainicio(Date datainicio) {
		this.dataInicio = datainicio;
	}

	public Date getDatafim() {
		return dataFim;
	}

	public void setDatafim(Date datafim) {
		this.dataFim = datafim;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Agendamento other = (Agendamento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
