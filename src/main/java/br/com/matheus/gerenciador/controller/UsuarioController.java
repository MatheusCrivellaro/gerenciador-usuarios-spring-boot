package br.com.matheus.gerenciadorusuariosrestspringboot.controller;

import java.util.List;

import br.com.matheus.gerenciadorusuariosrestspringboot.data.vo.v1.UsuarioVO;
import br.com.matheus.gerenciadorusuariosrestspringboot.data.vo.v2.UsuarioVOV2;
import br.com.matheus.gerenciadorusuariosrestspringboot.domain.model.Usuario;
import br.com.matheus.gerenciadorusuariosrestspringboot.mapper.Mapeador;
import br.com.matheus.gerenciadorusuariosrestspringboot.mapper.custom.UsuarioMapper;
import br.com.matheus.gerenciadorusuariosrestspringboot.repository.UsuarioRepository;
import br.com.matheus.gerenciadorusuariosrestspringboot.repository.UsuarioRepositorySimulator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository repository;

	@Autowired
	private UsuarioMapper mapeadorUsuario;

	@GetMapping
	public List<UsuarioVO> findAll() {
		return Mapeador.parseListObjects(repository.findAll(), UsuarioVO.class);
	}
	
	@GetMapping("/{id}")
	public UsuarioVO findById(@PathVariable Long id) {
		return Mapeador.parseObject(repository.findById(id), UsuarioVO.class);
	}

	@GetMapping("byEmail/{email}")
	public UsuarioVO findByEmail(@PathVariable String email) {
		return Mapeador.parseObject(repository.findByEmail(email), UsuarioVO.class);
	}

	@GetMapping("allByNome/{nome}")
	public List<UsuarioVO> findAllByNome(@PathVariable String nome) {
		return Mapeador.parseListObjects(repository.findAllByNome(nome), UsuarioVO.class);
	}

	@GetMapping("allByUsername/{username}")
	public List<UsuarioVO> findByUsername(@PathVariable String username) {
		return Mapeador.parseListObjects(repository.findAllByUsername(username), UsuarioVO.class);
	}
	
	@PostMapping
	public UsuarioVO create(@RequestBody UsuarioVO dados) {
		var entidadeUsuario = repository.save(Mapeador.parseObject(dados, Usuario.class));
		return Mapeador.parseObject(entidadeUsuario, UsuarioVO.class);
	}
	@PostMapping("/v2")
	public UsuarioVOV2 createV2(@RequestBody UsuarioVOV2 dados) {
		var entidadeUsuario = repository.save(mapeadorUsuario.convertVoToEntity(dados));
		return mapeadorUsuario.convertEntityToVo(entidadeUsuario);
	}
	
	@PutMapping
	public UsuarioVO update(@RequestBody UsuarioVO dados) {
		return Mapeador.parseObject(repository.findById(dados.getId()).get().update(dados), UsuarioVO.class);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		repository.deleteById(id);
	}
}