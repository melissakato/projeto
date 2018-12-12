package com.melissa.desafio.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.melissa.desafio.model.Gasto;
import com.melissa.desafio.repository.GastoRepository;
import com.melissa.desafio.service.GastoService;

/**
 * 
 * @author melissa.kato
 * @since 11/12/18
 * 
 * Implementação do serviço relacionado ao gasto do cartão.
 *
 */

@Service
public class GastoServiceImpl implements GastoService {
	
	@Autowired
	GastoRepository repository;
	

	public List<Gasto> insert(List<Gasto> listaGasto) {
		List<Gasto> gasto = new ArrayList<Gasto>();
		listaGasto.forEach(elemento -> gasto.add(repository.save(elemento)));
		return gasto;
		
	}

	@Override
	public List<Gasto> findByCodigoUsuario(Long codigoUsuario) {
	   return repository.findByCodigoUsuario(codigoUsuario);
	}

	@Override
	public List<Gasto> findByDataAndCodigoUsuario(Date data, Long codigoUsuario) {
		return repository.findByDataAndCodigoUsuario(data, codigoUsuario);
	}

	@Override
	public Gasto insert(Gasto gasto) {
		return repository.save(gasto);
	}

}
