package br.hoteleveris.app.service;

import br.hoteleveris.app.request.QuartoRequest;
import br.hoteleveris.app.response.BaseResponse;
import br.hoteleveris.app.response.QuartoResponse;
import br.hoteleveris.app.service.imp.ListQuartoImp;

public interface QuartoService {

	BaseResponse inserir(QuartoRequest quartoRequest);

	QuartoResponse obter(Long id);

	ListQuartoImp listar(Long id);

}
