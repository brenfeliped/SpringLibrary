package com.accountfy.formacaoBackend.entities;

import java.io.Serializable;
import java.util.Objects;

public class AnoMes implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String ano;
	private String mes;
	
	public AnoMes() {
		
	}

	public AnoMes(String ano, String mes) {
		super();
		this.ano = ano;
		this.mes = mes;
	}

	public AnoMes(int ano, int mes) {
		super();
		this.ano = String.valueOf(ano);
		this.mes = String.valueOf(mes);
	}
	@Override
	public String toString() {
		return  ano +"-"+mes;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getMes() {
		return mes;
	}

	public void setMes(String mes) {
		this.mes = mes;
	}

	@Override
	public int hashCode() {
		return Objects.hash(ano, mes);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AnoMes other = (AnoMes) obj;
		return Objects.equals(ano, other.ano) && Objects.equals(mes, other.mes);
	}
	
	
}
