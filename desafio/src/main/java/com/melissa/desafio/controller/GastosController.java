package com.melissa.desafio.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.melissa.desafio.model.Gasto;
import com.melissa.desafio.service.GastoService;

/**
 * 
 * @author melissa.kato
 * @since 12/12/2018
 * 
 * Servi�os REST referentes ao gasto com cart�o.
 *
 */


@RestController
@RequestMapping("/api/v1")
public class GastosController {
	
	@Autowired
	private GastoService gastoService;
	
	/**
	 * Respons�vel pela inclus�o de uma lista de gastos (funcionalidade obrigat�ria).
	 * @param gastos
	 * 
	 * @return lista de gastos que foi inclu�da.
	 */
	@RequestMapping(value="/gastos" , method = RequestMethod.POST)
	public ResponseEntity<List<Gasto>> insertGastos(@RequestBody List<Gasto>gastos) {
		List<Gasto> gastosRetorno = gastoService.insert(gastos);
		return new ResponseEntity<List<Gasto>>(gastosRetorno, HttpStatus.OK);
	}
	
	/**
	 * Respons�vel pela pesquisa dos gastos a partir de um c�digo do usu�rio fornecido. (funcionalidade obrigat�ria)
	 * @param codigoUsuario
	 * 
	 * @return lista de gastos
	 */
	@RequestMapping(value="/gastos/codigoUsuario/{codigoUsuario}" , method = RequestMethod.GET)
	public List<Gasto> findGastosByCodigoUsuario(@PathVariable long codigoUsuario) {
		List<Gasto> gastos = gastoService.findByCodigoUsuario(codigoUsuario);
		return gastos;
	}
	
	
	/**
	 * Respons�vel pela inclus�o de uma categoria do gasto. (funcionalidade eletiva)
	 * @param gasto
	 * 
	 * @return o gasto que foi inclu�do com a categoria.
	 */
	@RequestMapping(value="/gastos/categoria" , method = RequestMethod.POST)
	public ResponseEntity<Gasto> insertGastoCategoria(@RequestBody Gasto gasto) {
		Gasto gastoRetorno = gastoService.insert(gasto);
		return new ResponseEntity<Gasto>(gastoRetorno, HttpStatus.OK);
	}
	
	
	
	/**
	 * Respons�vel pelo filtro de gastos a partir de uma data e um c�digo de usu�rio fornecidos. (funcionalidade eletiva)
	 * @param data
	 * @param codigoUsuario
	 * 
	 * @return lista de gastos
	 */
	@RequestMapping(value="/gastos/data/{data}/{codigoUsuario}" , method = RequestMethod.GET)
	public ResponseEntity<List<Gasto>> findGastosByData(@PathVariable String data, @PathVariable Long codigoUsuario) {
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		List<Gasto> gastos = null;
		try {
			Date dataParam = sdf.parse(data);
			gastos = gastoService.findByDataAndCodigoUsuario(dataParam, codigoUsuario);
			
		} catch (ParseException e) {
			return new ResponseEntity<List<Gasto>>(gastos, HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<List<Gasto>>(gastos, HttpStatus.OK);
	}

}
