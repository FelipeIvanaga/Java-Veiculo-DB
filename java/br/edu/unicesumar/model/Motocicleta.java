package br.edu.unicesumar.model;

/**
 * Autor: Felipe Alves Ivanaga github.com/felipeivanaga
 */
public class Motocicleta extends Veiculo {

    private int cilindrada;

    public Motocicleta(String chassi, String placa, String modelo, int ano, int cilindrada) {
        super(chassi, placa, modelo, ano);
        this.cilindrada = cilindrada;
    }

    public int getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }
}