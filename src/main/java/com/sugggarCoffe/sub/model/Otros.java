package com.sugggarCoffe.sub.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table
public class Otros {

	@Id
    @Column(name="otros")
	private String otros;

	public Otros() {}
	
	public Otros(String otros) {
		this.otros = otros;
	}

	public String getOtros() {
		return otros;
	}

	public void setOtros(String otros) {
		this.otros = otros;
	}

	@Override
	public String toString() {
		return "Otros [otros=" + otros + "]";
	}
	
	
	
	

}
