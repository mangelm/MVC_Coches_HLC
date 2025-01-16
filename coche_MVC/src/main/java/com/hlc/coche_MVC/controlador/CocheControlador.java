package com.hlc.coche_MVC.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hlc.coche_MVC.entidad.Coche;
import com.hlc.coche_MVC.servicio.CocheServicio;
import com.hlc.coche_MVC.servicio.CocheServicioImpl;

@Controller
@RequestMapping("/coches")
public class CocheControlador {
	
    private final CocheServicio cocheServicio;
    
    /*
     * VISTAS
     */
    private final String VISTA_LISTA = "coches/lista";
    private final String VISTA_FORMULARIO = "coches/formulario";
    private final String REDIRECT_COCHE = "redirect:/coches";
    
    
    public CocheControlador(CocheServicio cocheServicio) {
        this.cocheServicio = cocheServicio;
    }
    
    // Mostrar todos los coches
    @GetMapping
    public String listarCoches(Model model) {
        List<Coche> coches = cocheServicio.obtenerTodosLosCoches();
        model.addAttribute("coches", coches);
        return VISTA_LISTA; 
    }
    
    // Mostrar formulario para agregar un nuevo coche
    @GetMapping("/nuevo")
    public String mostrarFormularioNuevoCoche(Model model) {
        model.addAttribute("coche", new Coche());
        return VISTA_FORMULARIO;
    }
    
    // Guardar un coche nuevo
    @PostMapping
    public String guardarCoche(@ModelAttribute("coche") Coche coche) {
        cocheServicio.guardarCoche(coche);
        return REDIRECT_COCHE;
    }
    
    // Mostrar formulario para editar un coche existente
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditarCoche(@PathVariable Long id, Model model) {
        Coche coche = cocheServicio.obtenerCochePorId(id);
        model.addAttribute("coche", coche);
        return VISTA_FORMULARIO;
    }
    
    // Actualizar un coche existente
    @PostMapping("/{id}")
    public String actualizarCoche(@PathVariable Long id, @ModelAttribute("coche") Coche coche) {
        coche.setId(id);
        cocheServicio.guardarCoche(coche);
        return REDIRECT_COCHE;
    }
    
    // Eliminar un coche
    @GetMapping("/eliminar/{id}")
    public String eliminarCoche(@PathVariable Long id) {
        cocheServicio.eliminarCoche(id);
        return REDIRECT_COCHE;
    }
}
