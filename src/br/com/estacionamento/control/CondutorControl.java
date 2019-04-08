package br.com.estacionamento.control;

import br.com.estacionamento.dao.CondutorDao;
import br.com.estacionamento.model.Condutor;
import br.com.estacionamento.view.JanelaEntrada;

/**
 *
 * @author William
 */
public class CondutorControl {

    CondutorDao CONDUTOR_DAO = new CondutorDao();

    public int inserirCondutor() {
        Condutor co = new Condutor();
        co.setNome(JanelaEntrada.tfCondutor.getText());
        co.setId(Integer.MAX_VALUE);
        return CONDUTOR_DAO.cadastrar(co);
    }

    public Boolean atualizarCondutor(Condutor co) {
        co.setNome(JanelaEntrada.tfCondutor.getText());
        return CONDUTOR_DAO.alterar(co);
    }
}
