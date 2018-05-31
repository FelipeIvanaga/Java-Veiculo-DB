package br.edu.unicesumar.model;

/**
 * Autor: Felipe Alves Ivanaga github.com/felipeivanaga
 */
public class Automovel extends Veiculo {

    private int portas;
    private int cavalos;

    public Automovel(String chassi, String placa, String modelo, int ano, int portas, int cavalos) {
        super(chassi, placa, modelo, ano);
        this.portas = portas;
        this.cavalos = cavalos;
    }

    public int getPortas() {
        return portas;
    }

    public void setPortas(int portas) {
        this.portas = portas;
    }

    public int getCavalos() {
        return cavalos;
    }

    public void setCavalos(int cavalos) {
        this.cavalos = cavalos;
    }
}