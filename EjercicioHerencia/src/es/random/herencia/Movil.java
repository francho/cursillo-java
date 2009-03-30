/*
 * Interface para el manejo de cosas que se pueden desplazar
 * define el método comun que usaremos cuando las tratemos en conjunto
 */

package es.random.herencia;

/**
 *
 * @author: $Author$
 * @version: $Rev$
 * @date: $Date$
 * $Id$
 */
public interface Movil {
    /**
     * Desplaza el objeto una distancia determinada
     * @param kilometros a desplazar
     */
    public void desplazar(double kilometos);
}
