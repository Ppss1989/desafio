package br.com.patricia.desafio.prova.modelo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


@javax.persistence.Entity
@Table(name ="usuario" )
public class Usuario implements UserDetails{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String nome_user;
	private String email;
	private String senha;
	@OneToOne
	private Cargo cargo;
	@ManyToMany(fetch = FetchType.EAGER)
	private List<Perfil> perfis = new ArrayList<>();
	@Enumerated(EnumType.STRING)
	private StatusUser status = StatusUser.Ativo;
	private String CPF;
	@Enumerated(EnumType.STRING)
	private Genero genero = Genero.Indefinido; 
	private LocalDateTime dataNascimento = LocalDateTime.now(); 
	private String nomePessoa = "";
	
	
	private static final long serialVersionUID = 1L;


	
	public Usuario() {
	}
	


	public Usuario(String nome_user, String email, Cargo cargo, List<Perfil> perfis,String CPF, LocalDateTime data, String nome) {
		super();
		this.nome_user = nome_user;
		this.email = email;
		this.cargo = cargo;
		this.perfis = perfis;
		this.CPF = CPF;
		this.dataNascimento = data;
		this.nomePessoa	= nome;	
	}




	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNomeUser() {
		return nome_user;
	}
	public void setNomeUser(String nome_user) {
		this.nome_user = nome_user;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	
	public StatusUser getStatus() {
		return status;
	}

	public void setStatus(StatusUser status) {
		this.status = status;
	}

	public String getNome_user() {
		return nome_user;
	}

	public void setNome_user(String nome_user) {
		this.nome_user = nome_user;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public String getNomePessoa() {
		return nomePessoa;
	}

	public void setNomePessoa(String nomePessoa) {
		this.nomePessoa = nomePessoa;
	}

	public LocalDateTime getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDateTime dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}



	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.perfis;
	}


	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.senha;
	}



	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.email;
	}

//metodos abaixo servem para configurar o status no sistema do usuario

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}



	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}



	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}



	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}



	public List<Perfil> getPerfis() {
		return perfis;
	}



	public void setPerfis(List<Perfil> perfis) {
		this.perfis = perfis;
	}
	
	

}
