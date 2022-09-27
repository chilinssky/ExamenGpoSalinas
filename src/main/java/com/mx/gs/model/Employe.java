package com.mx.gs.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;

import com.mx.gs.dto.EmployeListaResumenDTO;

@NamedNativeQuery(
		name = "Employe.listado1",
		query="SELECT  e.NAME || ' ' || e.LAST_NAME as nombre, e.TAX_ID_NUMBER as rfc, e.EMAIL as email,\r\n"
		  		+ "        CASE WHEN (ct.IS_ACTIVE = 0) THEN 'NULL' WHEN (ct.IS_ACTIVE = 1) THEN ct.NAME END AS cargo,\r\n"
		  		+ "        CASE WHEN (c.IS_ACTIVE = 0)  THEN 'NULL' WHEN (c.IS_ACTIVE = 1) THEN substr(to_char(c.DATE_FROM, 'yyyy-MM-dd HH:mm:ss'), 1, 19) END AS desde, \r\n"
		  		+ "        CASE WHEN (c.IS_ACTIVE = 0)  THEN 'NULL' WHEN (c.IS_ACTIVE = 1) THEN substr(to_char(c.DATE_TO, 'yyyy-MM-dd HH:mm:ss'), 1, 19) END AS hasta, \r\n"
		  		+ "        CASE WHEN (c.IS_ACTIVE = 0)  THEN 'NULL' WHEN (c.IS_ACTIVE = 1) THEN to_char(c.SALARY_PER_DAY) END AS salario\r\n"
		  		+ "FROM    CONTRACT c, CONTRACT_TYPE ct, EMPLOYE e\r\n"
		  		+ "WHERE   c.EMPLOYE_ID = e.EMPLOYE_ID and\r\n"
		  		+ "        c.CONTRACT_TYPE_ID = ct.CONTRACT_TYPE_ID and \r\n"
		  		+ "        e.IS_ACTIVE = 'si'",
		 resultSetMapping = "Mapping.EmployeListaResumenDTO")
@SqlResultSetMapping(name = "Mapping.EmployeListaResumenDTO",
		classes = @ConstructorResult(targetClass = EmployeListaResumenDTO.class,
							columns = { @ColumnResult(name = "nombre"),
										@ColumnResult(name = "rfc"),
										@ColumnResult(name = "email"),
										@ColumnResult(name = "cargo"),
										@ColumnResult(name = "desde"),
										@ColumnResult(name = "hasta"),
										@ColumnResult(name = "salario")}))


@Entity
@Table(name = "employe")
public class Employe {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employe_seq")
//	@SequenceGenerator(name = "employe_seq", sequenceName = "employe_seq", initialValue = 100)
	private Integer employeId;
	
	@Column(name = "birth_date", nullable = false)
	private LocalDateTime birthDate;
	
	@Column(name = "cell_phone", nullable = false)
	private String cellPhone;
	
	@Column(name = "date_created", nullable = false)
	private LocalDateTime dateCreated;
	
	@Column(name = "email", nullable = false)
	private String email;
	
	@Column(name = "is_active", nullable = false)
	private String isActive;
	
	@Column(name = "last_name", nullable = false, length = 60)
	private String lastName;
	
	@Column(name = "name", nullable = false, length = 60)
	private String name;
	
	@Column(name = "tax_id_number", nullable = false)
	private String taxIdNumber;

	public Integer getEmployeId() {
		return employeId;
	}

	public void setEmployeId(Integer employeId) {
		this.employeId = employeId;
	}

	public LocalDateTime getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDateTime birthDate) {
		this.birthDate = birthDate;
	}

	public String getCellPhone() {
		return cellPhone;
	}

	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}

	public LocalDateTime getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(LocalDateTime dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTaxIdNumber() {
		return taxIdNumber;
	}

	public void setTaxIdNumber(String taxIdNumber) {
		this.taxIdNumber = taxIdNumber;
	}

	@Override
	public String toString() {
		return "Employe [employeId=" + employeId + ", birthDate=" + birthDate + ", cellPhone=" + cellPhone
				+ ", dateCreated=" + dateCreated + ", email=" + email + ", isActive=" + isActive + ", lastName="
				+ lastName + ", name=" + name + ", taxIdNumber=" + taxIdNumber + "]";
	}
	
	

}
