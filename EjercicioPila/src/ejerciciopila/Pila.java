/*
 *
 */
package ejerciciopila;

/**
 *
 * @author: $Author$
 * @version: $Rev$
 * @date: $Date$
 * $Id$
 */
public class Pila
{
    private int capacidad;
    
    private int[] valores;

    private int tamaño;

    public void crear(int capacidad) {
        this.valores = new int[capacidad];
        this.capacidad = capacidad;
        this.tamaño = 0;
    }

    /**
     * Introduce un nuevo valor en la cima de la pila
     * Incrementa en uno el tamaño actual de la pila
     *
     * @param nuevoValor
     * @return true si se ha podido añadir, false en caso contrario
     */
    boolean apilar(int nuevoValor)
    {
        if(!estaLlena()) {
            valores[tamaño++] = nuevoValor;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Extrae el valor que está en la cima de la pila
     * Reduce en uno el tamaño actual de la pila
     *
     * @return el valor que está en la cima de la pila
     */
    int desapilar()
    {
        int valor = 0;
        if(!estaVacia()) {
            --tamaño;
            valor = getValores()[getTamaño()];
            valores[tamaño] = 0;
        }
        return valor;
    }

    /**
     * Muestra lacima de la pila
     *
     * @return el valor que esta en la cima sin extraerlo
     */

    public int verCima() {
        int valor;
        if(getTamaño() > 0) {
            valor = getValores()[getTamaño()-1];
        } else {
            this.errVacia();
            valor = 0;
        }
        return valor ;
    }
    
    /**
     * Vacía la pila
     */
    public void vaciar() {
        crear(getCapacidad());
    }

    /**
     * Indica si el tamaño de la pila ha alcanzado su máximo
     * 
     * return true si está llena, fase sino
     */
    public boolean estaLlena() {
        return (getTamaño() >= getCapacidad());
    }

    /**
     * Indica si la pila tiene o no valores
     * @return true si está vacia, false sino
     * 
     */
    public boolean estaVacia() {
        return (getTamaño() == 0);
    }

    /**
     * Muestra el contenido de la pila
     */
    public void mostrar() {
        System.out.println("-------------");
        System.out.print(toString());
        System.out.println("-------------");
    }

    /**
     * Gestiona el error de pila vacía
     */
    private void errVacia() {
        System.out.println("ERROR - Pila vacía");
    }


    /*
     * @return Representacion en forma de texto de nuestra cadena
     */
    @Override
    public String toString()
    {
        String pila = "";
        for (int x=getCapacidad()-1; x>=0; x--) {
            pila += "["+x+"] ";
            if(x>=getTamaño()) {
                pila += "(libre)";
            } else {
                pila += Integer.toString(getValores()[x]);
            }
            pila += "\n";
        }
        return pila;
    }

    /**
     * @return the capacidad
     */
    public int getCapacidad()
    {
        return capacidad;
    }

    /**
     * @return the valores
     */
    public int[] getValores()
    {
        return valores;
    }

    /**
     * @return the tamaño
     */
    public int getTamaño()
    {
        return tamaño;
    }
}
