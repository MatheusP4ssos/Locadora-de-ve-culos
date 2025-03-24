package model.exception; // Define o pacote onde a classe de exceção está localizada

// Classe de exceção personalizada para erros relacionados a datas de retorno inválidas
public class InvalidReturnDateException extends RuntimeException {

    // Construtor que recebe uma mensagem de erro e repassa para a superclasse RuntimeException
    public InvalidReturnDateException(String message) {
        super(message);
    }
}
