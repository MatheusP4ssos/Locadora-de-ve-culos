package model.exception; // Define o pacote onde a classe de exceção está localizada

// A classe InvalidDateException estende RuntimeException, representando uma exceção personalizada
public class InvalidDateException extends RuntimeException{

    // Construtor da exceção que recebe uma mensagem de erro
    public InvalidDateException(String message){
        super(message); // Chama o construtor da classe pai (RuntimeException) passando a mensagem de erro
    }
}
