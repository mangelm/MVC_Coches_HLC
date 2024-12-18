package com.hlc.coche_MVC.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hlc.coche_MVC.entidad.Coche;

import jakarta.annotation.PostConstruct;

@Component
public class InicializarDatos {
	@Autowired
		private CocheServicio cocheServicio;
		
	@PostConstruct
	public void init() {
		
		Coche coche1 = new Coche();
		coche1.setMarca("Toyota");
		coche1.setMatricula("ABC1234");
		coche1.setColor("Rojo");
		cocheServicio.guardarCoche(coche1);
		
		Coche coche2 = new Coche();
		coche2.setMarca("Ford");
		coche2.setMatricula("XYZ5678");
		coche2.setColor("Azul");
		cocheServicio.guardarCoche(coche2);
	}
}
