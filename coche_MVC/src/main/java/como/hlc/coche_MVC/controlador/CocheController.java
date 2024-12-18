package como.hlc.coche_MVC.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.hlc.coche_MVC.entidad.Coche;
import com.hlc.coche_MVC.servicio.CocheServicio;

@Controller
public class CocheController {
	@Autowired
	CocheServicio cocheServicio;
	@GetMapping("/")
	public String listarCoches(Model model) {
		model.addAttribute("coches", cocheServicio.listarTodosLosCoches());
		return "index";
	}

	@GetMapping("/coche/nuevo")
	public String mostrarFormularioDeNuevoCoche (Model model) {
		Coche coche = new Coche();
		model.addAttribute("coche", coche);
		return "coche-form";
	}
	
	@GetMapping("/coche/editar/{id}")
	public String mostrarFormularioEditarCoche (@PathVariable Long id, Model model) {
		Coche coche = cocheServicio.obtenerCochePorId(id);
		model.addAttribute("coche", coche);
		return "coche-form";
	}
	
	@GetMapping("/coche")
	public String guardarCoche(@ModelAttribute Coche coche) {
		cocheServicio.guardarCoche(coche);
		return "redirect:/";
	}
	
	@GetMapping("/coche/eliminar/{id}")
	public String eliminarCoche(@PathVariable Long id) {
		cocheServicio.eliminarCoche(id);
		return "redirect:/";
	}
}
