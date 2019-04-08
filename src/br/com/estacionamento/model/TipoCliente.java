package br.com.estacionamento.model;

/**
 *
 * @author William
 */
public class TipoCliente {

    private Integer id;
    private Integer idTipo;
    private Double valorPagamento; // implementar calculo

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(Integer idTipo) {
        this.idTipo = idTipo;
    }

    public Double getPreco() {
        return valorPagamento;
    }


    @Override
    public String toString() {
        return "TipoCliente{" + "nome=" + idTipo + ", preco=" + valorPagamento + '}';
    }

}
