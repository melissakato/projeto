package com.melissa.desafio.service;

import java.util.Date;
import java.util.List;

import com.melissa.desafio.model.Gasto;

public interface GastoService {
	
	List<Gasto> insert(List<Gasto> listaGasto);
	
	Gasto insert(Gasto gasto);
	
	List<Gasto> findByCodigoUsuario(Long codigoUsuario);
	
	List<Gasto> findByDataAndCodigoUsuario(Date data, Long codigoUsurio);

}
