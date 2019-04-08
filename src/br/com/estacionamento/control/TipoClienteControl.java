package br.com.estacionamento.control;

import br.com.estacionamento.dao.TipoClienteDao;
import br.com.estacionamento.model.TipoCliente;
import br.com.estacionamento.view.JanelaEntrada;

/**
 *
 * @author William
 */
public class TipoClienteControl {

    TipoClienteDao TIPO_CLIENTE_DAO = new TipoClienteDao();

    /**
     * Cria um Tipo de cliente baseado no opcao selecionada da JcomboBox 0 =
     * Tipo 1 (TipoServidor) 1 = Tipo 2 (TipoCliente)
     *
     * @return Retorna o ID do Cadastro
     */
    public int inserirTipoCliente() {
        TipoCliente tc = new TipoCliente(); 
        int result = JanelaEntrada.cbTipoCliente.getSelectedIndex();
        tc.setId(Integer.MAX_VALUE);
        if (result == 0) {
            tc.setIdTipo(1);
        }
        if (result == 1) {
            tc.setIdTipo(2);
        }
        int id = TIPO_CLIENTE_DAO.cadastrar(tc);
        return id;
    }

    /**
     * Altera um Tipo de cliente baseado no opcao selecionada da JcomboBox 0 =
     * Tipo 1 (TipoServidor) 1 = Tipo 2 (TipoCliente)
     *
     * @param tc
     * @return Retorna opcao se foi modificado ou não.
     */
    public Boolean atualizarTipoCliente(TipoCliente tc) {
        int result = JanelaEntrada.cbTipoCliente.getSelectedIndex();
        if (result == 0) {
            tc.setIdTipo(1);
        }
        if (result == 1) {
            tc.setIdTipo(2);
        }
        return TIPO_CLIENTE_DAO.alterar(tc);
    }
}
