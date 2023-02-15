package com.sugggarCoffe.sub.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class Usuario{

	@Id
    @Column(name="idUsuario")
    private Long idUsuario;
 	
    @Column(name="nombreUsuario", nullable = false, length=40)
    private String nombreUsuario;
    
    @ManyToOne
    @JoinColumn(name="idRol")
    private Rol rol;
    
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
    
    @Column(name="descripcionUsuario")
    private String descripcionUsuario;

	@Column(name="contrasenaUsuario")
	private String contrasenaUsuario;

	public Usuario() {
		super();
	}

	public Usuario(Long idUsuario, String nombreUsuario, Rol rol, LocalDate fechaNacimientoUsuario,
			LocalDate fechaCreacionUsuario, String correoUsuario, String numeroUsuario, String direccionUsuario,
			String descripcionUsuario,String contrasenaUsuario) {
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
		this.contrasenaUsuario = contrasenaUsuario;
	}

	public Usuario(String nombreUsuario, String contrasenaUsuario, Rol rol) {
		this.nombreUsuario = nombreUsuario;
		this.contrasenaUsuario = contrasenaUsuario;
		this.rol = rol;
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

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
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

	public String getContrasenaUsuario() {
		return contrasenaUsuario;
	}

	public void setContrasenaUsuario(String contrasenaUsuario) {
		this.contrasenaUsuario = contrasenaUsuario;
	}

	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", nombreUsuario=" + nombreUsuario + ", rol=" + rol
				+ ", fechaNacimientoUsuario=" + fechaNacimientoUsuario + ", fechaCreacionUsuario="
				+ fechaCreacionUsuario + ", correoUsuario=" + correoUsuario + ", numeroUsuario=" + numeroUsuario
				+ ", direccionUsuario=" + direccionUsuario + ", descripcion=" + descripcionUsuario + "]";
	}

}
