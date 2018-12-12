package com.melissa.desafio.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 
 * @author melissa.kato
 * @since 12/12/2018
 * 
 * Model Categoria do Gasto.
 *
 */

@Entity
public class Categoria {
	
	@Id
	@GeneratedValue
	private Long id;
	private String descricao;
	
	public Categoria() {
		super();
	}
	
	public Categoria (Long id, String descricao) {
		this.id = id;
		this.descricao = descricao;
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
	
	
	

}
