package com.isidrocorp.projetofinal.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.isidrocorp.projetofinal.dao.DepartamentoDAO;
import com.isidrocorp.projetofinal.dao.SolicitacaoDAO;
import com.isidrocorp.projetofinal.dao.UsuarioDAO;
import com.isidrocorp.projetofinal.model.Departamento;
import com.isidrocorp.projetofinal.model.Solicitacao;
import com.isidrocorp.projetofinal.model.Usuario;

@RestController
@CrossOrigin("*")
public class SolicitacaoController {

	@Autowired
	private SolicitacaoDAO solicitacaoDao;
	
	@Autowired
	private DepartamentoDAO departamentoDao;
	
	@Autowired
	private UsuarioDAO usuarioDao;
	
	@GetMapping("/solicitacoes")
	public ArrayList<Solicitacao> listarSolicitacoes(){
		return (ArrayList<Solicitacao>)solicitacaoDao.findAll();
	}
	
	@GetMapping("/solicitacoes/detalhe/{id}")
	public ResponseEntity<Solicitacao> getInfoSolicitacao(@PathVariable int id){
		Solicitacao solicitacao = solicitacaoDao.findById(id).orElse(null);
		
		if(solicitacao == null) {
			return ResponseEntity.notFound().build();
		}else {
			return ResponseEntity.ok(solicitacao);		
		}
	}
	
	@PostMapping("/solicitacoes/nova")
	public ResponseEntity<Solicitacao> criarSolicitacao(@RequestBody Solicitacao solicitacao){

		Usuario usuario = usuarioDao.findById(solicitacao.getUsuario().getId()).orElse(null);
		Departamento departamentoDestino = departamentoDao.findById(solicitacao.getDestino().getId()).orElse(null);
		String vlanOrigem = usuario.getDepartamento().getVlan();
		String numeroConector = usuario.getComputador().getNumeroConector();
		String vlanDestino = departamentoDestino.getVlan();
		String comando = this.criarComando(vlanOrigem, vlanDestino, numeroConector);
		
		solicitacao.setComandoRoteador(comando);
		solicitacao = solicitacaoDao.save(solicitacao);
		
		usuario.setDepartamento(departamentoDestino);
		return ResponseEntity.ok(solicitacao);
	}
	
	public String criarComando(String vlanOrigem, String vlanDestino, String numeroConector) {
		String comando = "switchport vlan "+
							vlanOrigem+
							"; interface range "+
							numeroConector+
							" "+
							vlanDestino+
							"; exit";
		return comando;
	}
}
