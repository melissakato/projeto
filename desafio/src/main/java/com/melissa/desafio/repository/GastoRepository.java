package com.melissa.desafio.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.melissa.desafio.model.Gasto;

/**
 * 
 * @author Melissa Kato
 * @since 11/12/18
 * 
 * Repositório Gastos
 *
 */
@Repository
public interface GastoRepository extends CrudRepository<Gasto, Long> {
	
	List<Gasto> findByCodigoUsuario(Long codigoUsuario);
	
	List<Gasto> findByDataAndCodigoUsuario(Date data, Long codigoUsuario);
	
}
	

