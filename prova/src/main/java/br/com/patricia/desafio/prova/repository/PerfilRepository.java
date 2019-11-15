package br.com.patricia.desafio.prova.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.patricia.desafio.prova.modelo.Perfil;

public interface PerfilRepository extends JpaRepository<Perfil, Long>{

	Perfil findByNome(String nome);

}
