package br.hoteleveris.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.hoteleveris.app.request.ClienteRequest;
import br.hoteleveris.app.response.BaseResponse;
import br.hoteleveris.app.service.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteController extends BaseController {

	@Autowired
	private ClienteService service;

	@PostMapping
	public ResponseEntity<BaseResponse> inserir(@RequestBody ClienteRequest request) {
		try {
			BaseResponse response = service.inserir(request);
			return ResponseEntity.status(response.statusCode).body(response);
		} catch (Exception e) {
			return ResponseEntity.status(errorBase.statusCode).body(errorBase);
		}
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<BaseResponse> obter(@PathVariable Long id) {
		try {
			BaseResponse response = service.obter(id);
			return ResponseEntity.status(response.statusCode).body(response);
		} catch (Exception e) {
			return ResponseEntity.status(errorBase.statusCode).body(errorBase);

		}

	}

}