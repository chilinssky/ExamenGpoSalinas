package com.mx.gs.dto;

import java.time.LocalDateTime;

public class EmployeListaResumen2DTO {
	
	private String nombre;
	private String rfc;
	private String email;
	private String cargo;
	private LocalDateTime desde;
	private LocalDateTime hasta;
	private Integer salario;
	
	public EmployeListaResumen2DTO() {}

	public EmployeListaResumen2DTO(String nombre, String rfc, String email, String cargo, LocalDateTime desde,
			LocalDateTime hasta, Integer salario) {
		this.nombre = nombre;
		this.rfc = rfc;
		this.email = email;
		this.cargo = cargo;
		this.desde = desde;
		this.hasta = hasta;
		this.salario = salario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRfc() {
		return rfc;
	}

	public void setRfc(String rfc) {
		this.rfc = rfc;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public LocalDateTime getDesde() {
		return desde;
	}

	public void setDesde(LocalDateTime desde) {
		this.desde = desde;
	}

	public LocalDateTime getHasta() {
		return hasta;
	}

	public void setHasta(LocalDateTime hasta) {
		this.hasta = hasta;
	}

	public Integer getSalario() {
		return salario;
	}

	public void setSalario(Integer salario) {
		this.salario = salario;
	}

	@Override
	public String toString() {
		return "EmployeListaResumen2DTO [nombre=" + nombre + ", rfc=" + rfc + ", email=" + email + ", cargo=" + cargo
				+ ", desde=" + desde + ", hasta=" + hasta + ", salario=" + salario + "]";
	}

	
	
}
