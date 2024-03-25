package br.com.matheus.gerenciadorusuariosrestspringboot.repository;

import br.com.matheus.gerenciadorusuariosrestspringboot.data.vo.v1.UsuarioVO;
import br.com.matheus.gerenciadorusuariosrestspringboot.domain.model.Usuario;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
//Simula um repositorio de banco de dados
public class UsuarioRepositorySimulator {

    private List<Usuario> lista;
    private Long id;

    public UsuarioRepositorySimulator() {
        this.lista = new ArrayList<>();
        this.id = 0L;
    }

    //Retorna todos os dados da base
    public List<Usuario> findAll() {
        return lista;
    }

    //Retorna um unico usuario pelo ID (IDs não se repetem na base)
    public Usuario findById(Long id) {
        return lista.stream().filter(usuario -> usuario.getId().equals(id)).findFirst().get();
    }

    //Salva Usuarios na base, acrescendo 1 no ID da base, para simular um banco de dados
    public Usuario save(Usuario usuario) {
        usuario.setId(id++);
        lista.add(usuario);
        return usuario;
    }

    //Deleta Usuarios pelo objeto
    public void delete(Usuario usuario) {
        lista.remove(usuario);
    }

    //Deleta usuarios pelo ID
    public void deleteById(Long id) {
        lista.remove(findById(id));
    }

    //Atualiza dados do Usuario, atravez de um VO
    public Usuario update(UsuarioVO dados) {
        return findById(dados.getId()).update(dados);
    }

    //Busca Usuarios por Email
    public Usuario findByEmail(String email) {
        //Retorna um usuario com o email exato buscado (Não existe emails duplicados no banco)
        return lista.stream().filter(usuario -> usuario.getEmail().equals(email)).findFirst().get();
    }

    //Busca Usuarios por Nome
    public List<Usuario> findAllByNome(String nome) {
        //retorna os usuarios nos quais os nomes possuem a String buscada, sem considerar Caixa Alta
        return lista.stream().filter(usuario -> usuario.getNome().toLowerCase().contains(nome.toLowerCase())).toList();
    }

    //Busca Usuarios por username
    public List<Usuario> findAllByUsername(String username) {
        //retorna os usuarios nos quais os usernames possuem a String buscada, sem considerar Caixa Alta
        return lista.stream().filter(usuario -> usuario.getUsername().toLowerCase().contains(username.toLowerCase())).toList();
    }
}
