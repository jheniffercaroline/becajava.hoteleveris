package br.hoteleveris.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.hoteleveris.app.model.Comodidade;
import br.hoteleveris.app.repository.ComodidadeRepository;
import br.hoteleveris.app.request.ComodidadeRequest;
import br.hoteleveris.app.response.BaseResponse;
import br.hoteleveris.app.response.ComodidadeResponse;

@Service
public class ComodidadeService {

	@Autowired
	private ComodidadeRepository _repository;

	public BaseResponse inserir(ComodidadeRequest request) {
		Comodidade comodidade = new Comodidade();
		BaseResponse base = new BaseResponse();
		base.statusCode = 400;

		if (request.getNome().isEmpty()) {
			base.message = "Insira uma nova comodidade";
			return base;
		}
		comodidade.setNome(request.getNome());

		_repository.save(comodidade);
		base.statusCode = 201;
		base.message = "Foi inserida com sucesso sua nova comodidade ";
		return base;

	}

	public ComodidadeResponse obter(Long id) {
		Optional<Comodidade> comodidade = _repository.findById(id);
		ComodidadeResponse response = new ComodidadeResponse();

		if (comodidade == null) {
			response.message = "Por favor procure uma comodide existente ou insira uma nova caso ela não exista ";
			response.statusCode = 404;
			return response;
		}

		response.setNome(comodidade.get().getNome());

		response.message = "Comodidade obtida com sucesso";
		response.statusCode = 200;
		return response;

	}

}
