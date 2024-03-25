package br.com.matheus.gerenciadorusuariosrestspringboot.mapper.mocks;

import br.com.matheus.gerenciadorusuariosrestspringboot.data.vo.v1.UsuarioVO;
import br.com.matheus.gerenciadorusuariosrestspringboot.domain.model.Usuario;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UsuarioMock {

    public Usuario mockEntity() {
        return mockEntity(0);
    }

    public UsuarioVO mockVO() {
        return mockVO(0);
    }

    public List<Usuario> mockEntityList() {
        List<Usuario> usuarios = new ArrayList<Usuario>();
        for (int i = 0; i < 15; i++) {
            usuarios.add(mockEntity(i));
        }
        return usuarios;
    }

    public List<UsuarioVO> mockVOList() {
        List<UsuarioVO> Usuarios = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            Usuarios.add(mockVO(i));
        }
        return Usuarios;
    }

    public Usuario mockEntity(Integer number) {
        Usuario usuario = new Usuario();
        usuario.setNome("Nome Test " + number);
        usuario.setUsername("Username Test " + number);
        usuario.setDataNascimento(LocalDate.of(2000, 1, 1));
        usuario.setEmail("Email Test " + number);
        usuario.setSenha("Senha Test " + number);
        usuario.setId(number.longValue());
        return usuario;
    }

    public UsuarioVO mockVO(Integer number) {
        return new UsuarioVO(
                number.longValue(),
                "Email Test " + number,
                "Senha Test " + number,
                "Nome Test " + number,
                "Username Test " + number,
                LocalDate.of(2000, 1, 1));
    }

}
