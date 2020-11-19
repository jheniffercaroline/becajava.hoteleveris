package br.hoteleveris.app.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.hoteleveris.app.model.Ocupacao;
import br.hoteleveris.app.repository.OcupacaoRepository;
import br.hoteleveris.app.request.TransferenciaRequest;
import br.hoteleveris.app.response.BaseResponse;
import br.hoteleveris.app.service.FaturaService;

@Service
public class FaturaServiceImp implements FaturaService {
	@Autowired
	private OcupacaoRepository ocupacaoRepository;

	private String hashContaHotel = "123456";

	public BaseResponse transferencia() {
		BaseResponse response = new BaseResponse();

		RestTemplate restTemplate = new RestTemplate();
		String uri = "http://localhost:8081/operacoes/transferencia";
		List<Ocupacao> lista = ocupacaoRepository.findBySituacao("N");

		for (Ocupacao ocupacao : lista) {
			double valor = ocupacao.getQuarto().getTipoQuarto().getValor() * ocupacao.getQtdDiarias();

			TransferenciaRequest transferencia = new TransferenciaRequest();
			transferencia.setHashDestino(hashContaHotel);
			transferencia.setHashOrigem(ocupacao.getCliente().getHash());
			transferencia.setValor(valor);

			restTemplate.postForObject(uri, transferencia, BaseResponse.class);

			ocupacao.setSituacao("P");
			ocupacaoRepository.save(ocupacao);
		}
		response.statusCode = 200;
		response.setMessage("Transação realizada com sucesso");
		return response;

	}

}
