package com.hlc.coche_MVC.config;

import org.springframework.stereotype.Component;

import com.hlc.coche_MVC.entidad.Coche;
import com.hlc.coche_MVC.repositorio.CocheRepositorio;

import jakarta.annotation.PostConstruct;

@Component
public class InicializarDatos {

	private CocheRepositorio cocheRepositorio;
	
	public InicializarDatos(CocheRepositorio cocheRepositorio) {
		this.cocheRepositorio = cocheRepositorio;
	}
	
	@PostConstruct
	public void init() {
		Coche coche1 = new Coche("Toyota", "1234ABC", "Rojo");
		Coche coche2 = new Coche("Ford", "9876ZXY", "Verde");
		Coche coche3 = new Coche("Honda", "9134RST", "Negro");
		
		cocheRepositorio.save(coche1);
		cocheRepositorio.save(coche2);
		cocheRepositorio.save(coche3);
	}

}
