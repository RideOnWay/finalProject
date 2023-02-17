package com.sugggarCoffe.sub.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class Venta implements Serializable{

	private static final long serialVersionUID = 4253329364189506127L;

	@Id
    @Column(name="idVenta")
    private Long idVenta;
	
	@ManyToOne
    @JoinColumn(name="idCliente")
    private Cliente idCliente;
    
	@ManyToOne
    @JoinColumn(name="idUsuario")
    private Usuario idUsuario;
	
	@ManyToMany
    @JoinTable(name="venta_producto")
    private List<Producto> producto;

	@Column(name="precioTotal")
    private int precioTotal;
    
    @Column(name="fechaVenta")
    private LocalDate fechaVenta;
    
    @Column(name="horaVenta")
    private LocalTime horaVenta;
     
    @Column(name="observacion")
    private String observacion;

    //constructores
	public Venta() {
		
	}

	public Venta(Long idVenta, Cliente idCliente, Usuario idUsuario, List<Producto> producto, int precioTotal,
			LocalDate fechaVenta, LocalTime horaVenta, String observacion) {
		super();
		this.idVenta = idVenta;
		this.idCliente = idCliente;
		this.idUsuario = idUsuario;
		this.producto = producto;
		this.precioTotal = precioTotal;
		this.fechaVenta = fechaVenta;
		this.horaVenta = horaVenta;
		this.observacion = observacion;
		this.producto=producto;
	}



	public Long getIdVenta() {
		return idVenta;
	}

	public Cliente getIdCliente() {
		return idCliente;
	}

	public Usuario getIdUsuario() {
		return idUsuario;
	}

	public List<Producto> getProducto() {
		return producto;
	}

	public int getPrecioTotal() {
		return precioTotal;
	}

	public LocalDate getFechaVenta() {
		return fechaVenta;
	}

	public LocalTime getHoraVenta() {
		return horaVenta;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setIdVenta(Long idVenta) {
		this.idVenta = idVenta;
	}

	public void setIdCliente(Cliente idCliente) {
		this.idCliente = idCliente;
	}

	public void setIdUsuario(Usuario idUsuario) {
		this.idUsuario = idUsuario;
	}

	public void setProducto(List<Producto> producto) {
		this.producto = producto;
	}

	public void setPrecioTotal(int precioTotal) {
		this.precioTotal = precioTotal;
	}

	public void setFechaVenta(LocalDate fechaVenta) {
		this.fechaVenta = fechaVenta;
	}

	public void setHoraVenta(LocalTime horaVenta) {
		this.horaVenta = horaVenta;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	@Override
	public String toString() {
		return "Venta [idVenta=" + idVenta + ", idCliente=" + idCliente + ", idUsuario=" + idUsuario + ", producto="
				+ ", precioTotal=" + precioTotal + ", fechaVenta=" + fechaVenta + ", horaVenta=" + horaVenta
				+ ", observacion=" + observacion + "]";
	}

	
}
