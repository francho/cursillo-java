/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ejerciciopila;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author: $Author$
 * @version: $Rev$
 * @date: $Date$
 * $Id$
 */
public class AlmacenPila {
    Pila pila;

    public AlmacenPila() {
        pila = new Pila();
    }

    public void serializarPila() {
        File fichero = new File("serializado.dat");
        FileOutputStream escritorFichero = null;
        ObjectOutputStream escritor = null;

        try {
            if (!fichero.exists()) {
                fichero.createNewFile();
            }

            escritorFichero = new FileOutputStream(fichero);
            escritor = new ObjectOutputStream(escritorFichero);

            escritor.writeObject(pila);
        } catch (IOException ex) {
            Logger.getLogger(AlmacenPila.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                escritor.close();
            } catch (IOException ex) {
                Logger.getLogger(AlmacenPila.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void deserializaPila() {

    }
}
