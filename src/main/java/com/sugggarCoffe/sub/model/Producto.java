package com.sugggarCoffe.sub.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table
public class Producto implements Serializable{
	
	private static final long serialVersionUID = -2874019750945558354L;

	@Id
    @Column(name="idProducto")
    private Long idProducto;
 	
    @Column(name="nombreProducto", length=40)
    private String nombreProducto;
    
    @Column(name="precioProducto")
    private int precioProducto;
    
    @Column(name="tipo")
    private String tipo;
    
    @Column(name="fechaCreacionP")
    private LocalDate fechaCreacionP;
    
    @Column(name="fechaVencimientoP")
    private LocalDate fechaVencimientoP;
    
    @Column(name="descripcionP", length=100)
    private String descripcionP;
    
    @OneToMany( mappedBy="producto")
    //@JoinColumn(name="idInsumo")
    private List<Insumo> insumo;

	public Producto() {
		
	}

	public Producto(Long idProducto, String nameProduct, int precioProducto, LocalDate fechaCreacionP, LocalDate fechaVencimientoP,String tipo,
			Proveedor proveedor, String descripcionP,List<Insumo> insumo) {
		super();
		this.idProducto = idProducto;
		this.nombreProducto = nameProduct;
		this.precioProducto = precioProducto;
		this.tipo=tipo;
		this.fechaCreacionP = fechaCreacionP;
		this.fechaVencimientoP = fechaVencimientoP;		
		this.descripcionP = descripcionP;
		this.insumo=insumo;
	}

	public Long getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Long idProducto) {
		this.idProducto = idProducto;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public int getPrecioProducto() {
		return precioProducto;
	}

	public void setPrecioProducto(int precioProducto) {
		this.precioProducto = precioProducto;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public LocalDate getFechaCreacionP() {
		return fechaCreacionP;
	}

	public void setFechaCreacionP(LocalDate fechaCreacion) {
		this.fechaCreacionP = fechaCreacion;
	}

	public LocalDate getFechaVencimientoP() {
		return fechaVencimientoP;
	}

	public void setFechaVencimientoP(LocalDate fechaVencimientoP) {
		this.fechaVencimientoP = fechaVencimientoP;
	}

	public String getDescripcionP() {
		return descripcionP;
	}

	public void setDescripcionP(String descripcionP) {
		this.descripcionP = descripcionP;
	}

	public List<Insumo> getInsumo() {
		return insumo;
	}

	public void setInsumo(List<Insumo> insumo) {
		this.insumo = insumo;
	}

	@Override
	public String toString() {
		return "Producto [idProducto=" + idProducto + ", nameProducto=" + nombreProducto + ", precioProducto=" + precioProducto
				+ ", fechaCreacion=" + fechaCreacionP + ", fechaVencimiento=" + fechaVencimientoP + 
				", descripcion=" + descripcionP + ", tipo="+ tipo+ ", insumos= "+insumo+"]";
	}

}

	
	

