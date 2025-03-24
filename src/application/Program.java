package application; // Define o pacote do programa principal

import java.time.LocalDateTime;  // Importa a classe LocalDateTime para manipulação de data e hora
import java.time.format.DateTimeFormatter;  // Importa a classe DateTimeFormatter para formatação de data
import java.time.format.DateTimeParseException;  // Importa a exceção para erro na formatação de data
import java.util.Locale;  // Importa a classe Locale para definir o padrão de localidade
import java.util.Scanner;  // Importa a classe Scanner para leitura de dados do teclado

import model.exception.InvalidReturnDateException;  // Importa a exceção personalizada InvalidReturnDateException
import model.exception.InvalidDateException;  // Importa a exceção personalizada InvalidDateException
import model.service.BrazilTaxService;  // Importa a classe de serviço de impostos do Brasil
import model.entities.CarRental;  // Importa a classe CarRental, que representa um aluguel de carro
import model.entities.Vehicle;  // Importa a classe Vehicle, que representa um veículo
import model.service.RentalService;  // Importa a classe RentalService, que processa o aluguel

public class Program {
    public static void main(String[] args) {

        // Define o local como EUA para formatação de números (por exemplo, separadores decimais)
        Locale.setDefault(Locale.US);

        // Cria o objeto Scanner para ler a entrada do usuário
        Scanner sc = new Scanner(System.in);

        // Cria um DateTimeFormatter para definir o formato de data e hora esperado
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        // Bloco try-catch para capturar exceções durante a execução do programa
        try {
            // Solicita que o usuário insira os dados do aluguel de carro
            System.out.println("Entre com os dados do aluguem: ");

            System.out.print("Modelo do carro: ");
            String carModel = sc.nextLine();  // Lê o modelo do carro

            System.out.println("Retirada (dd/MM/yyyy hh:mm): ");
            // Lê e converte a data/hora de retirada usando o DateTimeFormatter
            LocalDateTime start = LocalDateTime.parse(sc.nextLine(), dtf);

            System.out.println("Retorno (dd/MM/yyyy hh:mm): ");
            // Lê e converte a data/hora de retorno usando o DateTimeFormatter
            LocalDateTime finish = LocalDateTime.parse(sc.nextLine(), dtf);

            // Validação: Se a data de entrega (finish) for anterior à data de retirada (start), lança exceção
            if (finish.isBefore(start)) {
                throw new InvalidReturnDateException("Erro: A data de entrega não pode ser anterior à data de retirada.");
            }

            // Cria um objeto CarRental com as datas e o modelo do carro
            CarRental cr = new CarRental(start, finish, new Vehicle(carModel));

            // Cria uma instância de BrazilTaxService para cálculo de impostos
            BrazilTaxService taxService = new BrazilTaxService();

            // Solicita o preço por hora e por dia
            System.out.println("Entre com o preço por hora");
            double pricePerHour = sc.nextDouble();

            System.out.println("Entre com o preço por dia");
            double pricePerDay = sc.nextDouble();

            // Cria uma instância de RentalService para processar a fatura
            RentalService rentalService = new RentalService(pricePerHour, pricePerDay, new BrazilTaxService());

            // Processa a fatura do aluguel de carro
            rentalService.processInvoice(cr);

            // Exibe a fatura na tela
            System.out.println("FATURA:");
            System.out.println("PAGAMENTO BÁSICO: " + cr.getInvoice().getBasicPayment());
            System.out.println("IMPOSTO " + cr.getInvoice().getTax());
            System.out.println("PAGAMENTO TOTAL " + cr.getInvoice().getTotalPayment());

            // Captura exceção personalizada se a data estiver em formato inválido
        } catch (InvalidDateException e) {
            System.out.println(e.getMessage());  // Exibe a mensagem de erro da exceção personalizada

            // Captura exceção personalizada para formatação inválida de data
        } catch (InvalidReturnDateException e) {
            System.out.println(e.getMessage());  // Exibe a mensagem de erro da exceção personalizada

            // Captura qualquer outra exceção inesperada
        } catch (Exception e) {
            System.out.println("Erro inesperado: " + e.getMessage());  // Exibe mensagem de erro genérica

            // Bloco finally que sempre será executado, fecha o scanner
        } finally {
            sc.close();  // Fecha o scanner após a execução do programa
        }
    }
}
