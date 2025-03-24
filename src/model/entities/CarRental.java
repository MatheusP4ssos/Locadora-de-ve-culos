package model.entities; // Define o pacote onde a classe CarRental está localizada

import java.time.LocalDateTime; // Importa a classe LocalDateTime para manipulação de data e hora

// Classe que representa um aluguel de carro
public class CarRental {

    private LocalDateTime start; // Data e hora de início do aluguel
    private LocalDateTime end;   // Data e hora de término do aluguel

    private Vehicle vehicle; // Objeto que representa o veículo alugado
    private Invoice invoice; // Objeto que representa a fatura do aluguel

    // Construtor padrão (sem parâmetros)
    public CarRental() {
    }

    // Construtor que inicializa os atributos com valores fornecidos
    public CarRental(LocalDateTime start, LocalDateTime end, Vehicle vehicle) {
        this.start = start;   // Define a data e hora de início do aluguel
        this.end = end;       // Define a data e hora de término do aluguel
        this.vehicle = vehicle; // Define o veículo alugado
    }

    // Retorna a data e hora de início do aluguel
    public LocalDateTime getStart() {
        return start;
    }

    // Define a data e hora de início do aluguel
    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    // Retorna a data e hora de término do aluguel
    public LocalDateTime getEnd() {
        return end;
    }

    // Define a data e hora de término do aluguel
    public void setEnd(LocalDateTime end) {
        this.end = end;
    }

    // Retorna o veículo alugado
    public Vehicle getVehicle() {
        return vehicle;
    }

    // Define o veículo alugado
    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    // Retorna a fatura do aluguel
    public Invoice getInvoice() {
        return invoice;
    }

    // Define a fatura do aluguel
    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }
}
