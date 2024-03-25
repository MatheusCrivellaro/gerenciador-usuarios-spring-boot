package br.com.matheus.gerenciador.vo.v1;

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
public class UsuarioVO {

    private Long id;
    private String email;
    private String senha;
    private String nome;
    private String username;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataNascimento;

}
