package com.sugggarCoffe.sub.model;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table
public class Proveedor implements Serializable {

	private static final long serialVersionUID = 2623714926785500047L;

	@Id
    @Column(name="idProveedor")
    private Long idProveedor;
 	
    @Column(name="razonSocial", nullable = false, length=100)
    private String razonSocial;
    
    @Column(name="nombreContacto", nullable = false, length=100)
    private String nombreContacto;
    
    @Column(name="fechaCreacionPr")
    private LocalDate fechaCreacionPr;
    
    @Column(name="correoProveedor")
    private String correoProveedor;
    
    @Column(name="numeroProveedorP")
    private String numeroProveedorP;
    
    @Column(name="direccionProveedor")
    private String direccionProveedor;
    
    @Column(name="productosProveedor", nullable = false, length=100)
    private String productosProveedor;

	public Proveedor() {
	}

	public Proveedor(Long idProveedor, String razonSocial, String nombreContacto, LocalDate fechaCreacionPr,
			String correoProveedor, String numeroProveedorP, String direccionProveedor, String productosProveedor) {
		super();
		this.idProveedor = idProveedor;
		this.razonSocial = razonSocial;
		this.nombreContacto = nombreContacto;
		this.fechaCreacionPr = fechaCreacionPr;
		this.correoProveedor = correoProveedor;
		this.numeroProveedorP = numeroProveedorP;
		this.direccionProveedor = direccionProveedor;
		this.productosProveedor = productosProveedor;
	}



	public Long getIdProveedor() {
		return idProveedor;
	}

	public void setIdProveedor(Long idProveedor) {
		this.idProveedor = idProveedor;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public String getNombreContacto() {
		return nombreContacto;
	}

	public void setNombreContacto(String nombreContacto) {
		this.nombreContacto = nombreContacto;
	}

	public LocalDate getFechaCreacionPr() {
		return fechaCreacionPr;
	}

	public void setFechaCreacionPr(LocalDate fechaCreacionPr) {
		this.fechaCreacionPr = fechaCreacionPr;
	}

	public String getCorreoProveedor() {
		return correoProveedor;
	}

	public void setCorreoProveedor(String correoProveedor) {
		this.correoProveedor = correoProveedor;
	}

	public String getNumeroProveedorP() {
		return numeroProveedorP;
	}

	public void setNumeroProveedorP(String numeroProveedorP) {
		this.numeroProveedorP = numeroProveedorP;
	}

	public String getDireccionProveedor() {
		return direccionProveedor;
	}

	public void setDireccionProveedor(String direccionProveedor) {
		this.direccionProveedor = direccionProveedor;
	}

	public String getProductosProveedor() {
		return productosProveedor;
	}

	public void setProductosProveedor(String productosProveedor) {
		this.productosProveedor = productosProveedor;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Proveedor [idProveedor=" + idProveedor + ", razonSocial=" + razonSocial + ", nombreContacto="
				+ nombreContacto + ", fechaCreacionPr=" + fechaCreacionPr + ", correoProveedor=" + correoProveedor
				+ ", numeroProveedorP=" + numeroProveedorP + ", direccionProveedor=" + direccionProveedor
				+ ", productosProveedor=" + productosProveedor + "]";
	}
	
	

    
	
}
