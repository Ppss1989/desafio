package br.com.patricia.desafio.prova.controller.form;

import java.time.LocalDateTime;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import br.com.patricia.desafio.prova.modelo.Cargo;
import br.com.patricia.desafio.prova.modelo.Perfil;
import br.com.patricia.desafio.prova.modelo.Usuario;
import br.com.patricia.desafio.prova.repository.CargoRepository;
import br.com.patricia.desafio.prova.repository.PerfilRepository;

public class UsuarioForm {
	@NotNull@Length(min=5,max=8)
	private String nome_user;
	@NotNull@Email
	private String email;
	@NotNull@NotBlank
	private String cargoNome;
	@NotNull@NotBlank
	private String perfilNome;
	@NotNull@NotBlank
	private String status;
	@NotNull@org.hibernate.validator.constraints.br.CPF
	private String CPF;
	private String genero; 
	@NotBlank@DateTimeFormat
	private LocalDateTime dataNascimento;
	@NotNull
	private String nomePessoa;
	
	public String getNome_user() {
		return nome_user;
	}
	public void setNome_user(String nome_user) {
		this.nome_user = nome_user;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getCargoNome() {
		return cargoNome;
	}
	public void setCargoNome(String cargoNome) {
		this.cargoNome = cargoNome;
	}
	public String getPerfilNome() {
		return perfilNome;
	}
	public void setPerfilNome(String perfilNome) {
		this.perfilNome = perfilNome;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCPF() {
		return CPF;
	}
	public void setCPF(String CPF) {
		this.CPF = CPF;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public LocalDateTime getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(LocalDateTime dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getNomePessoa() {
		return nomePessoa;
	}
	public void setNomePessoa(String nomePessoa) {
		this.nomePessoa = nomePessoa;
	}
	
	public Usuario converter(CargoRepository cargorepository , PerfilRepository perfilrepository ) {
		Cargo cargo = cargorepository.findByNome(cargoNome);
		List<Perfil> perfil = perfilrepository.findAll();
		return new Usuario(nome_user, email, cargo, perfil, CPF, dataNascimento, nomePessoa);
	}

}
