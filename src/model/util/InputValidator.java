package model.util;  // Define o pacote onde a classe de validação de entrada está localizada

import model.exception.InvalidDateException;  // Importa a exceção personalizada de data inválida

import java.time.LocalDateTime;  // Importa a classe LocalDateTime para manipulação de data e hora
import java.time.format.DateTimeFormatter;  // Importa a classe DateTimeFormatter para formatação de data
import java.time.format.DateTimeParseException;  // Importa a exceção de erro de formatação de data

// Classe que valida a entrada de dados, especificamente a data
public class InputValidator {

    // Define o formato de data esperado como "dd/MM/yyyy"
    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    // Método estático para validar a data fornecida no formato especificado
    public static LocalDateTime validateDate(String dateStr) {
        try {
            // Tenta converter a string para LocalDateTime com o formato especificado
            return LocalDateTime.parse(dateStr, dtf);
        } catch (DateTimeParseException e) {
            // Se ocorrer erro de formatação, lança uma exceção personalizada
            throw new InvalidDateException("Erro: Formato inválido! Use dd/MM/yyyy HH:mm.");
        }
    }
}
