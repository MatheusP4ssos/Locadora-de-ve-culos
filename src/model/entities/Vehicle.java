package model.entities; // Define o pacote onde a classe está localizada

public class Vehicle {

    private String model; // Armazena o modelo do veículo

    // Construtor padrão (sem parâmetros)
    public Vehicle() {
    }

    // Construtor que inicializa o veículo com um modelo específico
    public Vehicle(String model) {
        this.model = model; // Atribui o valor passado ao atributo model
    }

    // Método getter para obter o modelo do veículo
    public String getModel() {
        return model; // Retorna o valor armazenado em model
    }

    // Método setter para definir o modelo do veículo
    public void setModel(String model) {
        this.model = model; // Atualiza o valor de model com o valor passado
    }
}
