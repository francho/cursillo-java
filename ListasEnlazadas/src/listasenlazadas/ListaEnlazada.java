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
public class ListaEnlazada
{

    /** Valor almacenado en el nodo */
    private int valor;
    /** Puntero al siguiente nodo de la lista */
    private ListaEnlazada siguiente;

    /** True si queremos tener elementos repetidos en la lista, false sino */
    private boolean permitirRepeticiones = true;

    public ListaEnlazada(int valor)
    {
        this.valor = valor;
        siguiente = null;
    }

    /**
     * Añade un nuevo número a la lista dejandola ordenada
     *
     * @param nuevoValor número a añardir
     */
    public void añadirNodo(int nuevoValor)
    {
        ListaEnlazada nuevoNodo = new ListaEnlazada(nuevoValor);
        añadirNodo(nuevoNodo);
    }

    /**
     * Inserta un nodo en la lista ordenadamente
     * Nota: Si permitirRepeticiones es false lo descartará si es repetido
     *
     * @param nuevoNodo Nodo a insertar
     */
    public void añadirNodo(ListaEnlazada nuevoNodo)
    {
        ListaEnlazada puntero = this;
        boolean insertado = false;

        // Si es el primero tenemos que engañarle
        if (nuevoNodo.valor < puntero.valor) {
            // Duplicamos el primero
            añadirNodo(puntero.valor);
            puntero.valor = nuevoNodo.valor;
            insertado = true;
        } else {
            // Si no lo hemos insertado el primero, recorremos la lista par buscarle sitio
            while (!insertado && (puntero.siguiente != null)) {
                // Si encontramos uno igual...
                if ((puntero.valor == nuevoNodo.valor)) {
                    if (permitirRepeticiones == true) {
                        nuevoNodo.siguiente = puntero.siguiente;
                        puntero.siguiente = nuevoNodo;
                    }
                    insertado = true;
                } else if ((nuevoNodo.valor > puntero.valor) && (nuevoNodo.valor < puntero.siguiente.valor)) {
                    nuevoNodo.siguiente = puntero.siguiente;
                    puntero.siguiente = nuevoNodo;
                    insertado = true;
                }
                puntero = puntero.siguiente;
            }
            // Si no le hemos encontrado un sitio mejor lo ponemos al final
            if (!insertado) {
                puntero.siguiente = nuevoNodo;
            }
        }
    }

    /**
     * Busca un valor dentro de la lista
     *
     * @param valor a buscar
     * @return nodo que contiene el valor, null sino encontraod
     */
    public ListaEnlazada buscarValor(int valor)
    {
        ListaEnlazada puntero = this;

        while (puntero != null) {
            if (puntero.valor == valor) {
                return puntero;
            }
            puntero = puntero.siguiente;
        }

        return null;
    }

    /**
     * Busca el nodo anterior a un determinado valor
     * @param valor a buscar
     * @return el nodo anterior
     */
    public ListaEnlazada buscarAnteriorA(int valor)
    {
        ListaEnlazada puntero = this;

        while (puntero != null) {
            if ((puntero.siguiente != null) && (puntero.siguiente.valor == valor)) {
                return puntero;
            }
            puntero = puntero.siguiente;
        }

        return null;
    }

    /**
     * Borra un nodo de la lista
     * Nota: Borra la primera ocurrencia si hay valores duplicados
     *
     * @param nodo a borrar
     */
    public void borrarNodo(ListaEnlazada nodo)
    {
        borrarNodo(nodo.valor);
    }

    /**
     * Borra un nodo a partir de un valor
     * @param valor a borrar
     */
    public void borrarNodo(int valor)
    {
        if (buscarValor(valor) != null) {
            ListaEnlazada anterior = buscarAnteriorA(valor);
            if (anterior == null) { // Si es el primero
                // Como no puedo borrarlo directamente duplico el siguiente número
                // en el actual y luego borro el siguiente
                this.valor = this.siguiente.valor;
                borrarNodo(this.valor);
            } else {
                anterior.siguiente = anterior.siguiente.siguiente;
            }
        }
    }

    @Override
    public String toString()
    {
        String s = "";
        ListaEnlazada nodo = this;

        while (nodo != null) {
            s += nodo.valor + "\n";
            nodo = nodo.siguiente;
        }

        return s;
    }

  
    /**
     * @return the permitirRepeticiones
     */
    public boolean isPermitirRepeticiones()
    {
        return permitirRepeticiones;
    }

    /**
     * @param permitirRepeticiones the permitirRepeticiones to set
     */
    public void setPermitirRepeticiones(boolean permitirRepeticiones)
    {
        this.permitirRepeticiones = permitirRepeticiones;
    }
}
