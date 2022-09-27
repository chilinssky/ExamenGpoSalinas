package com.mx.gs.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "contract_type")
public class ContractType {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer contractTypeId;
	
	@Column(name = "date_created", nullable = false)
	private LocalDateTime dateCreated;
	
	@Column(name = "descripcion", nullable = false, length = 250)
	private String descripcion;
	
	@Column(name = "is_active", nullable = false)
	private Integer isActive;
	
	@Column(name = "name", nullable = false, length = 60)
	private String name;

	public Integer getContractTypeId() {
		return contractTypeId;
	}

	public void setContractTypeId(Integer contractTypeId) {
		this.contractTypeId = contractTypeId;
	}

	public LocalDateTime getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(LocalDateTime dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getIsActive() {
		return isActive;
	}

	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "ContractType [contractTypeId=" + contractTypeId + ", dateCreated=" + dateCreated + ", descripcion="
				+ descripcion + ", isActive=" + isActive + ", name=" + name + "]";
	}
	
	
	
	
}
