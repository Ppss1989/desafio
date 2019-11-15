package br.com.patricia.desafio.prova.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.patricia.desafio.prova.modelo.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	Page<Usuario> findByNomePessoa(String nome,Pageable paginacao);
	Page<Usuario> findByCargoNome(String nome,Pageable paginacao);
	Page<Usuario> findByPerfilNome(String nome,Pageable paginacao);
	Optional<Usuario> findByEmail(String email);





}
