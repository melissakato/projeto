package com.melissa.desafio.service;

import java.util.Date;
import java.util.List;

import com.melissa.desafio.model.Gasto;

/**
 * 
 * @author melissa.kato
 * @since 11/12/18
 * 
 * Interface do serviço relacionado ao gasto de cartão.
 *
 */

public interface GastoService {
	
	List<Gasto> insert(List<Gasto> listaGasto);
	
	Gasto insert(Gasto gasto);
	
	List<Gasto> findByCodigoUsuario(Long codigoUsuario);
	
	List<Gasto> findByDataAndCodigoUsuario(Date data, Long codigoUsurio);

}
