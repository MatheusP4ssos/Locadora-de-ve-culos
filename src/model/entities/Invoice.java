package model.entities; // Define o pacote onde a classe está localizada

public class Invoice {

    private Double basicPayment; // Armazena o valor do pagamento básico
    private Double tax; // Armazena o valor do imposto

    // Construtor padrão (sem parâmetros)
    public Invoice() {
    }

    // Construtor que inicializa a fatura com os valores do pagamento básico e do imposto
    public Invoice(Double basicPayment, Double tax) {
        this.basicPayment = basicPayment; // Atribui o valor passado ao atributo basicPayment
        this.tax = tax; // Atribui o valor passado ao atributo tax
    }

    // Método getter para obter o pagamento básico
    public Double getBasicPayment() {
        return basicPayment; // Retorna o valor armazenado em basicPayment
    }

    // Método setter para definir o pagamento básico
    public void setBasicPayment(Double basicPayment) {
        this.basicPayment = basicPayment; // Atualiza o valor de basicPayment com o valor passado
    }

    // Método getter para obter o valor do imposto
    public Double getTax() {
        return tax; // Retorna o valor armazenado em tax
    }

    // Método setter para definir o imposto
    public void setTax(Double tax) {
        this.tax = tax; // Atualiza o valor de tax com o valor passado
    }

    // Método que retorna o valor total do pagamento (pagamento básico + imposto)
    public Double getTotalPayment() {
        return getBasicPayment() + getTax(); // Retorna a soma do pagamento básico com o imposto
    }
}
