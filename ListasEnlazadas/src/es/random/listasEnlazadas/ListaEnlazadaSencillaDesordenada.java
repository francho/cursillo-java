/*
 * Implementa una lista enlazada desordenada
 *
 */

package es.random.listasEnlazadas;

/**
 *
 * @author: $Author$
 * @version: $Rev$
 * @date: $Date$
 * $Id$
 */
public class ListaEnlazadaSencillaDesordenada extends ListaEnlazadaSencilla {

    /**
     * Inserta un nodo al final de la lista
     *
     * @param nodo nodo a insertar
     */
    @Override
    public void añadir(Nodo nodo) {
        if( (this.isPermitirDuplicados() == false) && (buscar(nodo.getValor()) != null) ) {
            return;
        }
        if(primerNodo == null) {
            primerNodo = nodo;
        } else {
            Nodo puntero = primerNodo;
            while(puntero.getSiguiente() != null) {
                puntero = puntero.getSiguiente();
            }
            puntero.setSiguiente(nodo);
        }
    }
}
