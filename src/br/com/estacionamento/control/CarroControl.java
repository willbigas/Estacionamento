package br.com.estacionamento.control;

import br.com.estacionamento.dao.CarroDao;
import br.com.estacionamento.model.Carro;
import br.com.estacionamento.view.JanelaEntrada;

/**
 *
 * @author William
 */
public class CarroControl {

    CarroDao CARRO_DAO = new CarroDao();

    /**
     * Cria uma Entidade automovel e Persiste no BD.
     *
     * @return int <b> - Id do Automovel</b>.
     */
    public int inserirAutomovel() {
        Carro c = new Carro();
        c.setId(Integer.MAX_VALUE);
        c.setPlaca(JanelaEntrada.tfPlaca.getText());
        c.setCor(JanelaEntrada.tfCor.getText());
        c.setMarca(JanelaEntrada.tfMarca.getText());
        c.setModelo(JanelaEntrada.tfModelo.getText());
        return CARRO_DAO.cadastrar(c);
    }

    public Boolean atualizarAutomovel(Carro c) {
        c.setPlaca(JanelaEntrada.tfPlaca.getText());
        c.setCor(JanelaEntrada.tfCor.getText());
        c.setMarca(JanelaEntrada.tfMarca.getText());
        c.setModelo(JanelaEntrada.tfModelo.getText());
        return CARRO_DAO.alterar(c);
    }
}
