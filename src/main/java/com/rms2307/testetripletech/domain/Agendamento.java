package com.rms2307.testetripletech.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Agendamento implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "local")
	private String local;
	@Column(name = "datainicio")
	private String dataInicio;
	@Column(name = "datafim")
	private String dataFim;
	
	public Agendamento() {
	}

	public Agendamento(Integer id, String local, String dataInicio, String dataFim) {
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

	public String getDatainicio() {
		return dataInicio;
	}

	public void setDatainicio(String datainicio) {
		this.dataInicio = datainicio;
	}

	public String getDatafim() {
		return dataFim;
	}

	public void setDatafim(String datafim) {
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
