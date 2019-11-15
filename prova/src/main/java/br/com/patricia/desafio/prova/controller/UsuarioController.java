package br.com.patricia.desafio.prova.controller;

import java.net.URI;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.patricia.desafio.prova.DTO.UsuarioDTO;
import br.com.patricia.desafio.prova.controller.form.UsuarioForm;
import br.com.patricia.desafio.prova.modelo.Usuario;
import br.com.patricia.desafio.prova.repository.CargoRepository;
import br.com.patricia.desafio.prova.repository.PerfilRepository;
import br.com.patricia.desafio.prova.repository.UsuarioRepository;


@RequestMapping("/user")
@RestController
public class UsuarioController {
	@Autowired
	private UsuarioRepository userInterface;
	@Autowired
	private CargoRepository cargoInterface;
	@Autowired
	private PerfilRepository perfilInterface;

	
	
	@GetMapping
	@Cacheable(value = "listaDeUsuarios")
	public Page<UsuarioDTO> listaUsuarios(@RequestParam(required = false)String nome,String CPF,String cargo,String perfil,
			@PageableDefault(sort = "CPF", direction = Direction.DESC, page = 0, size = 10) Pageable paginacao) {
		
		if(nome ==null) {
			Page <Usuario> listaUser = userInterface.findAll(paginacao);
			return UsuarioDTO.converter(listaUser);
		}else {
			Page <Usuario> listaUser = userInterface.findByNomePessoa(nome,paginacao);
			return UsuarioDTO.converter(listaUser);//aqui implementaria os critérios de busca solicitados e dividiria em metodos
			//conforme atributo a ser usado na busca

		}
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<UsuarioDTO> cadastrarUser(@RequestBody @Valid UsuarioForm userForm, UriComponentsBuilder component) {
		Usuario user = userForm.converter(cargoInterface,perfilInterface);
		userInterface.save(user);	
		URI uri = component.path("/usuarios/{id}").buildAndExpand(user.getId()).toUri();
		return  ResponseEntity.created(uri).body(new UsuarioDTO(user));
	}
	
	
	
	  @DeleteMapping("/{id}")  
	  @Transactional
	  @CacheEvict(value = "listaDeUsuarios", allEntries = true)//limpando cache ao realizar exclusão
	  public ResponseEntity<?> remover(@PathVariable Long id) { 
		  Optional<Usuario> optional = userInterface.findById(id); 
		  if (optional.isPresent()) {
			  userInterface.deleteById(id); 
			  return ResponseEntity.ok().build();
		}
	  
	  return ResponseEntity.notFound().build(); }//Tramento do erro 404,simplificando a vida com JSON
	 

}
