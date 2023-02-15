package com.sugggarCoffe.sub.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Rol  {

	@Id
	  @Column(name="idRol")
	  private Long idRol;
	  
	  @Column(name="rolName")
	  private String rolName;
	
	public Rol() {
		super();
	}
	
	public Rol(Long idRol, String name) {
		super();
		this.idRol = idRol;
		this.rolName = name;
	}

	public Long getIdRol() {
		return idRol;
	}

	public String getRolName() {
		return rolName;
	}

	public void setIdRol(Long idRol) {
		this.idRol = idRol;
	}

	public void setRolName(String rolName) {
		this.rolName = rolName;
	}

	@Override
	public String toString() {
		return "Rol [id=" + idRol + ", name=" + rolName + "]";
	}


}
