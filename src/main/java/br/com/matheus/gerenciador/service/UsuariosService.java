package br.com.matheus.gerenciador.service;

import br.com.matheus.gerenciador.controller.UsuarioController;
import br.com.matheus.gerenciador.data.vo.v1.UsuarioVO;
import br.com.matheus.gerenciador.domain.model.Usuario;
import br.com.matheus.gerenciador.exceptions.UsuarioByIdNotFoundException;
import br.com.matheus.gerenciador.mapper.Mapeador;
import br.com.matheus.gerenciador.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

@Service
public class UsuariosService {

    @Autowired
    private UsuarioRepository repository;

    public List<UsuarioVO> findAll() {
        return Mapeador.parseListObjects(repository.findAll(), UsuarioVO.class);
    }

    public UsuarioVO findById(Long id) {
        return Mapeador.parseObject(repository.findById(id).orElseThrow(() -> new UsuarioByIdNotFoundException("Usuario não encontrado com esse ID")), UsuarioVO.class).add(linkTo(methodOn(UsuarioController.class).findById(id)).withSelfRel());
    }

    public UsuarioVO findByEmail(String email) {
        return Mapeador.parseObject(repository.findByEmail(email), UsuarioVO.class);
    }

    public List<UsuarioVO> findAllByNome(String nome) {
        return findAll().stream().filter(vo -> vo.getNome().toLowerCase().contains(nome)).toList();
    }

    public UsuarioVO findByUsername(String username) {
        return Mapeador.parseObject(repository.findByUsername(username), UsuarioVO.class);
    }

    public UsuarioVO update(UsuarioVO vo) {
        return Mapeador.parseObject(repository.findById(vo.getKey()).orElseThrow(() -> new UsuarioByIdNotFoundException("Usuario não encontrado com esse ID")).update(vo), UsuarioVO.class);
    }

    public UsuarioVO create(UsuarioVO vo) {
        return Mapeador.parseObject(repository.save(Mapeador.parseObject(vo, Usuario.class)), UsuarioVO.class);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
