package com.mx.gs.service;

import java.util.List;

import com.mx.gs.dto.EmployeListaResumenDTO;
import com.mx.gs.model.Employe;

public interface IEmployeService extends ICRUD<Employe, Integer> {
	
	List<EmployeListaResumenDTO> listado1();
	
	Employe registra(Employe e);
	
	Employe modifica(Employe e);
	
}
