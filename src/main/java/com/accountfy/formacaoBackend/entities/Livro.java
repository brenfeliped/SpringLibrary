package com.accountfy.formacaoBackend.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.YearMonth;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.datatype.jsr310.deser.YearMonthDeserializer;


@Entity
//@Table(name = "livro")
public class Livro implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	private String Titulo;
	private Integer numeroDePaginas;
	
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM", timezone = "GMT")
	private Date publicadoEm;
	
	
	public Date getPublicadoEm() {
		return publicadoEm;
	}

	public void setPublicadoEm(Date publicadoEm) {
		this.publicadoEm = publicadoEm;
	}

	private BigDecimal precoDeVenda;
	
	public Livro(){
		
	}

	

	



	public Livro(Long id, String titulo, Integer numeroDePaginas, Date publicadoEm, BigDecimal precoDeVenda) {
		super();
		Id = id;
		Titulo = titulo;
		this.numeroDePaginas = numeroDePaginas;
		this.publicadoEm = publicadoEm;
		this.precoDeVenda = precoDeVenda;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getTitulo() {
		return Titulo;
	}

	public void setTitulo(String titulo) {
		Titulo = titulo;
	}

	public Integer getNumeroDePaginas() {
		return numeroDePaginas;
	}

	public void setNumeroDePaginas(Integer numeroDePaginas) {
		this.numeroDePaginas = numeroDePaginas;
	}

	
	public YearMonth getAnaMesDePublicacao() {
		YearMonth anoMes = YearMonth.parse(this.publicadoEm.toString());
		
		return anoMes;
	}
	

	public BigDecimal getPrecoDeVenda() {
		return precoDeVenda;
	}

	public void setPrecoDeVenda(BigDecimal precoDeVenda) {
		this.precoDeVenda = precoDeVenda;
	}

	@Override
	public int hashCode() {
		return Objects.hash(Id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Livro other = (Livro) obj;
		return Objects.equals(Id, other.Id);
	}
	
	
	
}
