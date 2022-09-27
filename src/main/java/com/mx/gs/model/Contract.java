package com.mx.gs.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "contract")
public class Contract {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer contractId;
	
	@Column(name = "date_from", nullable = false)
	private LocalDateTime dateFrom;
	
	@Column(name = "date_to", nullable = false)
	private LocalDateTime dateTo;
	
	@Column(name = "is_active", nullable = false)
	private Integer isActive;
	
	@Column(name = "salary_per_day", nullable = false)
	private Integer salaryPerDay;
	
	@ManyToOne
	@JoinColumn(name = "contract_type_id", nullable = false, foreignKey = @ForeignKey(name = "FK_contract_type_employe"))
	private ContractType contractType;
	
	@ManyToOne
	@JoinColumn(name = "employe_id", nullable = false, foreignKey = @ForeignKey(name = "FK_contract_employe"))
	private Employe employe;

	public Integer getContractId() {
		return contractId;
	}

	public void setContractId(Integer contractId) {
		this.contractId = contractId;
	}

	public LocalDateTime getDateFrom() {
		return dateFrom;
	}

	public void setDateFrom(LocalDateTime dateFrom) {
		this.dateFrom = dateFrom;
	}

	public LocalDateTime getDateTo() {
		return dateTo;
	}

	public void setDateTo(LocalDateTime dateTo) {
		this.dateTo = dateTo;
	}

	public Integer getIsActive() {
		return isActive;
	}

	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}

	public Integer getSalaryPerDay() {
		return salaryPerDay;
	}

	public void setSalaryPerDay(Integer salaryPerDay) {
		this.salaryPerDay = salaryPerDay;
	}

	public ContractType getContractType() {
		return contractType;
	}

	public void setContractType(ContractType contractType) {
		this.contractType = contractType;
	}

	public Employe getEmploye() {
		return employe;
	}

	public void setEmploye(Employe employe) {
		this.employe = employe;
	}

	@Override
	public String toString() {
		return "Contract [contractId=" + contractId + ", dateFrom=" + dateFrom + ", dateTo=" + dateTo + ", isActive="
				+ isActive + ", salaryPerDay=" + salaryPerDay + ", contractType=" + contractType + ", employe="
				+ employe + "]";
	}
	
	

}
