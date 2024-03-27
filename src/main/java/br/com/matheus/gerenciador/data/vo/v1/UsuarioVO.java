package br.com.matheus.gerenciador.data.vo.v1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.github.dozermapper.core.Mapping;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@JsonPropertyOrder({"id", "email", "senha", "nome", "usuario", "dataNascimento"})
public class UsuarioVO extends RepresentationModel<UsuarioVO> implements Serializable {

    private static final long serialVersionUID = 1L;

    @Mapping("id")
    private Long key;
    private String email;
    private String senha;
    private String nome;

    @JsonProperty("usuario")
    private String username;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataNascimento;
    public UsuarioVO(Long key, String email, String senha, String nome, String username, LocalDate dataNascimento) {
        this.key = key;
        this.email = email;
        this.senha = senha;
        this.nome = nome;
        this.username = username;
        this.dataNascimento = dataNascimento;
    }

    public UsuarioVO() {
    }

    public Long getKey() {
        return key;
    }

    public void setKey(Long key) {
        this.key = key;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        UsuarioVO usuarioVO = (UsuarioVO) o;
        return Objects.equals(key, usuarioVO.key) && Objects.equals(email, usuarioVO.email) && Objects.equals(senha, usuarioVO.senha) && Objects.equals(nome, usuarioVO.nome) && Objects.equals(username, usuarioVO.username) && Objects.equals(dataNascimento, usuarioVO.dataNascimento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), key, email, senha, nome, username, dataNascimento);
    }
}
