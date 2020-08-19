package com.rms2307.testetripletech.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class PessoaAgendamentoPK implements Serializable {
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "pessoaid")
	private Pessoa pessoaId;

	@ManyToOne
	@JoinColumn(name = "agendamentoid")
	private Agendamento agendamentoId;

	public Pessoa getPessoaId() {
		return pessoaId;
	}

	public void setPessoaId(Pessoa pessoaId) {
		this.pessoaId = pessoaId;
	}

	public Agendamento getAgendamentoId() {
		return agendamentoId;
	}

	public void setAgendamentoId(Agendamento agendamentoId) {
		this.agendamentoId = agendamentoId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((agendamentoId == null) ? 0 : agendamentoId.hashCode());
		result = prime * result + ((pessoaId == null) ? 0 : pessoaId.hashCode());
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
		PessoaAgendamentoPK other = (PessoaAgendamentoPK) obj;
		if (agendamentoId == null) {
			if (other.agendamentoId != null)
				return false;
		} else if (!agendamentoId.equals(other.agendamentoId))
			return false;
		if (pessoaId == null) {
			if (other.pessoaId != null)
				return false;
		} else if (!pessoaId.equals(other.pessoaId))
			return false;
		return true;
	}

}
