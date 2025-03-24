package model.service; // Define o pacote onde a classe de serviço de impostos está localizada

// Classe responsável por calcular o imposto de acordo com as regras do Brasil
public class BrazilTaxService {

    // Método que calcula o imposto com base no valor do pagamento
    public Double tax(Double amount) {
        // Se o valor for menor ou igual a 100, aplica uma taxa de 20%
        if (amount <= 100.0) {
            return amount * 0.2;
        }
        // Se o valor for maior que 100, aplica uma taxa reduzida de 15%
        else {
            return amount * 0.15;
        }
    }
}
