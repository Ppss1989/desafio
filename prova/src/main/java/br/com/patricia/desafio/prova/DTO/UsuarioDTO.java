package br.com.patricia.desafio.prova.DTO;

import java.time.LocalDateTime;

import org.springframework.data.domain.Page;

import br.com.patricia.desafio.prova.modelo.StatusUser;
import br.com.patricia.desafio.prova.modelo.Usuario;

public class UsuarioDTO {

	private Long id;
	private String nome_user;
	private StatusUser status = StatusUser.Ativo;
	private String CPF=null;
	private LocalDateTime dataNascimento = LocalDateTime.now(); 
	private String nomePessoa;
	
	
	public UsuarioDTO(Usuario user) {
		super();
		this.nome_user = user.getNome_user();
		this.status = user.getStatus();
		this.CPF = user.getCPF();
		this.dataNascimento = user.getDataNascimento();
		this.nomePessoa = user.getNomePessoa();
	}


	public Long getId() {
		return id;
	}


	public String getNome_user() {
		return nome_user;
	}

	
	public StatusUser getStatus() {
		return status;
	}


	public String getCPF() {
		return CPF;
	}

	public LocalDateTime getDataNascimento() {
		return dataNascimento;
	}


	public String getNomePessoa() {
		return nomePessoa;
	}
	
	
	
	public static Page<UsuarioDTO> converter(Page<Usuario> users) {
		return users.map(UsuarioDTO::new);

	}	
	
	
}
