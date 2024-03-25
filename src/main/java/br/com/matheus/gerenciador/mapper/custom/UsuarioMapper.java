package br.com.matheus.gerenciadorusuariosrestspringboot.mapper.custom;

import br.com.matheus.gerenciadorusuariosrestspringboot.data.vo.v2.UsuarioVOV2;
import br.com.matheus.gerenciadorusuariosrestspringboot.domain.model.Usuario;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class UsuarioMapper {

    public UsuarioVOV2 convertEntityToVo(Usuario usuario){
        UsuarioVOV2 vo = new UsuarioVOV2();
        vo.setId(usuario.getId());
        vo.setNome(usuario.getNome());
        vo.setSenha(usuario.getSenha());
        vo.setEmail(usuario.getEmail());
        vo.setUsername(usuario.getUsername());
        vo.setDataNascimento(usuario.getDataNascimento());
        vo.setNumero("99999999999");
        return vo;
    }
    public Usuario convertVoToEntity(UsuarioVOV2 usuario){
        Usuario entity = new Usuario();
        entity.setId(usuario.getId());
        entity.setNome(usuario.getNome());
        entity.setSenha(usuario.getSenha());
        entity.setEmail(usuario.getEmail());
        entity.setUsername(usuario.getUsername());
        entity.setDataNascimento(usuario.getDataNascimento());
        return entity;
    }

}
