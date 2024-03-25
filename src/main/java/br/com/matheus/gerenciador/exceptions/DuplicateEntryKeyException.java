package br.com.matheus.gerenciador.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class DuplicateEntryKeyException extends RuntimeException{

    public DuplicateEntryKeyException(String ex) {
        super(ex);
    }

}
