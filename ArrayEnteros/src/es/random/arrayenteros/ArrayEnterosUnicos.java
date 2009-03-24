/*
 * Clase que mejora ArrayEnteros para que el array solo tenga números únicos
 * 
 */

package es.random.arrayenteros;

/**
 *
 * @author: $Author$
 * @version: $Rev$
 * @date: $Date$
 * $Id$
 */
public class ArrayEnterosUnicos extends ArrayEnteros {

    /**
     * Funcion añadir que se asegura de que un número no esté antes de añadirlo
     *
     * @param num numero a añadir
     */
    @Override
    public void añadir(int numero) {
        if(! this.contiene(numero)) {
            this.insertarOrdenado(numero);
        }
    }
}
