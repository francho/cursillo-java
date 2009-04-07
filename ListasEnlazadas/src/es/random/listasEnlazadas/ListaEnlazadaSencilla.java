/*
 * Clase para el manejo de listas enlazadas sencillas
 */

package es.random.listasEnlazadas;

/**
 *
 * @author: $Author$
 * @version: $Rev$
 * @date: $Date$
 * $Id$
 */
abstract public class ListaEnlazadaSencilla {
    public Nodo primerNodo = null;
    private boolean permitirDuplicados = false;

    /**
     * Añade un valor a la lista
     * @param valor número a añadir
     */
    public void añadir(int valor) {
        Nodo nodo = new Nodo();
        nodo.setValor(valor);

        añadir(nodo);
    }

    /**
     * Esta clase deberán sobreescribirla las clases hijas para ver como quieren añadir
     * @param nodo nodo a añadir
     */
    abstract public void añadir(Nodo nodo);

    /**
     * Borra el nodo con la primera ocurrencia del valor
     *
     * @param valor numero a borrar
     */
    public void borrar(int valor) {
        if (buscar(valor) != null) {
            if (primerNodo.getValor() == valor) { // Si es el primero
                primerNodo = primerNodo.getSiguiente();
            } else {
                Nodo anterior = buscarAnteriorA(valor);
                // Para borrar simplemente enlazo con el siguiente del siguiente
                anterior.setSiguiente(anterior.getSiguiente().getSiguiente());
            }
        }
    }


    /**
     * Busca el nodo anterior a un determinado valor
     *
     * @param valor a buscar
     * @return el nodo anterior
     */
    public Nodo buscarAnteriorA(int valor) {
        Nodo puntero = primerNodo;
        while (puntero != null) {
            if ((puntero.getSiguiente() != null) && (puntero.getSiguiente().getValor() == valor)) {
                return puntero;
            }
            puntero = puntero.getSiguiente();
        }

        return null;
    }

    /**
     * Busca un nodo con un determinado valor
     * @param valor
     * @return el nodo con el valor
     */
    public Nodo buscar(int valor)  {
        Nodo puntero = primerNodo;
        while (puntero != null) {
            if ((puntero != null) && (puntero.getValor() == valor)) {
                return puntero;
            }
            puntero = puntero.getSiguiente();
        }

        return null;
    }

    /**
     * Representación de nuestra cadena
     * @return
     */
    @Override
    public String toString() {
                String s = "";
        Nodo puntero = primerNodo;

        while (puntero != null) {
            s += puntero.toString() + "\n";
            puntero = puntero.getSiguiente();
        }

        return s;
    }

    /**
     * @return the permitirDuplicados
     */
    public boolean isPermitirDuplicados()
    {
        return permitirDuplicados;
    }

    /**
     * @param permitirDuplicados the permitirDuplicados to set
     */
    public void setPermitirDuplicados(boolean permitirDuplicados)
    {
        this.permitirDuplicados = permitirDuplicados;
    }
}
