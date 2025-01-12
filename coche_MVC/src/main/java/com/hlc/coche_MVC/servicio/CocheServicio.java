package com.hlc.coche_MVC.servicio;
import java.util.List;

import com.hlc.coche_MVC.entidad.Coche;

public interface CocheServicio {
	
	List<Coche> obtenerTodosLosCoches();
	Coche obtenerCochePorId(Long id);
	Coche guardarCoche(Coche coche);
	void eliminarCoche(Long id);
}
