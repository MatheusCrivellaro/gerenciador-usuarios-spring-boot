package br.com.matheus.gerenciador.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UsuarioByIdNotFoundException extends RuntimeException{

    public UsuarioByIdNotFoundException(String ex) {
        super(ex);
    }

}
