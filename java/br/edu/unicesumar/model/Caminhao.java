package br.edu.unicesumar.model;

/**
 * Autor: Felipe Alves Ivanaga github.com/felipeivanaga
 */
public class Caminhao extends Veiculo {

    private int peso;
    private String tipo;

    public Caminhao(String chassi, String placa, String modelo, int ano, int peso, String tipo) {
        super(chassi, placa, modelo, ano);
        this.peso = peso;
        this.tipo = tipo;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}