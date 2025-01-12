package com.hlc.coche_MVC.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BienvenidaControlador {
	
	@GetMapping("/bienvenida")
	public String mostrarBienvenida(Model model) {
		model.addAttribute("mensaje","Bienvenido a la aplicación");
		return "bienvenida";
	}
}
