package br.hoteleveris.app.service.implement;

import java.util.List;

import br.hoteleveris.app.response.BaseResponse;
import br.hoteleveris.app.response.QuartoResponse;

public class ListQuartoImp extends BaseResponse {

	private List<QuartoResponse> quartos;

	public List<QuartoResponse> getQuartos() {
		return quartos;
	}

	public void setQuartos(List<QuartoResponse> quartos) {
		this.quartos = quartos;
	}

}
