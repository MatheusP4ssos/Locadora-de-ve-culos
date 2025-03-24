package model.service;  // Define o pacote onde a classe de serviço de impostos está localizada

// Classe responsável por calcular o imposto de acordo com as regras do Brasil
// A classe implementa a interface TaxService, que define o contrato para cálculo de impostos
public class BrazilTaxService implements TaxService {

    // Método que calcula o imposto com base no valor do pagamento
    // Recebe um valor 'amount' e retorna o valor do imposto a ser pago
    public double tax(double amount) {
        // Se o valor for menor ou igual a 100, aplica uma taxa de 20%
        if (amount <= 100.0) {
            return amount * 0.2;  // Retorna 20% do valor
        }
        // Se o valor for maior que 100, aplica uma taxa reduzida de 15%
        else {
            return amount * 0.15;  // Retorna 15% do valor
        }
    }
}