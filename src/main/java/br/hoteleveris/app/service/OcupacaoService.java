package br.hoteleveris.app.service;

import br.hoteleveris.app.request.OcupacaoRequest;
import br.hoteleveris.app.response.BaseResponse;

public interface OcupacaoService {

	BaseResponse inserir(OcupacaoRequest ocupacaoRequest);

	BaseResponse listar();

}
