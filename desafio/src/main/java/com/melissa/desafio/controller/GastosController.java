package com.melissa.desafio.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.melissa.desafio.model.Gasto;
import com.melissa.desafio.service.GastoService;

@RestController
@RequestMapping("/api/v1")
//@Path("/api/v1")
public class GastosController {
	
	@Autowired
	private GastoService gastoService;
	
	@PostMapping("/gastos")
	@Consumes(MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Gasto>> insertGastos(@RequestBody List<Gasto>gastos) {
		List<Gasto> gastosRetorno = gastoService.insert(gastos);
		return new ResponseEntity<List<Gasto>>(gastosRetorno, HttpStatus.OK);
	
	}
	
	@PostMapping("/gastos/categoria")
	public ResponseEntity<Gasto> insertGastoCategoria(@RequestBody Gasto gasto) {
		Gasto gastoRetorno = gastoService.insert(gasto);
		return new ResponseEntity<Gasto>(gastoRetorno, HttpStatus.OK);
	
	}
	
	@GetMapping("/gastos/codigoUsuario/{codigoUsuario}")
	@Path("/gastos/codigoUsuario/{codigoUsuario}")
	public List<Gasto> findGastosByCodigoUsuario(@PathVariable long codigoUsuario) {
		List<Gasto> gastos = gastoService.findByCodigoUsuario(codigoUsuario);
		return gastos;
	}
	
	@GetMapping("/gastos/data/{data}/{codigoUsuario}")
	public List<Gasto> findGastosByData(@PathVariable String data, @PathVariable Long codigoUsuario) {
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		List<Gasto> gastos = null;
		try {
			Date dataParam = sdf.parse(data);
			gastos = gastoService.findByDataAndCodigoUsuario(dataParam, codigoUsuario);
			new ResponseEntity<List<Gasto>>(gastos, HttpStatus.OK);
		} catch (ParseException e) {
			new ResponseEntity<List<Gasto>>(gastos, HttpStatus.BAD_REQUEST);
		}
		return gastos;
	}

}
