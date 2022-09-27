package com.mx.gs.service.impl;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.gs.dto.EmployeListaResumenDTO;
import com.mx.gs.model.Employe;
import com.mx.gs.repo.IEmployeRepo;
import com.mx.gs.repo.IGenericRepo;
import com.mx.gs.service.IEmployeService;

@Service
public class EmployeServiceImpl extends CRUDImpl<Employe, Integer> implements IEmployeService {
	Logger log = LoggerFactory.getLogger(EmployeServiceImpl.class);
	
	@Autowired
	private IEmployeRepo repo;
	
	@Override
	protected IGenericRepo<Employe, Integer> getRepo() {
		return repo;
	}	

	@Override
	public List<EmployeListaResumenDTO> listado1() {
		 List<EmployeListaResumenDTO> listado = repo.listado1();
		 return listado;
	}

	@Override
	public Employe registra(Employe e) {
		Pattern patron = Pattern.compile("^([A-ZÑ\\x26]{3,4}([0-9]{2})(0[1-9]|1[0-2])(0[1-9]|1[0-9]|2[0-9]|3[0-1]))([A-Z\\d]{3})?$");
		Matcher matcher = patron.matcher(e.getTaxIdNumber());
		if(matcher.matches()) {
			Employe employe = repo.findByTaxIdNumber(e.getTaxIdNumber());
			if(employe == null) {
				return repo.save(e);
			}
			else {
				throw new RuntimeException("El EMPLEADO YA SE ENCUENTRA REGISTRADO [" +  e.getTaxIdNumber() + "]");
			}
		} else {
			throw new RuntimeException("El TAX_ID_NUMBER DEL EMPLEADO TIENE FORMATO INCORRECTO [" +  e.getTaxIdNumber() + "]");
		}
	}

	@Override
	public Employe modifica(Employe empleado) {
		Pattern patron = Pattern.compile("^([A-ZÑ\\x26]{3,4}([0-9]{2})(0[1-9]|1[0-2])(0[1-9]|1[0-9]|2[0-9]|3[0-1]))([A-Z\\d]{3})?$");
		Matcher matcher = patron.matcher(empleado.getTaxIdNumber());
		if(matcher.matches()) {
			Employe eTaxIdActive = repo.findByTaxIdNumberAndIsActive(empleado.getTaxIdNumber(), "si");
			if(eTaxIdActive != null) {										
				empleado.setEmployeId(eTaxIdActive.getEmployeId());
				return repo.save(empleado);
			}
			else { 															
				Employe eTaxId = repo.findByTaxIdNumber(empleado.getTaxIdNumber());
				if(eTaxId != null) {										
					empleado.setEmployeId(eTaxId.getEmployeId());
					return repo.save(empleado);
				} 
				else { 														
					return repo.save(empleado);
				}
			}
		} else {
			throw new RuntimeException("El TAX_ID_NUMBER (RFC) DEL EMPLEADO NO TIENE FORMATO CORRECTO [" +  empleado.getTaxIdNumber() + "]");
		}
	}

}
