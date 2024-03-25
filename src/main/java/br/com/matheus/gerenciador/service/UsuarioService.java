package br.com.matheus.gerenciadorusuariosrestspringboot.service;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.logging.Formatter;

@Service
public class UsuarioService {

    //String dd-MM-yyyy -> LocalDate
    public static LocalDate dataFormatter(String data) {
        var formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return LocalDate.parse(data, formatter);
    }

}
