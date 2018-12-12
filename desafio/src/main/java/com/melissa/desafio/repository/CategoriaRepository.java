package com.melissa.desafio.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.melissa.desafio.model.Categoria;


/**
 * 
 * @author melissa.kato
 * @since 11/12/18
 * 
 * Repositório Categoria
 *
 */

@Repository
public interface CategoriaRepository extends CrudRepository<Categoria, Long> {
	
}
	