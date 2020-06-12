package com.isidrocorp.projetofinal.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="tbl_usuario")
public class Usuario {
	
	@Column(name="id")
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int    id;
	
	@Column(name="racf", length=7)
	private String racf;
	
	@Column(name="nome", length=100)
	private String nome;
	
	@Column(name="email", length=70)
	private String email;
	
	@Column(name="senha", length=40)
	private String senha;
	
	@Column(name="linkFoto", length=200)
	private String linkFoto;

	@ManyToOne
	@JsonIgnoreProperties("listUsuarios")
	private Departamento departamento;
	
	@OneToOne
	private Computador computador;
	
	@JsonIgnoreProperties("usuario")
	@OneToMany(mappedBy="usuario", cascade=CascadeType.ALL)
	private List<Solicitacao> solicitacoes;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRacf() {
		return racf;
	}
	public void setRacf(String racf) {
		this.racf = racf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getLinkFoto() {
		return linkFoto;
	}
	public void setLinkFoto(String linkFoto) {
		this.linkFoto = linkFoto;
	}
	
	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	public Computador getComputador() {
		return computador;
	}
	
	public void setComputador(Computador computador) {
		this.computador = computador;
	}
	public List<Solicitacao> getSolicitacoes() {
		return solicitacoes;
	}
	public void setSolicitacoes(List<Solicitacao> solicitacoes) {
		this.solicitacoes = solicitacoes;
	}
	
	
	
}
