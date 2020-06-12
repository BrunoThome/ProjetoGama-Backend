package com.isidrocorp.projetofinal.controller;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.isidrocorp.projetofinal.dao.UsuarioDAO;
import com.isidrocorp.projetofinal.model.Usuario;

@RestController
@CrossOrigin("*")
public class UsuarioController {
	
	@Autowired
	private UsuarioDAO usuarioDAO;
	
	@GetMapping("/usuario")
	public ArrayList<Usuario> getUsuarios(){
		return (ArrayList<Usuario>)usuarioDAO.findAll();
	}
	
	@GetMapping("/usuario/{id}")
	public ResponseEntity<Optional<Usuario>> getUsuario(@PathVariable int id) {
		return ResponseEntity.ok(usuarioDAO.findById(id));
	}
	
	@PostMapping("/cadastro")
	public ResponseEntity<Usuario> cadastro(@RequestBody Usuario usuario){
		usuarioDAO.save(usuario);
		return ResponseEntity.ok(usuario);
	}
	
	@PostMapping("/login")
	public ResponseEntity<Usuario> login(@RequestBody Usuario dadosLogin) {
		Usuario usuario = usuarioDAO.findByEmailOrRacf(dadosLogin.getEmail(), dadosLogin.getRacf());
		if(usuario != null) {
			if(usuario.getSenha().equals(dadosLogin.getSenha())) {
				return ResponseEntity.ok(usuario);			
			}else {
				return ResponseEntity.status(403).build();
			}
		}
		return ResponseEntity.status(404).build();
	}
}
