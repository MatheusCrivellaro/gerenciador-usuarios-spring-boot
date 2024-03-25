package br.com.matheus.gerenciador.service;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class UsuarioService {

    //String dd-MM-yyyy -> LocalDate
    public static LocalDate dataFormatter(String data) {
        var formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return LocalDate.parse(data, formatter);
    }

}
