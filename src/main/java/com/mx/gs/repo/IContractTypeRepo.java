package com.mx.gs.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mx.gs.model.ContractType;

public interface IContractTypeRepo extends JpaRepository<ContractType, Integer> {
	
	List<ContractType> findByIsActive(Integer isActive);

}
