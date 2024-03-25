package br.com.matheus.gerenciador.model;

import br.com.matheus.gerenciadorusuariosrestspringboot.data.vo.v1.UsuarioVO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity(name = "usuario")
@Table(name = "Usuarios")
public class Usuario {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String senha;
    private String nome;
    private String username;

    @Column(name = "data_nascimento")
    @Temporal(TemporalType.DATE)
    private LocalDate dataNascimento;

    public Usuario(String email, String senha, String nome, String username, LocalDate dataNascimento) {
        this.email = email;
        this.senha = senha;
        this.nome = nome;
        this.username = username;
        this.dataNascimento = dataNascimento;
    }

    public Usuario(UsuarioVO dados) {
        this(dados.getEmail(), dados.getSenha(), dados.getNome(), dados.getUsername(), dados.getDataNascimento());
    }

    public Usuario update(UsuarioVO dados) {
        if(dados.getEmail()!=null)
            this.setEmail(dados.getEmail());
        if(dados.getSenha()!=null)
            this.setSenha(dados.getSenha());
        if(dados.getNome()!=null)
            this.setNome(dados.getNome());
        if(dados.getUsername()!=null)
            this.setUsername(dados.getUsername());
        if(dados.getDataNascimento()!=null)
            this.setDataNascimento(getDataNascimento());
        return this;
    }
}
