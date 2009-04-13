/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ejercicionotepad;

import java.awt.event.ActionEvent;
import javax.swing.*;

/**
 *
 * @author: $Author$
 * @version: $Rev$
 * @date: $Date$
 * $Id$
 */
public class VentanaNotepad extends JFrame {
    public VentanaNotepad() {
        super();

        setTitle("Editor de texto");
        setSize(600,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Menu archivo
        JMenu menuArchivo = new JMenu("Archivo");
        menuArchivo.setMnemonic('a');

        
        JMenuItem itemAbrir = menuArchivo.add(new AccionFichero("Abrir"));
        itemAbrir.setAccelerator(KeyStroke.getKeyStroke("ctrl O"));
        itemAbrir.setMnemonic('A');

        JMenuItem itemGuardar = menuArchivo.add(new AccionFichero("Guardar"));
        itemGuardar.setAccelerator(KeyStroke.getKeyStroke("ctrl S"));
        itemGuardar.setMnemonic('G');

        menuArchivo.addSeparator();

        JMenuItem itemSalir = menuArchivo.add(new AccionFichero("Salir"));
        itemSalir.setAccelerator(KeyStroke.getKeyStroke("ctrl E"));
        itemSalir.setMnemonic('S');

        // Menu edición

        JMenu menuEdicion = new JMenu("Edición");
        menuEdicion.setMnemonic('E');

        JMenuItem itemCopiar = menuEdicion.add(new AccionEdicion("Copiar"));
        itemCopiar.setMnemonic('C');

        JMenuItem itemCortar = menuEdicion.add(new AccionEdicion("Cortar"));
        itemCortar.setMnemonic('t');

        JMenuItem itemPegar = menuEdicion.add(new AccionEdicion("Pegar"));
        itemPegar.setMnemonic('P');

        // Creamos el menu
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        menuBar.add(menuArchivo);
        menuBar.add(menuEdicion);

        // Zona de escritura
        
        JTextArea texto = new JTextArea(8,40);
        texto.setLineWrap(true);
        JScrollPane scroll = new JScrollPane(texto);
        
        add(scroll);

//        JPanel panel = (JPanel) getContentPane();
//        panel.add(scroll);



    }
}

class AccionFichero extends  AbstractAction {
    public AccionFichero(String nombre) {
        super(nombre);
    }

    public void actionPerformed(ActionEvent e)
    {
        System.out.println(getValue(Action.NAME));
    }

}

class AccionEdicion extends  AbstractAction {
    public AccionEdicion(String nombre) {
        super(nombre);
    }

    public void actionPerformed(ActionEvent e)
    {
        System.out.println(getValue(Action.NAME));
    }

}