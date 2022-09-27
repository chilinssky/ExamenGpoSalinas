package com.mx.gs.dto;

public class EmployeListaResumenDTO {
	
	private String nombre;
	private String rfc;
	private String email;
	private String cargo;
	private String desde;
	private String hasta;
	private String salario;
	
	public EmployeListaResumenDTO() {}

	public EmployeListaResumenDTO(String nombre, String rfc, String email, String cargo, String desde, String hasta, String salario) {
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

	public String getDesde() {
		return desde;
	}

	public void setDesde(String desde) {
		this.desde = desde;
	}

	public String getHasta() {
		return hasta;
	}

	public void setHasta(String hasta) {
		this.hasta = hasta;
	}

	public String getSalario() {
		return salario;
	}

	public void setSalario(String salario) {
		this.salario = salario;
	}

	@Override
	public String toString() {
		return "EmployeListaResumenDTO [nombre=" + nombre + ", rfc=" + rfc + ", email=" + email + ", cargo=" + cargo
				+ ", desde=" + desde + ", hasta=" + hasta + ", salario=" + salario + "]";
	}
	
}
