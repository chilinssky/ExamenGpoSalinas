package com.mx.gs.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.mx.gs.dto.EmployeListaResumenDTO;
import com.mx.gs.model.Employe;

//@Repository
public interface IEmployeRepo extends IGenericRepo<Employe, Integer> {

	@Query(nativeQuery = true)
    List<EmployeListaResumenDTO> listado1();
	
	Employe findByTaxIdNumber(String taxIdNumber);
	
	Employe findByTaxIdNumberAndIsActive(String taxId, String isActive);
	
}
