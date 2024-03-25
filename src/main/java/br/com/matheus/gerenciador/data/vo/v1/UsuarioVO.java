package br.com.matheus.gerenciador.data.vo.v1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@JsonPropertyOrder({"id", "email", "senha", "nome", "usuario", "dataNascimento"})
public class UsuarioVO {

    private Long id;
    private String email;
    private String senha;
    private String nome;

    @JsonProperty("usuario")
    private String username;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataNascimento;

}
