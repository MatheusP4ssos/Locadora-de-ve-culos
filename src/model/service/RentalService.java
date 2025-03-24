package model.service;

import model.entities.CarRental;
import model.entities.Invoice;

import java.time.Duration;

public class RentalService {

    private double pricePerDay;  // Armazena o preço por dia do aluguel
    private double pricePerHour; // Armazena o preço por hora do aluguel

    private TaxService taxService; // Instância do serviço de imposto do Brasil

    // Construtor da classe RentalService
    public RentalService(double pricePerHour, double pricePerDay, TaxService taxService) {
        this.pricePerHour = pricePerHour;   // Inicializa o preço por hora
        this.pricePerDay = pricePerDay;  // Inicializa o preço por dia
        this.taxService = taxService;  // Inicializa o serviço de imposto
    }

    // Método que processa a fatura (invoice) para um aluguel de carro
    public void processInvoice(CarRental carRental) {
        // Calcula a duração do aluguel em minutos e converte para horas
        double minutes = Duration.between(carRental.getStart(), carRental.getEnd()).toMinutes();
        double hours = minutes / 60.0;

        double basicPayment;

        // Se o tempo for menor ou igual a 12 horas, cobra por hora arredondando para cima
        if (hours <= 12.0) {
            basicPayment = pricePerHour * Math.ceil(hours);
        }
        // Caso contrário, cobra por dia, arredondando para cima
        else {
            basicPayment = pricePerDay * Math.ceil(hours / 24);
        }

        // Calcula o imposto com base no pagamento básico
        double tax = taxService.tax(basicPayment);

        // Define a fatura do aluguel com os valores calculados
        carRental.setInvoice(new Invoice(basicPayment, tax));
    }
}
