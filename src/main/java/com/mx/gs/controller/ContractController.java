package com.mx.gs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.gs.model.Contract;
import com.mx.gs.service.IContractService;

@RestController
@RequestMapping("/contracts")
public class ContractController {

	@Autowired
	private IContractService service;
	
	@PostMapping
	 public ResponseEntity<Contract> registrar(@RequestBody Contract contract) throws Exception { 
		 Contract obj = service.registra(contract); 
	  return new ResponseEntity<Contract>(obj, HttpStatus.CREATED); 
	 }
	
	@DeleteMapping("{id}")
	public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) throws Exception {
		service.eliminaContrato(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
}

/** ejecutar el end point desde postman 
POST :::::   http://localhost:8080/contracts
- Body
- Raw
- JSON

{
	"dateFrom" : "2022-09-26T01:08:13",
	"dateTo" : "2022-12-10T01:08:13",
	"isActive" : "1",
	"salaryPerDay" : "2100",
	"contractType" : {
	    "contractTypeId" : 1
	},
	"employe" : {
	    "employeId" : 5
	}
}

*/