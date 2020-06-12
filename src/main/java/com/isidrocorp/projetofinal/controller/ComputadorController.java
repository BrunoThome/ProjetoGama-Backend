package com.isidrocorp.projetofinal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.isidrocorp.projetofinal.dao.ComputadorDAO;
import com.isidrocorp.projetofinal.model.Computador;

@RestController
public class ComputadorController {
	
	@Autowired
	private ComputadorDAO computadorDao;
	
	@PostMapping("/cadastro/computador")
	public ResponseEntity<Computador> inserirComputador(@RequestBody Computador computador){
		computadorDao.save(computador);
		return ResponseEntity.ok(computador);
	}
}
