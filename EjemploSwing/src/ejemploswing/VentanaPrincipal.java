/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


package ejemploswing;


import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

/**
 *
 * @author: $Author$
 * @version: $Rev$
 * @date: $Date$
 * $Id$
 */
public class VentanaPrincipal extends JFrame {
    JTextField texto;
    public VentanaPrincipal() {
        // Lo primero de todo llamamos al constructor de la clase;
        super();

        // Personalizamos la ventana

        // Al cerrar la ventana, termina la aplicacion
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // Tamaño mínimo
        // Podemos hacerlo de varias formas
        //this.setSize(300,300);
        this.setSize(new Dimension(300,300));

        // Directamente no podemos pintar sobre la ventana, debemos hacerlo sobre
        // un panel
        JPanel panel = (JPanel) this.getContentPane();

        texto = new JTextField("0",20);
        panel.add("North",texto);
        JPanel panelNumeros = new JPanel(new GridLayout(4,3));
        for(int i=0; i< 12; i++){
            panelNumeros.add(new JButton(new Integer(i).toString()));
        }
        panel.add("Center",panelNumeros);

        JPanel panelOperaciones = new JPanel(new GridLayout(4,1));
        panelOperaciones.add(new JButton("+"));
        panelOperaciones.add(new JButton("-"));
        panelOperaciones.add(new JButton("*"));
        panelOperaciones.add(new JButton("/"));
        panelOperaciones.add(new JButton("="));
        panelOperaciones.add(new JButton("CE"));

        panel.add("East", panelOperaciones);


        // Conectamos loe eventos

        // MouseAdapter es una clase que nos proveen para no tener que implementar todos los métodos abstractos de una clase MouseListener
        // Así solo tenemos que implementar solo los que queramos.

        texto.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent evt) {
                texto.setText("Se ha pulsado el ratón");
            }
        });

        this.validate();
    }

}
