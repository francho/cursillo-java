/*
 * Guarda la pila serializada en un fichero y la recupera
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
    private String nombreFichero;
    
    public AlmacenPila() {
        nombreFichero = "serializado.dat"; 
    }
    
    
    
    /**
     * Serializa la pila y la guarda en un fichero
     */
    public void serializarPila(Pila pila) {
        File fichero = new File(getNombreFichero());
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

    /**
     * Recupera la pila guardada en el fichero y vuelve a cargar el objeto pila
     */
    public Pila deserializaPila() {
        File fichero = new File(getNombreFichero());
        FileInputStream lectorFichero = null;
        ObjectInputStream lector = null;
        
        // Inicializamos la pila para limpiar posibles valores anteriores
        Pila pila = new Pila();
        
        if(fichero.exists()) {
            try {
                lectorFichero = new FileInputStream(fichero);
                lector = new ObjectInputStream(lectorFichero);
                pila = (Pila) lector.readObject();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(AlmacenPila.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(AlmacenPila.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
        return pila;
    }

    public String getNombreFichero() {
        return nombreFichero;
    }

    public void setNombreFichero(String nombreFichero) {
        this.nombreFichero = nombreFichero;
    }

}
