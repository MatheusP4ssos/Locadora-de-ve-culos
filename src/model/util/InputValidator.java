package model.util;  // Define o pacote onde a classe de validação de entrada está localizada

import model.exception.InvalidDateException;  // Importa a exceção personalizada de data inválida
import java.time.LocalDateTime;  // Importa a classe LocalDateTime para manipulação de data e hora
import java.time.format.DateTimeFormatter;  // Importa a classe DateTimeFormatter para formatação de data
import java.time.format.DateTimeParseException;  // Importa a exceção de erro de formatação de data
import java.util.Scanner;  // Importa a classe Scanner para ler a entrada do usuário

// Classe que valida a entrada de dados, especificamente a data
public class InputValidator {

    // Define o formato de data esperado como "dd/MM/yyyy HH:mm" (data + hora)
    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    // Método estático para validar a data fornecida no formato especificado
    public static LocalDateTime validateDate(Scanner sc) {
        LocalDateTime date = null;  // Inicializa a variável date com null, pois ainda não temos uma data válida.

        // O loop continua até que uma data válida seja fornecida pelo usuário
        while (date == null) {  // Enquanto a data for null (não válida), continuará solicitando uma nova entrada
            try {
                // Lê a linha do usuário, que deve conter a data no formato especificado
                String dateStr = sc.nextLine();

                // Tenta converter a string fornecida para um objeto LocalDateTime usando o formato definido (dd/MM/yyyy HH:mm)
                date = LocalDateTime.parse(dateStr, dtf);
            } catch (DateTimeParseException e) {  // Se ocorrer um erro de formatação na data (ex: formato incorreto)
                // Exibe uma mensagem de erro para o usuário, indicando o formato correto
                System.out.println("Formato inválido! Use dd/MM/yyyy HH:mm.");
            }
        }
        // Quando a data for válida, retorna a data convertida para LocalDateTime
        return date;
    }
}
