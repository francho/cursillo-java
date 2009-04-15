/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ejercicionotepad;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author: $Author$
 * @version: $Rev$
 * @date: $Date$
 * $Id$
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
class VentanaAcercaDe extends JDialog {
    public VentanaAcercaDe(JFrame padre) {
        super(padre, "Acerca de...", true);

        JLabel texto = new JLabel(
                  "<html><center><h1>mi Primer Editor chispas</h1><br/><i> $Author$ $Id$ </i></center></html>"
                  );
        texto.setHorizontalAlignment(SwingConstants.CENTER);

        add(texto, BorderLayout.CENTER);

      // Creamos el botón que cerrará la ventana
      JButton botonCerrar = new JButton("Cerrar");
      botonCerrar.addActionListener(new ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               setVisible(false);
            }
         });

      // El Boton irá al pie, lo metemos dentro de un Panel para que no ocupe el 100% del ancho
      JPanel panel = new JPanel();
      panel.add(botonCerrar);
      add(panel, BorderLayout.SOUTH);

      // Añadimos el logo
      JLabel logo = new JLabel();
      logo.setIcon(new ImageIcon("media/logo.jpg"));
      add(logo, BorderLayout.WEST);

      // Dimensionamos la ventana
      setSize(350, 250);

      // La ventana en el centro de la pantalla
      this.setLocationRelativeTo(null);
    }

}
