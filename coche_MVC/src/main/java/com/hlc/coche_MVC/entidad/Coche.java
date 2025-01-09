package com.hlc.coche_MVC.entidad;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Coche {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String Marca;
	
	private String Matricula;
	
	private String Color;
	
	public Long getId(){
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	
	public String getMarca(){
		return Marca;
	}
	
	public void setMarca(String Marca) {
		this.Marca = Marca;
	}
	
	public String getMatricula(){
		return Matricula;
	}
	
	public void setMatricula(String Matricula) {
		this.Matricula = Matricula;
	}
	
	public String getColor(){
		return Color;
	}
	
	public void setColor(String Color) {
		this.Color = Color;
	}
	
	
}
