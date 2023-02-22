package com.sugggarCoffe.sub.model;

import java.time.*;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Cliente {

	@Id
    @Column(name="idCliente")
	private Long idCliente;
	
	@Column(name="nombreCliente")
	private String nombreCliente;
	
	@Column(name="telefonoCliente")
	private String telefonoCliente;

	@Column(name="correoCliente")
	private String correoCliente;
	
	@Column(name="direccionCliente")
	private String direccionCliente;
	
	@Column(name="fechaNacimientoCliente")
	private LocalDate fechaNacimientoCliente;
	
	public Cliente() {
		super();
	}

	public Cliente(Long idCliente, String nombreCliente, String telefonoCliente, String direccionCliente,
			LocalDate fechaNacimientoCliente,String correoCliente) {
		super();
		this.idCliente = idCliente;
		this.nombreCliente = nombreCliente;
		this.telefonoCliente = telefonoCliente;
		this.correoCliente = correoCliente;
		this.direccionCliente = direccionCliente;
		this.fechaNacimientoCliente = fechaNacimientoCliente;
	}

	public String getCorreoCliente() {
		return correoCliente;
	}

	public void setCorreoCliente(String correoCliente) {
		this.correoCliente = correoCliente;
	}

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public String getTelefonoCliente() {
		return telefonoCliente;
	}

	public void setTelefonoCliente(String telefonoCliente) {
		this.telefonoCliente = telefonoCliente;
	}

	public String getDireccionCliente() {
		return direccionCliente;
	}

	public void setDireccionCliente(String direccionCliente) {
		this.direccionCliente = direccionCliente;
	}

	public LocalDate getFechaNacimientoCliente() {
		return fechaNacimientoCliente;
	}

	public void setFechaNacimientoCliente(LocalDate fechaNacimientoCliente) {
		this.fechaNacimientoCliente = fechaNacimientoCliente;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + idCliente + ", nombreCliente=" + nombreCliente + ", telefonoCliente=" + telefonoCliente
				+ ", direccionCliente=" + direccionCliente + ", fechaNacimientoCliente=" + fechaNacimientoCliente + "]";
	}

	
	
	
	
	

}
