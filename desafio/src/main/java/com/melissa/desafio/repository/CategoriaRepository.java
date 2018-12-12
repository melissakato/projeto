package com.melissa.desafio.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.melissa.desafio.model.Categoria;


/**
 * 
 * @author Melissa Kato
 * @since 11/12/18
 * 
 * Reposit�rio Gastos
 *
 */
@Repository
public interface CategoriaRepository extends CrudRepository<Categoria, Long> {
	
}
	