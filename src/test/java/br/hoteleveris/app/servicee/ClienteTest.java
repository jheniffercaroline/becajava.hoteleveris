//package br.hoteleveris.app.servicee;
//
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import br.hoteleveris.app.request.ClienteRequest;
//import br.hoteleveris.app.response.BaseResponse;
//import br.hoteleveris.app.response.ClienteResponse;
//import br.hoteleveris.app.service.implement.ClienteServiceImp;
//
//@SpringBootTest
//public class ClienteTest {
//
//	@Autowired
//	private ClienteServiceImp service;
//
//	@Test
//	public void inserir() {
//		ClienteRequest request = new ClienteRequest();
//		request.setCpf("1234");
//		request.setHash("DeuséFiel");
//		request.setNome("ILoveEveris");
//
//		BaseResponse response = service.inserir(request);
//		Assertions.assertEquals(201, response.getStatusCode());
//		Assertions.assertEquals("Cliente inserido com sucesso!", response.getMessage());
//
//	}
//
//	@Test
//	public void inserirSemCpf() {
//		ClienteRequest request = new ClienteRequest();
//		request.setHash("DeuséFiel");
//		request.setNome("ILoveEveris");
//		request.setCpf("");
//
//		BaseResponse response = service.inserir(request);
//		Assertions.assertEquals(400, response.getStatusCode());
//		Assertions.assertEquals("Erro, Preencha o CPF", response.getMessage());
//
//	}
//
//	@Test
//	public void inserirCpfNulo() {
//		ClienteRequest request = new ClienteRequest();
//		request.setHash("DeuséFiel");
//		request.setNome("ILoveEveris");
//		request.setCpf(null);
//
//		BaseResponse response = service.inserir(request);
//		Assertions.assertEquals(400, response.getStatusCode());
//		Assertions.assertEquals("Erro, Preencha o CPF", response.getMessage());
//
//	}
//
//	@Test
//	public void inserirSemNome() {
//		ClienteRequest request = new ClienteRequest();
//		request.setCpf("1234");
//		request.setHash("DeuséFiel");
//		request.setNome("");
//
//		BaseResponse response = service.inserir(request);
//		Assertions.assertEquals(400, response.getStatusCode());
//		Assertions.assertEquals("Erro, Preencha o nome", response.getMessage());
//
//	}
//
//	@Test
//	public void inserirNomeNulo() {
//		ClienteRequest request = new ClienteRequest();
//		request.setCpf("1234");
//		request.setHash("DeuséFiel");
//		request.setNome(null);
//
//		BaseResponse response = service.inserir(request);
//		Assertions.assertEquals(400, response.getStatusCode());
//		Assertions.assertEquals("Erro, Preencha o nome", response.getMessage());
//
//	}
//
//	@Test
//	public void obter() {
//		Long id = 29L;
//		ClienteResponse response = service.obter(id);
//		Assertions.assertEquals(200, response.getStatusCode());
//		Assertions.assertEquals("Cliente Obtido com sucesso", response.getMessage());
//
//	}
//
//}