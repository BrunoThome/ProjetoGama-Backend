package com.isidrocorp.projetofinal.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.isidrocorp.projetofinal.dao.DepartamentoDAO;
import com.isidrocorp.projetofinal.model.Departamento;

@RestController
@CrossOrigin("*")
public class DepartamentoController {

	@Autowired
	private DepartamentoDAO departamentoDao;
	
	@GetMapping("/departamentos")
	public ArrayList<Departamento> listarDepartamentos(){
		return (ArrayList<Departamento>)departamentoDao.findAll();
	}
}
