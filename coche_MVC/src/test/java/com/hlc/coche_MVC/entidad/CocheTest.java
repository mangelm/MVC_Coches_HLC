package com.hlc.coche_MVC.entidad;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CocheTest {
	
	private Coche coche;
	
	@BeforeEach
	void setup() {
		coche = new Coche();
	}

	@Test
	@DisplayName("Prueba de Getter and Setter de ID")
	void testSetAndGetID() {
		Long id = 1L;
		coche.setId(1L);
		
		assertEquals(id, coche.getId(), "El ID no es el mismo");
		
	}
	
	@Test
	@DisplayName("Prueba de Getter y Setter de Marca")
	void testSetterGetterMarca() {
		String resultadoEsperado = "Toyota";
		
		coche.setMarca(resultadoEsperado);
		
		assertEquals(resultadoEsperado, coche.getMarca(), "Marca no se corresponde con el getter");
	}
	
	@Test
	@DisplayName("Prueba de Constructor con parámetros")
	void testConstructorConParametros() {
		String marca = "Toyota";
		String matricula = "1245ABC";
		String color = "Rojo";
		
		Coche coche = new Coche(marca, matricula, color);
		
		assertEquals(marca, coche.getMarca(), "La marca del constructor no coincide");
		assertEquals(matricula, coche.getMatricula());
		assertEquals(color, coche.getColor());
		
	}
}