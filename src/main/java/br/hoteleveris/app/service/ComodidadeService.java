package br.hoteleveris.app.service;

import br.hoteleveris.app.request.ComodidadeRequest;
import br.hoteleveris.app.response.BaseResponse;

public interface ComodidadeService {
	BaseResponse inserir(ComodidadeRequest request);

	BaseResponse obter(Long id);

}
