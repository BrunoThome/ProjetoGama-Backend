package com.isidrocorp.projetofinal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_computador")
public class Computador {
	
	@Column(name="id")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int 	id;
	
	@Column(name="descricao", length=200)
	private String 	descricao;
	
	@Column(name="numero_conector", length=50)
	private String  numeroConector;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getNumeroConector() {
		return numeroConector;
	}

	public void setNumeroConector(String numeroConector) {
		this.numeroConector = numeroConector;
	}
	
	
	
	
}
