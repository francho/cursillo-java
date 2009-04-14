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
        add(
            new JLabel(
                  "<html><h1><i>Core Java</i></h1><hr>By Cay Horstmann and Gary Cornell</html>"),
            BorderLayout.CENTER);

      // Ok button closes the dialog

      JButton ok = new JButton("Ok");
      ok.addActionListener(new ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               setVisible(false);
            }
         });

      // add Ok button to southern border

      JPanel panel = new JPanel();
      panel.add(ok);
      add(panel, BorderLayout.SOUTH);

      setSize(250, 150);
      // La ventana en el centro de la pantalla
      this.setLocationRelativeTo(null);
    }

}
