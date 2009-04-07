/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ejerciciocolecciones;

/**
 *
 * @author: $Author$
 * @version: $Rev$
 * @date: $Date$
 * $Id$
 */
public class InfoPalabra {
    String palabra;
    int apariciones = 0;

    public InfoPalabra(String palabra, int apariciones) {
        this.palabra = palabra;
        this.apariciones = apariciones;
    }

    @Override
    public String toString() {
        
        return "[" + palabra + ": " + apariciones + "]";
    }

    public boolean equals(Object otra) {
        boolean iguales = false;
        if(! otra instanceof InfoPalabra) {
            iguales = (palabra.equals(otra.palabra)) && (apariciones == otra.apariciones);
        }
        return iguales;
    }
}
