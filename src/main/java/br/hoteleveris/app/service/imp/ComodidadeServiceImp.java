package br.hoteleveris.app.service.imp;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.hoteleveris.app.model.Comodidade;
import br.hoteleveris.app.repository.ComodidadeRepository;
import br.hoteleveris.app.request.ComodidadeRequest;
import br.hoteleveris.app.response.BaseResponse;
import br.hoteleveris.app.response.ComodidadeResponse;
import br.hoteleveris.app.service.ComodidadeService;

@Service
public class ComodidadeServiceImp implements ComodidadeService {

	@Autowired
	private ComodidadeRepository _repository;

	public BaseResponse inserir(ComodidadeRequest request) {
		BaseResponse response = new BaseResponse();
		response.statusCode = 400;

		if (request.getNome() == null || request.getNome() == "") {
			response.message = "Insira uma comodidade e, que seja valida";
			return response;
		}

		Comodidade comodidade = new Comodidade(
				request.getId(),
				request.getNome());

		_repository.save(comodidade);
		response.statusCode = 201;
		response.message = "Foi inserida com sucesso sua nova comodidade ";
		return response;

	}

	public ComodidadeResponse obter(Long id) {
		Optional<Comodidade> comodidade = _repository.findById(id);
		ComodidadeResponse response = new ComodidadeResponse();

		if (comodidade == null) {
			response.message = "Por favor procure uma comodidade existente ou insira uma nova caso ela não exista ";
			response.statusCode = 404;
			return response;
		}

		response.setNome(comodidade.get().getNome());

		response.message = "Comodidade obtida com sucesso";
		response.statusCode = 200;
		return response;
	
	}

}
