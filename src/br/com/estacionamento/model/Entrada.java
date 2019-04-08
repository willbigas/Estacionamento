package br.com.estacionamento.model;

import java.util.Date;

/**
 *
 * @author William
 */
public class Entrada {

    private Integer id;
    private Carro carro;
    private Condutor condutor;
    private TipoCliente tipoCliente;
    private Date dataEntrada;
    private Date dataSaida;
    private Double valorTotal;
    private Entrada ultimaEntrada;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Condutor getCondutor() {
        return condutor;
    }

    public void setCondutor(Condutor condutor) {
        this.condutor = condutor;
    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }

    public TipoCliente getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(TipoCliente tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public Date getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public Date getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(Date dataSaida) {
        this.dataSaida = dataSaida;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Entrada getUltimaEntrada() {
        return ultimaEntrada;
    }

    public void setUltimaEntrada(Entrada ultimaEntrada) {
        this.ultimaEntrada = ultimaEntrada;
    }

    @Override
    public String toString() {
        return "Entrada{" + "id=" + id + ", carro=" + carro + ", condutor=" + condutor + ", tipoCliente=" + tipoCliente + ", dataEntrada=" + dataEntrada + ", dataSaida=" + dataSaida + ", valorTotal=" + valorTotal + ", ultimaEntrada=" + ultimaEntrada + '}';
    }

}
