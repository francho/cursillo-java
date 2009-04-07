/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.random.listasEnlazadas;

/**
 *
 * @author: $Author$
 * @version: $Rev$
 * @date: $Date$
 * $Id$
 */
public class Nodo {
    private int valor;
    private Nodo siguiente;

    /**
     * @return the valor
     */
    public int getValor()
    {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(int valor)
    {
        this.valor = valor;
    }

    /**
     * @return the siguiente
     */
    public Nodo getSiguiente()
    {
        return siguiente;
    }

    /**
     * @param siguiente the siguiente to set
     */
    public void setSiguiente(Nodo siguiente)
    {
        this.siguiente = siguiente;
    }

    @Override
    public String toString() {
        return Integer.toString(valor);
    }

}
