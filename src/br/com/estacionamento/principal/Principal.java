package br.com.estacionamento.principal;

import br.com.estacionamento.view.JanelaEntrada;
import br.com.estacionamento.view.JanelaPrincipal;
import br.com.estacionamento.view.JanelaSaida;

/**
 *
 * @author William
 */
public class Principal {

    public static void main(String[] args) {
        JanelaPrincipal();
    }

    /**
     * JFrame de Acesso Principal
     */
    public static void JanelaPrincipal() {
        JanelaPrincipal janelaPrincipal = new JanelaPrincipal();
        janelaPrincipal.setTitle("ACESSO PRINCIPAL");
        janelaPrincipal.setLocationRelativeTo(null);
        janelaPrincipal.setVisible(true);
    }

    /**
     * Jframe de Entrada
     */
    public static void JanelaEntrada() {
        JanelaEntrada janelaEntrada = new JanelaEntrada();
        janelaEntrada.setTitle("JANELA DE ENTRADA");
        janelaEntrada.setLocationRelativeTo(null);
        janelaEntrada.setVisible(true);
    }

    /**
     * JFrame de Saída
     */
    public static void JanelaSaida() {
        JanelaSaida janelaSaida = new JanelaSaida();
        janelaSaida.setTitle("JANELA DE SAIDA");
        janelaSaida.setSize(500, 500);
        janelaSaida.setLocationRelativeTo(null);
        janelaSaida.setVisible(true);
    }
}
