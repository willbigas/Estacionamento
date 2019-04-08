package br.com.estacionamento.util;

import br.com.estacionamento.view.JanelaSaida;
import java.awt.BorderLayout;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

/**
 * Para invocar este Metodo - deve se usar
 * <b>ThreadData dataAtual = new ThreadData();</b>
 *
 * @author William Bigas Mauro
 */
public class ThreadData extends JFrame {

    private JLabel label;

    public ThreadData() {
        setSize(200, 100);
        setTitle("Hora");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        label = new JLabel();
        label.setFont(new Font("Arial", Font.BOLD, 35));
        label.setHorizontalAlignment(JLabel.CENTER);
        add(label, BorderLayout.CENTER);
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Thread(new AtualizadorData()).start();
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ThreadData().setVisible(true);
            }
        });
    }

    private class AtualizadorData implements Runnable {

        private SimpleDateFormat sdf;

        public AtualizadorData() {
            sdf = new SimpleDateFormat("dd/MM/yyyy");
        }

        public void run() {
            while (true) {
                try {
                    JanelaSaida.tfDataSaida.setText(sdf.format(new Date())); // chamar a Label ou Texfield
                    Thread.sleep(500);
                } catch (InterruptedException exc) {
                    exc.printStackTrace();
                }
            }
        }
    }
}
