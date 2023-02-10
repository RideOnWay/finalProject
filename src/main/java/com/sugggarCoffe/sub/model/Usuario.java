package com.sugggarCoffe.sub.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Usuario {

	
	@Id
    @Column(name="idUsuario")
    private Long idUsuario;
 	
    @Column(name="nombreUsuario", nullable = false, length=40)
    private String nombreUsuario;
    
    @Column(name="rol", nullable = false)
    private int rol;
    
    @Column(name="fechaNacimientoUsuario")
    private LocalDate fechaNacimientoUsuario;
    
    @Column(name="fechaCreacionUsuario")
    private LocalDate fechaCreacionUsuario;
    
    @Column(name="correoUsuario")
    private String correoUsuario;
    
    @Column(name="numeroUsuario")
    private String numeroUsuario;
    
    @Column(name="direccionUsuario")
    private String direccionUsuario;
    
    @Column(name="descripcionUsuario", nullable = false, length=100)
    private String descripcionUsuario;

	public Usuario() {
		super();
	}

	public Usuario(Long idUsuario, String nombreUsuario, int rol, LocalDate fechaNacimientoUsuario,
			LocalDate fechaCreacionUsuario, String correoUsuario, String numeroUsuario, String direccionUsuario,
			String descripcionUsuario) {
		super();
		this.idUsuario = idUsuario;
		this.nombreUsuario = nombreUsuario;
		this.rol = rol;
		this.fechaNacimientoUsuario = fechaNacimientoUsuario;
		this.fechaCreacionUsuario = fechaCreacionUsuario;
		this.correoUsuario = correoUsuario;
		this.numeroUsuario = numeroUsuario;
		this.direccionUsuario = direccionUsuario;
		this.descripcionUsuario = descripcionUsuario;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public int getRol() {
		return rol;
	}

	public void setRol(int rol) {
		this.rol = rol;
	}

	public LocalDate getFechaNacimientoUsuario() {
		return fechaNacimientoUsuario;
	}

	public void setFechaNacimientoUsuario(LocalDate fechaNacimientoUsuario) {
		this.fechaNacimientoUsuario = fechaNacimientoUsuario;
	}

	public LocalDate getFechaCreacionUsuario() {
		return fechaCreacionUsuario;
	}

	public void setFechaCreacionUsuario(LocalDate fechaCreacionUsuario) {
		this.fechaCreacionUsuario = fechaCreacionUsuario;
	}

	public String getCorreoUsuario() {
		return correoUsuario;
	}

	public void setCorreoUsuario(String correoUsuario) {
		this.correoUsuario = correoUsuario;
	}

	public String getNumeroUsuario() {
		return numeroUsuario;
	}

	public void setNumeroUsuario(String numeroUsuario) {
		this.numeroUsuario = numeroUsuario;
	}

	public String getDireccionUsuario() {
		return direccionUsuario;
	}

	public void setDireccionUsuario(String direccionUsuario) {
		this.direccionUsuario = direccionUsuario;
	}

	public String getDescripcionUsuario() {
		return descripcionUsuario;
	}

	public void setDescripcionUsuario(String descripcionUsuario) {
		this.descripcionUsuario = descripcionUsuario;
	}

	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", nombreUsuario=" + nombreUsuario + ", rol=" + rol
				+ ", fechaNacimientoUsuario=" + fechaNacimientoUsuario + ", fechaCreacionUsuario="
				+ fechaCreacionUsuario + ", correoUsuario=" + correoUsuario + ", numeroUsuario=" + numeroUsuario
				+ ", direccionUsuario=" + direccionUsuario + ", descripcion=" + descripcionUsuario + "]";
	}
    
    
    
}
