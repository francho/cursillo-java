/*
 * Interfaz para nuestra calculadora sencilla
 */
package calculadora;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author: $Author$
 * @version: $Rev$
 * @date: $Date$
 * $Id$
 */
public class VentanaCalculadora extends JFrame
{

    JTextField operador1;
    double operador2;

    public VentanaCalculadora()
    {
        super();
        this.setSize(200, 250);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // Vamos a dibujar sobre el panel
        JPanel panel = (JPanel) this.getContentPane();
        panel.setLayout(new BorderLayout());

        operador1 = new JTextField("0", 20);
        operador1.setBorder(new EmptyBorder(4, 4, 0, 0));
        operador1.setFont(new Font("Arial", Font.BOLD, 25));
        operador1.setHorizontalAlignment(JTextField.RIGHT);
        operador1.setEditable(false);
        panel.add("North", operador1);

        JPanel panelNumeros = new JPanel();
        panelNumeros.setLayout(new GridLayout(4, 3));
        panelNumeros.setBorder(new EmptyBorder(4, 4, 4, 4));

        for (int n = 9; n >= 0; n--) {
            JButton btn = new JButton();
            btn.setText(new Integer(n).toString());
            btn.addMouseListener(
                    new MouseAdapter()
                    {
                @Override
                        public void mouseReleased(MouseEvent evt)
                        {
                            JButton btn = (JButton) evt.getSource();
                            teclaPulsada(btn.getText());
                        }
                    });

            btn.addKeyListener(
                    new KeyAdapter() {

            });
            panelNumeros.add(btn);
            btn.setHorizontalAlignment(SwingConstants.RIGHT);
        }
        panelNumeros.add(new JButton("."));

        panel.add("Center", panelNumeros);

        JPanel panelOperaciones = new JPanel();
        panelOperaciones.setLayout(new GridLayout(6, 1));
        panelOperaciones.setBorder(new EmptyBorder(4, 4, 4, 4));

        panelOperaciones.add(new JButton("+"));
        panelOperaciones.add(new JButton("-"));
        panelOperaciones.add(new JButton("*"));
        panelOperaciones.add(new JButton("/"));
        panelOperaciones.add(new JButton("="));
        panelOperaciones.add(new JButton("CE"));

        panel.add("East", panelOperaciones);


        validate();

    }

    private void teclaPulsada(String tecla)
    {
        operador1.setText(operador1.getText() + tecla);
    }
}
