package com.mx.gs.service.impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.gs.model.Contract;
import com.mx.gs.model.Employe;
import com.mx.gs.repo.IContractRepo;
import com.mx.gs.repo.IEmployeRepo;
import com.mx.gs.repo.IGenericRepo;
import com.mx.gs.service.IContractService;

@Service
public class ContractServiceImpl extends CRUDImpl<Contract, Integer> implements IContractService {
	Logger log = LoggerFactory.getLogger(ContractServiceImpl.class);
	
	@Autowired
	private IContractRepo repo;
	
	@Autowired
	private IEmployeRepo eRepo;
	
	@Override
	protected IGenericRepo<Contract, Integer> getRepo() {
		return repo;
	}

	@Override
	public Contract registra(Contract contract) {
		DateTimeFormatter formater = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String sHoy = LocalDateTime.now().format(formater);
		LocalDateTime fHoy = LocalDateTime.parse(sHoy, formater);
		
		Contract contratoByEmployeIdAndIsActive = repo.findOneByEmployeAndIsActive(contract.getIsActive(), contract.getEmploye().getEmployeId());
		
		if(contratoByEmployeIdAndIsActive != null) {
			contratoByEmployeIdAndIsActive.setDateTo(fHoy);
			contratoByEmployeIdAndIsActive.setIsActive(0);
			repo.save(contratoByEmployeIdAndIsActive);
		}
		return repo.save(contract);	
	}

	@Override
	public void eliminaContrato(Integer idEmploye) {
		Optional<Employe> optional = eRepo.findById(idEmploye);
		DateTimeFormatter formater = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String sHoy = LocalDateTime.now().format(formater);
		LocalDateTime fHoy = LocalDateTime.parse(sHoy, formater);
		
		log.info("sHOY: " + sHoy);
		
		if(optional.isPresent()) {															
			Contract cEmplActive = repo.findContractByEmployeIdActive(optional.get().getEmployeId());
			if(cEmplActive != null) { 														
				cEmplActive.setDateTo(fHoy);
				cEmplActive.setIsActive(0);
				repo.save(cEmplActive);
			} else {
				Integer num = repo .findContractByEmplId(optional.get().getEmployeId());
				if(num > 0) {
					throw new RuntimeException("El EMPLEADO TIENE CONTRATO PERO NO ESTA VIGENTE");
				} else {
					throw new RuntimeException("El EMPLEADO NO TIENE CONTRATO");
				}
			}
		} 
		else {    throw new RuntimeException("El EMPLEADO NO EXISTE");   }					
	}
	
}
