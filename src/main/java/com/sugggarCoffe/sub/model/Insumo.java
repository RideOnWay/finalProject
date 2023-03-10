package com.sugggarCoffe.sub.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class Insumo {
	
	@Id
    @Column(name="idInsumo")
    private Long idInsumo;
 	
    @Column(name="nombreInsumo",  length=40)
    private String nombreInsumo;
    
    @Column(name="precioInsumo")
    private int precioInsumo;
    
    @Column(name="tipoInsumo")
    private String tipoInsumo;
    
    @Column(name="fechaCreacionInsumo")
    private LocalDate fechaCreacionInsumo;
   
    @Column(name="fechaVencimientoInsumo")
    private LocalDate fechaVencimientoInsumo;
    
    @ManyToOne
    @JoinColumn(name="idProveedor")
    private Proveedor proveedor;
    
    private List<Producto> producto ;
    
    @Column(name="descripcionInsumo", columnDefinition="sin descripción")
    private String descripcionInsumo;

	public Insumo() {
		super();
	}

	public Insumo(Long idInsumo, String nombreInsumo, int precioInsumo, String tipoInsumo, LocalDate fechaCreacionInsumo,
			LocalDate fechaVencimientoInsumo, Proveedor proveedor, String descripcionInsumo,  List<Producto> producto) {
		this.idInsumo = idInsumo;
		this.nombreInsumo = nombreInsumo;
		this.precioInsumo = precioInsumo;
		this.tipoInsumo = tipoInsumo;
		this.fechaCreacionInsumo = fechaCreacionInsumo;
		this.fechaVencimientoInsumo = fechaVencimientoInsumo;
		this.proveedor = proveedor;
		this.descripcionInsumo = descripcionInsumo;
		this.producto=producto;
	}

	public Long getIdInsumo() {
		return idInsumo;
	}

	public void setIdInsumo(Long idInsumo) {
		this.idInsumo = idInsumo;
	}

	public String getNombreInsumo() {
		return nombreInsumo;
	}

	public void setNombreInsumo(String nombreInsumo) {
		this.nombreInsumo = nombreInsumo;
	}

	public int getPrecioInsumo() {
		return precioInsumo;
	}

	public void setPrecioInsumo(int precioInsumo) {
		this.precioInsumo = precioInsumo;
	}

	public String getTipoInsumo() {
		return tipoInsumo;
	}

	public void setTipoInsumo(String tipoInsumo) {
		this.tipoInsumo = tipoInsumo;
	}

	public LocalDate getFechaCreacionInsumo() {
		return fechaCreacionInsumo;
	}

	public void setFechaCreacionInsumo(LocalDate fechaCreacionInsumo) {
		this.fechaCreacionInsumo = fechaCreacionInsumo;
	}

	public LocalDate getFechaVencimientoInsumo() {
		return fechaVencimientoInsumo;
	}

	public void setFechaVencimientoInsumo(LocalDate fechaVencimientoInsumo) {
		this.fechaVencimientoInsumo = fechaVencimientoInsumo;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	public String getDescripcionInsumo() {
		return descripcionInsumo;
	}

	public void setDescripcionInsumo(String descripcionInsumo) {
		this.descripcionInsumo = descripcionInsumo;
	}


	@Override
	public String toString() {
		return "Insumo [idInsumo=" + idInsumo + ", nombreInsumo=" + nombreInsumo + ", precioInsumo=" + precioInsumo
				+ ", tipoInsumo=" + tipoInsumo + ", fechaCreacionInsumo=" + fechaCreacionInsumo
				+ ", fechaVencimientoInsumo=" + fechaVencimientoInsumo + ", proveedor=" + proveedor.getIdProveedor()
				+ ", descripcionInsumo=" + descripcionInsumo + ", producto="+ "]";
	}

	public List<Producto> getProducto() {
		return producto;
	}

	public void setProducto(List<Producto> producto) {
		this.producto = producto;
	}
    

}
