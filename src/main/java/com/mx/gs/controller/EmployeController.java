package com.mx.gs.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.gs.dto.EmployeListaResumenDTO;
import com.mx.gs.model.Employe;
import com.mx.gs.service.IEmployeService;

@RestController
@RequestMapping("/employes")
public class EmployeController {
	
	Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private IEmployeService service;
	
	@GetMapping
	public ResponseEntity<List<Employe>> listar() throws Exception {
		List<Employe> employes = service.listar();
		return new ResponseEntity<List<Employe>>(employes, HttpStatus.OK);
	}
	
	@GetMapping("/listado1")
	public ResponseEntity<List<EmployeListaResumenDTO>> listado() throws Exception {
		List<EmployeListaResumenDTO> lista = service.listado1();
		return new ResponseEntity<List<EmployeListaResumenDTO>>(lista, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Employe> registrar(@RequestBody Employe employe) throws Exception {
		Employe emp = service.registra(employe);
		return new ResponseEntity<Employe>(emp, HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<Employe> modificar(@RequestBody Employe employe) throws Exception {
		Employe empleado = service.modifica(employe);
		return new ResponseEntity<Employe>(empleado, HttpStatus.ACCEPTED);
	}
	

}

/*	
	EJECUTAR DESDE POSTMAN
	
	POST :::  http://localhost:8080/employes
	Body --> Raw --> JSON
{
    "employeId" : 5,
    "birthDate" : "1966-06-17T22:10:10",
    "cellPhone" : "5512990606",
    "dateCreated" : "2022-09-27T12:29:39",
    "email" : "mecano_mcs@hotmail.com",
    "isActive" : "si",
    "lastName" : "Cano Segura",
    "name" : "Martin",
    "taxIdNumber" : "CASM660617U77"
}

*/