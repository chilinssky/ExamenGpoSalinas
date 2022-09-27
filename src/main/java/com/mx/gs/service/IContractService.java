package com.mx.gs.service;

import com.mx.gs.model.Contract;

public interface IContractService extends ICRUD<Contract, Integer> {

	Contract registra(Contract contract);
	
	void eliminaContrato(Integer idEmpleado);
}
