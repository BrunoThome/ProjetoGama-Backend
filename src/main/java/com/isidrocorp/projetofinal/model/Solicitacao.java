package com.isidrocorp.projetofinal.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="tbl_solicitacao")
public class Solicitacao {
	
	@Column(name="id")
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="data_solicitacao")
	@Temporal(TemporalType.DATE)
	private Date dataSolicitacao;
	
	@Column(name="justificativa", length=200)
	private String justificativa;
		
	@Column(name="comando_roteador", length=200)
	private String comandoRoteador;
	
	@JsonIgnoreProperties("listUsuarios")
	@ManyToOne
	private Departamento origem;

	@JsonIgnoreProperties("listUsuarios")
	@ManyToOne
	private Departamento destino;
	
	@JsonIgnoreProperties("solicitacoes")
	@ManyToOne
	private Usuario usuario;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDataSolicitacao() {
		return dataSolicitacao;
	}

	public void setDataSolicitacao(Date dataSolicitacao) {
		this.dataSolicitacao = dataSolicitacao;
	}

	public String getJustificativa() {
		return justificativa;
	}

	public void setJustificativa(String justificativa) {
		this.justificativa = justificativa;
	}

	public String getComandoRoteador() {
		return comandoRoteador;
	}

	public void setComandoRoteador(String comandoRoteador) {
		this.comandoRoteador = comandoRoteador;
	}

	public Departamento getOrigem() {
		return origem;
	}

	public void setOrigem(Departamento origem) {
		this.origem = origem;
	}

	public Departamento getDestino() {
		return destino;
	}

	public void setDestino(Departamento destino) {
		this.destino = destino;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
}
