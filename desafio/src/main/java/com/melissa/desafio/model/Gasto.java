package com.melissa.desafio.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Gasto {
	
	@Id
	@GeneratedValue
	private Long id;
	private String descricao;
	private Double valor;
	private Long codigoUsuario;
	@Temporal(value = TemporalType.DATE)
	private Date data;
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)  
	@JoinColumn(name = "id") 
	private Categoria categoria;
	
	public Gasto() {
		super();
	}
	
	public Gasto (Long id, String descricao, Double valor, Long codigoUsuario, Date data) {
		this.id = id;
		this.descricao = descricao;
		this.valor = valor;
		this.codigoUsuario = codigoUsuario;
		this.data = data;
	}
	
	public Gasto (Long id, String descricao, Double valor, Long codigoUsuario, Date data, Categoria categoria) {
		this.id = id;
		this.descricao = descricao;
		this.valor = valor;
		this.codigoUsuario = codigoUsuario;
		this.data = data;
		this.categoria = categoria;
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public Long getCodigoUsuario() {
		return codigoUsuario;
	}
	public void setCodigoUsuario(Long codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	
}
