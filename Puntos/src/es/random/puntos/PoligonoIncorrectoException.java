/*
 * Manejador de excepciones de poligonos
 */

package es.random.puntos;

/**
 *
 * @author: $Author$
 * @version: $Rev$
 * @date: $Date$
 * $Id$
 */
public class PoligonoIncorrectoException extends Exception {
    public PoligonoIncorrectoException() {
        super();
    }

    public PoligonoIncorrectoException(String cadena) {
        super("Error en el polígono: " + cadena);
    }


}
