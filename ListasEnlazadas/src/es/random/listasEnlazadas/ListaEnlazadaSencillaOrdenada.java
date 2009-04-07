/*
 * Implementa una lista enlazada sencilla
 */

package es.random.listasEnlazadas;

/**
 *
 * @author: $Author$
 * @version: $Rev$
 * @date: $Date$
 * $Id$
 */
public class ListaEnlazadaSencillaOrdenada extends ListaEnlazadaSencilla {

    /**
     * Inserta un nodo dejando la lista orenada
     * @param nuevoNodo nodo a insertar
     */

    @Override
    public void añadir(Nodo nuevoNodo) {
        if( (this.isPermitirDuplicados() == false) && (buscar(nuevoNodo.getValor()) != null) ) {
            return;
        }
        if(primerNodo == null) { // Si es una lista vacia lo ponemos el primero
            primerNodo = nuevoNodo;
        } else if(nuevoNodo.getValor() < primerNodo.getValor()) { // Si es el primero
            nuevoNodo.setSiguiente(primerNodo);
            primerNodo = nuevoNodo;
        } else { // Si no lo hemos insertado el primero, recorremos la lista par buscarle sitio
            Nodo puntero = primerNodo;
            boolean insertado = false;

            while(!insertado && (puntero.getSiguiente() != null)) {
                if ((puntero.getValor() == nuevoNodo.getValor())) {
                    // Comprobamos si admitimos o no duplicados
                    if (this.isPermitirDuplicados()) {
                        nuevoNodo.setSiguiente(puntero.getSiguiente());
                        puntero.setSiguiente(nuevoNodo);
                    }
                    insertado = true;
                } else if ((nuevoNodo.getValor() > puntero.getValor()) &&
                        (nuevoNodo.getValor() < puntero.getSiguiente().getValor())) {
                    nuevoNodo.setSiguiente(puntero.getSiguiente());
                    puntero.setSiguiente(nuevoNodo);
                    insertado = true;
                }
                puntero = puntero.getSiguiente();
            }
            // Si no le hemos encontrado un sitio mejor lo ponemos al final
            if(!insertado) {
                puntero.setSiguiente(nuevoNodo);
            }
        }
    }

}
