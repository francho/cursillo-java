/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package listasenlazadas;

/**
 *
 * @author: $Author$
 * @version: $Rev$
 * @date: $Date$
 * $Id$
 */
public class Lista {
    int valor;
    Lista siguiente;

    public Lista() {
        valor=0;
        siguiente = null;
    }

    public void añadirElemento(int nuevoValor) {
        Lista nuevoNodo = new Lista();
        nuevoNodo.valor = nuevoValor;
        añadirElemento(nuevoNodo);
    }

    public void añadirElemento(Lista nuevoNodo) {
        Lista nodoFinal = this;
        while(nodoFinal.siguiente != null)  {
            nodoFinal = nodoFinal.siguiente;
        }
        nodoFinal.siguiente = nuevoNodo;
    }

    @Override
    public String toString() {
        String s = "";
        Lista nodo = this;
        while(nodo.siguiente != null) {
            s += nodo.valor + "\n";
            nodo = nodo.siguiente;
        }
        return s;
    }
}
