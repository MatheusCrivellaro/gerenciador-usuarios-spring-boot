package br.com.matheus.gerenciador.controller;

import br.com.matheus.gerenciador.data.vo.v1.UsuarioVO;
import br.com.matheus.gerenciador.repository.UsuarioRepository;
import br.com.matheus.gerenciador.repository.UsuarioRepositorySimulator;
import br.com.matheus.gerenciador.service.UsuariosService;
import static br.com.matheus.gerenciador.util.MediaType.*;

import br.com.matheus.gerenciador.service.UsuariosServiceSimulator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuariosService service;

	@GetMapping(produces = {JSON, XML})
	public List<UsuarioVO> findAll() {
		return service.findAll();
	}
	
	@GetMapping(value = "/{id}", produces = {JSON, XML})
	public UsuarioVO findById(@PathVariable Long id) {
		return service.findById(id);
	}

	@GetMapping(value = "byEmail/{email}", produces = {JSON, XML})
	public UsuarioVO findByEmail(@PathVariable String email) {
		return service.findByEmail(email);
	}

	@GetMapping(value = "allByNome/{nome}", produces = {JSON, XML})
	public List<UsuarioVO> findAllByNome(@PathVariable String nome) {
		return service.findAllByNome(nome);
	}

	@GetMapping(value = "allByUsername/{username}", produces = {JSON, XML})
	public UsuarioVO findByUsername(@PathVariable String username) {
		return service.findByUsername(username);
	}
	
	@PostMapping(produces = {JSON, XML}, consumes = {JSON, XML})
	public UsuarioVO create(@RequestBody UsuarioVO dados) {
		return service.create(dados);
	}
	
	@PutMapping(produces = {JSON, XML}, consumes = {JSON, XML})
	public UsuarioVO update(@RequestBody UsuarioVO dados) {
		return service.update(dados);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		service.deleteById(id);
	}
}