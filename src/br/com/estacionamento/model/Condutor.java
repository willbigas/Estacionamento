package br.com.estacionamento.model;

/**
 *
 * @author William
 */
public class Condutor {

    private Integer id;
    private String nome;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Condutor{" + "nome=" + nome + '}';
    }

}
