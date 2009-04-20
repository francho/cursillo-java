/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciovectordinamico;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author: $Author$
 * @version: $Rev$
 * @date: $Date$
 * $Id$
 */
public class VectorDinamicoSincronizado
{

    protected String[] datos;

    public VectorDinamicoSincronizado()
    {
        datos = new String[0];
    }

    /**
     * Añade un número a la lista
     *
     * @param numero a insertar
     */
    public void añadir(int numero)
    {
        //insertarOrdenado(numero);
    }

    // TODO !!!!!


    public synchronizable void añadirEn(String texto, int posicion)
    {
        if(posicion > datos.length) {
            try {
                // Si la posición que intentamos insertar está fuera del vector actual
                // Esperamos a ver si hay suerte y el vector crece
                wait(5000);
            } catch (InterruptedException ex) {
                Logger.getLogger(VectorDinamicoSincronizado.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            datos[posicion] = texto;
        }
        notifyAll();
    }


    /**
     * Maqueta el contenido
     *
     * @return cadena con todos los numeros del array
     */
    @Override
    public String toString()
    {
        String cad = "[";
        for (int x = 0; x < datos.length; x++) {
            cad += "" + datos[x] + " ";
        }
        cad += "]";

        return cad;
    }
}
