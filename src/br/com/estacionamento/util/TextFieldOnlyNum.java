package br.com.estacionamento.util;

import java.awt.event.KeyEvent;
import javax.swing.JTextField;

/**
 * Chamar essa classe Em Codigo Personalizado dentro de Propriedades do
 * JtextField na view.
 * <b>JTextField1 = new TextFieldOnlyNum(50);</b>
 * <b>Set maximo de Caracteres por parametro no Construtor.</b>
 *
 * @author William
 */
public class TextFieldOnlyNum extends JTextField {

    private int maximoCaracteres = -1;

    public TextFieldOnlyNum() {
        super();
        addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldKeyTyped(evt);
            }
        });
    }

    public TextFieldOnlyNum(int maximo) {
        super();
        setMaximoCaracteres(maximo);

        addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldKeyTyped(evt);
            }
        });
    }

    private void jTextFieldKeyTyped(KeyEvent evt) {
        String caracteres = "0987654321";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
        if ((getText().length() >= getMaximoCaracteres()) && (getMaximoCaracteres() != -1)) {
            evt.consume();
            setText(getText().substring(0, getMaximoCaracteres()));
        }
    }

    public int getMaximoCaracteres() {
        return maximoCaracteres;
    }

    public void setMaximoCaracteres(int maximoCaracteres) {
        this.maximoCaracteres = maximoCaracteres;
    }

}
