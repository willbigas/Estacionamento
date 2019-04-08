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
 * <b>ThreadHora horaAtual = new ThreadHora();</b>
 *
 * @author William Bigas Mauro
 */
public class ThreadHora extends JFrame {

    private JLabel label;

    public ThreadHora() {
        setSize(200, 100);
        setTitle("Hora");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        label = new JLabel();
        label.setFont(new Font("Arial", Font.BOLD, 35));
        label.setHorizontalAlignment(JLabel.CENTER);
        add(label, BorderLayout.CENTER);
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Thread(new AtualizadorHora()).start();
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ThreadHora().setVisible(true);
            }
        });
    }

    private class AtualizadorHora implements Runnable {

        private SimpleDateFormat sdf;

        public AtualizadorHora() {
            sdf = new SimpleDateFormat("HH:mm:ss");
        }

        public void run() {
            while (true) {
                try {
                    JanelaSaida.tfHoraSaida.setText(sdf.format(new Date()));
                    Thread.sleep(500);
                } catch (InterruptedException exc) {
                    exc.printStackTrace();
                }
            }
        }
    }
}
