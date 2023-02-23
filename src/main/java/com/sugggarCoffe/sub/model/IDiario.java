package com.sugggarCoffe.sub.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class IDiario implements Serializable{
	
	private static final long serialVersionUID = -8603078303079175068L;

	@Id
    @Column(name="idIDiario")
	private Long idIDiario;
	
	@ManyToMany
	@JoinTable(name = "idiario_producto")
	private List<Producto> producto;
	
	@ElementCollection
	@Column(name="cantidadIDiario")
	private List<Integer> cantidadIDiario;
	
	@Column(name="fechaIDiario")
	private LocalDate fechaIDiario;
	
	@ManyToOne
    @JoinColumn(name="idUsuario")
	private Usuario idUsuario;
	
	@Column(name="novedadesInventario", length=200)
    private String novedadesInventario;

	public IDiario() {
		super();
	}

	public IDiario(Long idIDiario, List<Producto> producto, List<Integer> cantidadIDiario, LocalDate fechaIDiario,
			Usuario idUsuario,String novedadesInventario) {
		super();
		this.idIDiario = idIDiario;
		this.producto = producto;
		this.cantidadIDiario = cantidadIDiario;
		this.fechaIDiario = fechaIDiario;
		this.idUsuario = idUsuario;
		this.novedadesInventario = novedadesInventario;
	}
	
	

	public String getNovedadesInventario() {
		return novedadesInventario;
	}

	public void setNovedadesInventario(String novedadesInventario) {
		this.novedadesInventario = novedadesInventario;
	}

	public Long getIdIDiario() {
		return idIDiario;
	}

	public List<Producto> getProducto() {
		return producto;
	}

	public List<Integer> getCantidadIDiario() {
		return cantidadIDiario;
	}

	public LocalDate getFechaIDiario() {
		return fechaIDiario;
	}

	public Usuario getUsuario() {
		return idUsuario;
	}

	public void setIdIDiario(Long idIDiario) {
		this.idIDiario = idIDiario;
	}

	public void setProducto(List<Producto> producto) {
		this.producto = producto;
	}

	public void setCantidadIDiario(List<Integer> cantidadIDiario) {
		this.cantidadIDiario = cantidadIDiario;
	}

	public void setFechaIDiario(LocalDate fechaIDiario) {
		this.fechaIDiario = fechaIDiario;
	}

	public void setUsuario(Usuario usuario) {
		this.idUsuario = usuario;
	}

	@Override
	public String toString() {
		return "IDiario [idIDiario=" + idIDiario + ", producto=" + producto + ", cantidadIDiario=" + cantidadIDiario
				+ ", fechaIDiario=" + fechaIDiario + ", usuario=" + idUsuario + "]";
	}
	
	

}
