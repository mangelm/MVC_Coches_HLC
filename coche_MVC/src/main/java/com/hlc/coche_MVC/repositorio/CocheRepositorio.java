package com.hlc.coche_MVC.repositorio;

import org.springframework.data.repository.CrudRepository;

import com.hlc.coche_MVC.entidad.Coche;

public interface CocheRepositorio extends CrudRepository<Coche, Long> {

}
