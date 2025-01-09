package com.hlc.coche_MVC.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hlc.coche_MVC.entidad.Coche;

@Repository
public interface CocheRepositorio extends CrudRepository<Coche, Long> {

}
