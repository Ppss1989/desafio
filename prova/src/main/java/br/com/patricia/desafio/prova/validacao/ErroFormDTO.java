package br.com.patricia.desafio.prova.validacao;

public class ErroFormDTO {

	private String campoErrado;
	private String mensagem;
	public ErroFormDTO(String campoErrado, String mensagem) {
		super();
		this.campoErrado = campoErrado;
		this.mensagem = mensagem;
	}
	public String getCampoErrado() {
		return campoErrado;
	}
	public void setCampoErrado(String campoErrado) {
		this.campoErrado = campoErrado;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
	
	
}
