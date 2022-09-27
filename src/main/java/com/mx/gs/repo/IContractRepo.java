package com.mx.gs.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mx.gs.model.Contract;

public interface IContractRepo extends IGenericRepo<Contract, Integer> {
	
	@Query(value = "select * from contract c where c.is_active =:activo and c.employe_id =:empleado", nativeQuery = true)
	Contract findOneByEmployeAndIsActive(@Param("activo") Integer activo, @Param("empleado") Integer empleado);
		
	@Query(value = "select * from contract c where c.is_active = 1 and c.employe_id = :idEmpl", nativeQuery = true)
	Contract findContractByEmployeIdActive(@Param("idEmpl") Integer idEmpl);
	
	@Query(value = "select count(*) from contract c where c.employe_id = :idEmpl", nativeQuery = true)
	Integer findContractByEmplId(@Param("idEmpl") Integer idEmpl);
	
}
