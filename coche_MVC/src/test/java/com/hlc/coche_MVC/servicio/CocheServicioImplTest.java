package com.hlc.coche_MVC.servicio;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.hlc.coche_MVC.entidad.Coche;
import com.hlc.coche_MVC.repositorio.CocheRepositorio;

public class CocheServicioImplTest {
	@Mock // -> Simulamos el repositorio como Dependencia
	private CocheRepositorio cocheRepositorio;

	@InjectMocks // --> Creamos una instacncia real de CocheServicioImpl y se inyecta automáticamente el mock de cocheRepositorio en esta clase
	private CocheServicioImpl cocheServicio;
	
	
	@BeforeEach
	void setup() {
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	void obtenerTodosLosCoches() {
		List<Coche> coches = Arrays.asList(new Coche("Toyota", "1234ABC", "Rojo"),new Coche("Ford", "9976DEF", "Azul"));
		
		
		when(cocheRepositorio.findAll()).thenReturn(coches);
		
		//Llamar al servicio
		List<Coche> coches_servicio = cocheServicio.obtenerTodosLosCoches();
		Integer resultadoEsperado = 2;
		Integer resultado = coches_servicio.size();
		
		assertEquals(resultadoEsperado, resultado, "Debe de devolver 2 coches");
		verify(cocheRepositorio, times(1)).findAll();

	}
	
	
	@Test
	void testGuardarCoche() {
		
	}
}
