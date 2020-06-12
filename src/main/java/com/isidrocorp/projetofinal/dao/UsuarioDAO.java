package com.isidrocorp.projetofinal.dao;

import org.springframework.data.repository.CrudRepository;

import com.isidrocorp.projetofinal.model.Usuario;

public interface UsuarioDAO extends CrudRepository<Usuario, Integer> {	
	public Usuario findByEmailOrRacf(String email, String racf);
}
