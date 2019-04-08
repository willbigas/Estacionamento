package br.com.estacionamento.model;

/**
 *
 * @author William
 */
public class Carro {

    private Integer id;
    private String placa;
    private String cor;
    private String modelo;
    private String marca;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    @Override
    public String toString() {
        return "Carro{" + "placa=" + placa + ", cor=" + cor + ", modelo=" + modelo + ", marca=" + marca + '}';
    }

}
