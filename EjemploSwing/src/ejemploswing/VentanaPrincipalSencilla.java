/*
 * La ventana principal de nuestra aplicación
 */

package ejemploswing;

import java.awt.*;
import javax.swing.*;


/**
 *
 * @author: $Author$
 * @version: $Rev$
 * @date: $Date$
 * $Id$
 */
public class VentanaPrincipalSencilla extends JFrame {

    public VentanaPrincipalSencilla() {
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

        // Ahora dibujamos los elementos

        
        // Cambiamos el comportamiento para que los elementos se nos pongan en
        // Otros layouts:
        //  - FlowLayout
        //  - BoxLayout
        //  - BorderLayout
        //  - SpringLayout
        //  - AbsoluteLayout
        //  - GridLayout

        panel.setLayout(new BorderLayout()); // viene por defecto, lo divide en cinco zonas (north, south, west, east, center)


        // Un boton
        JButton boton = new JButton("Boton");

        panel.add("North",boton);

        // Añadimos mas botones
        panel.add("East",new JButton("segumdo botón"));
        panel.add("West",new JButton("tercer botón"));
        panel.add("South",new JButton("cuarto botón"));
        panel.add("Center",new JButton("quinto botón"));

        // Redibujamos la ventana
        this.validate();

    }
}
