package br.hoteleveris.app.response;

public class TipoQuartoResponse extends BaseResponse {

	private Long id;
	private String descricao;
	private Double valor;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public static void add(TipoQuartoResponse tipoQuartoResponseList) {

	}

	public static void add(QuartoResponse quartoResponseList) {
		
	}

}
