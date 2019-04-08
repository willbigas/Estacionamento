package br.com.estacionamento.util;

import javax.swing.JFormattedTextField;
import javax.swing.JTextField;

/**
 *
 * @author William
 */
public class TextField {

    /**
     * Verificar se o valor do JtextField está vazio
     *
     * @param value
     * @return
     */
    public static boolean isEmpty(JTextField value) {
        if (value.getText().isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
    
      /**
     * Verificar se o valor do JtextField está vazio
     *
     * @param value
     * @return
     */
    public static boolean isEmpty(JFormattedTextField value) {
        if (value.getText().isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Limpa o Conteudo do JtextField
     *
     * @param value
     */
    public static void cleanTextField(JTextField value) {
        value.setText(null);
    }

    public static boolean isDouble(JTextField value) {
        try {
            Double teste = Double.valueOf(value.getText());
            return true;
        } catch (NumberFormatException numberFormatException) {
            return false;
        }
    }

}
