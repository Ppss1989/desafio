package br.com.patricia.desafio.prova.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.patricia.desafio.prova.modelo.Cargo;

public interface CargoRepository extends JpaRepository<Cargo, Long> { 
	Cargo findByNome(String nome);


}
