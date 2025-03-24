package model.service;  // Define o pacote onde a interface TaxService está localizada

// Interface que define um contrato para serviços de cálculo de impostos
public interface TaxService {

    // Método que recebe um valor de quantidade (amount) e retorna o valor do imposto calculado
    // O valor de retorno é do tipo double, que representa o valor do imposto
    double tax(double amount);
}
