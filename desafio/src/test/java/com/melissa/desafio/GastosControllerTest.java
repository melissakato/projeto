package com.melissa.desafio;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.melissa.desafio.controller.GastosController;
import com.melissa.desafio.model.Categoria;
import com.melissa.desafio.model.Gasto;
import com.melissa.desafio.service.GastoService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = GastosController.class, secure = false)
public class GastosControllerTest {
	
	@Autowired
	private MockMvc mock;

	@MockBean
	private GastoService gastoService;

	
	@Test
	public void testInsertGastos() throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date data = sdf.parse("2018-11-26");
		
		Gasto mockGasto = new Gasto(1L, "descricao gasto", 10.11D, 1L, null);
		Gasto mockGasto1 = new Gasto(2L, "descricao gasto 1", 22.22D, 1L, data);
		
		List<Gasto> listaMockGasto = new ArrayList<Gasto>();
		listaMockGasto.add(mockGasto);
		listaMockGasto.add(mockGasto1);
		
		
		Mockito.when(
				gastoService.insert(listaMockGasto)).thenReturn(listaMockGasto);
		
		String body = (new ObjectMapper()).valueToTree(listaMockGasto).toString();

		RequestBuilder requestBuilder = MockMvcRequestBuilders.post(
				"/api/v1/gastos").content(body).contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mock.perform(requestBuilder).andReturn();

		System.out.println(result.getResponse());
		int expected = 200;

		Assert.assertEquals(expected, result.getResponse().getStatus());
		
	}
	
	
	@Test
	public void testInsertGastoCategoria() throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date data = sdf.parse("2018-11-26");
		
		Categoria mockCategoria = new Categoria(1L, "descricao categoria");
		
		Gasto mockGasto = new Gasto(1L, "descricao gasto", 10.11D, 1L, data, mockCategoria);
		
		String body = (new ObjectMapper()).valueToTree(mockGasto).toString();
		
		Mockito.when(
				gastoService.insert(mockGasto)).thenReturn(mockGasto);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post(
				"/api/v1/gastos/categoria").content(body).contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mock.perform(requestBuilder).andReturn();

		System.out.println(result.getResponse());
		int expected = 200;

		Assert.assertEquals(expected, result.getResponse().getStatus());
	}

	@Test
	public void testFindGastosByCodigoUsuario() throws Exception {
		Date data = new Date();
		Gasto mockGasto = new Gasto(1L, "teste", 10.00D, 1L, null);
		
		List<Gasto> gastos = new ArrayList<>();
		gastos.add(mockGasto);
		Mockito.when(
				gastoService.findByCodigoUsuario(1L)).thenReturn(gastos);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/api/v1/gastos/codigoUsuario/1").accept(
				MediaType.APPLICATION_JSON);

		MvcResult result = mock.perform(requestBuilder).andReturn();

		System.out.println(result.getResponse());
		System.out.println("data: "+data);
		String expected = "[{id:1,descricao:teste,valor:10.0,codigoUsuario:1,data:null}]";

		JSONAssert.assertEquals(expected, result.getResponse()
				.getContentAsString(), false);
	}
	
	
	@Test
	public void testFindGastosByDataAndCodigoUsuario() throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date data = sdf.parse("2018-11-26");
		
		Gasto mockGasto = new Gasto(1L, "teste", 10.00D, 1L, null);
		
		Long codigoUsuario = 1L;
		
		List<Gasto> gastos = new ArrayList<>();
		gastos.add(mockGasto);
		Mockito.when(
				gastoService.findByCodigoUsuario(1L)).thenReturn(gastos);
		
	
		
		Mockito.when(
				gastoService.findByDataAndCodigoUsuario(data, codigoUsuario)).thenReturn(gastos);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/api/v1/gastos/data/2018-11-26/1").accept(
				MediaType.APPLICATION_JSON);

		MvcResult result = mock.perform(requestBuilder).andReturn();

		System.out.println(result.getResponse());
		String expected = "[{id:1,descricao:teste,valor:10.0,codigoUsuario:1,data:null}]";


		JSONAssert.assertEquals(expected, result.getResponse()
				.getContentAsString(), false);
	}	
	

}
