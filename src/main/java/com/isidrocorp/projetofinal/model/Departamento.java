package com.isidrocorp.projetofinal.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tbl_departamento")
public class Departamento {
	
	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "nome", length = 100)
	private String nome;
	
	@Column(name = "unidade", length = 100)
	private String unidade;
	
	@Column(name = "andar")
	private int andar;
	
	@Column(name = "vlan", length = 11)
	private String vlan;

	@OneToMany(mappedBy="departamento", cascade=CascadeType.ALL)
	@JsonIgnoreProperties("departamento")
	private List<Usuario> listUsuarios;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUnidade() {
		return unidade;
	}

	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}

	public int getAndar() {
		return andar;
	}

	public void setAndar(int andar) {
		this.andar = andar;
	}

	public String getVlan() {
		return vlan;
	}

	public void setVlan(String vlan) {
		this.vlan = vlan;
	}

	public List<Usuario> getListUsuarios() {
		return listUsuarios;
	}

	public void setListUsuarios(List<Usuario> listUsuarios) {
		this.listUsuarios = listUsuarios;
	}

	
	
	

}
