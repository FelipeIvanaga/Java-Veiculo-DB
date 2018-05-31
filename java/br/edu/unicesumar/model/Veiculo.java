package br.edu.unicesumar.model;

/**
 * Autor: Felipe Alves Ivanaga github.com/felipeivanaga
 */
public class Veiculo {

    protected String chassi;
    protected String placa;
    protected String modelo;
    protected int ano;

    public Veiculo(String chassi, String placa, String modelo, int ano) {
        super();
        this.chassi = chassi;
        this.placa = placa;
        this.modelo = modelo;
        this.ano = ano;
    }

    public String getChassi() {
        return chassi;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

}