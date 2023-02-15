package com.sugggarCoffe.sub.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table
public class Venta {

	@Id
    @Column(name="idVenta")
    private Long idVenta;
	
	@ManyToOne
    @JoinColumn(name="idCliente")
    private Cliente cliente;
    
	@ManyToOne
    @JoinColumn(name="idUsuario")
    private Usuario usuario;
    
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
		super();
	}

	public Venta(Long idVenta, Cliente cliente, Usuario usuario, int precioTotal,
			LocalDate fechaVenta, LocalTime horaVenta, String observacion) {
		super();
		this.idVenta = idVenta;

		this.cliente = cliente;
		this.usuario = usuario;
		this.precioTotal = precioTotal;
		this.fechaVenta = fechaVenta;
		this.horaVenta = horaVenta;
		this.observacion = observacion;
	}

	//setters and getters
	public Long getIdVenta() {
		return idVenta;
	}

	

	public Cliente getCliente() {
		return cliente;
	}

	public Usuario getUsuario() {
		return usuario;
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

	

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
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

	//tostring
	@Override
	public String toString() {
		return "Venta [idVenta=" + idVenta + ", producto="  + ", cliente=" + cliente + ", usuario=" + usuario
				+ ", precioTotal=" + precioTotal + ", fechaVenta=" + fechaVenta + ", horaVenta=" + horaVenta
				+ ", observacion=" + observacion + "]";
	}
}
