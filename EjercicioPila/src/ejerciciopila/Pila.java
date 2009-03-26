/*
 * Manejador sencillo para una lista LIFO de enteros
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
    /**
     * Capacidad total de la pila
     */
    private int capacidad; 

    /**
     * Valores de la pila
     */
    private int[] valores;

    /**
     * tamaño actual de la pila
     */
    private int tamaño;

    /**
     * Constructor de la clase
     */
    public Pila() {
        crear(10);
    }

    /**
     * Constructor de la clase para los casos que queramos indicar el tamaño
     * @param capacidad del vector
     */
    public Pila(int capacidad) {
        crear(capacidad);
    }

    /**
     * Constructor de la clase
     *
     * @param capacidad
     */

    public void crear(int capacidad) {
        this.valores = new int[capacidad];
        this.capacidad = capacidad;
        this.tamaño = 0;
    }

    /**
     * Modifica la capacidad de la lista
     * Ojo: descarta datos de la cima (si se hace la lista mas pequeña)
     *
     * @param nueva capacidad de la lista
     */
    public void cambiarCapacidad(int capacidad) {
        this.capacidad = capacidad;

        int[] nuevo = new int[this.capacidad];

        for(int x=0; x<tamaño && x<capacidad ;x++) {
            nuevo[x] = valores[x];
        }
        valores = nuevo;
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
        // Si la hemos llenado, la redimensionamos duplicando su tamaño
        if(tamaño == capacidad) {
            this.cambiarCapacidad(capacidad * 2);
        }
        valores[tamaño++] = nuevoValor;
        return true;
    }

    /**
     * Extrae el valor que está en la cima de la pila
     * Reduce en uno el tamaño actual de la pila
     *
     * @return el valor que está en la cima de la pila
     */
    int desapilar()
    {
        if(!estaVacia()) {
            return valores[--tamaño];
        } else {
            this.errVacia();
            return 0;
        }
    }

    /**
     * Muestra lacima de la pila
     *
     * @return el valor que esta en la cima sin extraerlo
     */

    public int verCima() {
        int valor;
        if(!this.estaVacia()) {
            valor = valores[tamaño - 1];
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
        crear(capacidad);
    }

    /**
     * Indica si el tamaño de la pila ha alcanzado su máximo
     * 
     * return true si está llena, fase sino
     */
    public boolean estaLlena() {
        return (tamaño >= capacidad);
    }

    /**
     * Indica si la pila tiene o no valores
     * @return true si está vacia, false sino
     * 
     */
    public boolean estaVacia() {
        return (tamaño == 0);
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

    /**
     * Gestiona el error de pila llena
     */
    private void errLlena() {
        System.out.println("ERROR - Pila llena");
    }


    /*
     * @return Representacion en forma de texto de nuestra cadena
     */
    @Override
    public String toString()
    {
        String pila = "";
        for (int x=capacidad-1; x>=0; x--) {
            pila += "["+x+"] ";
            if(x >= tamaño) {
                pila += "(libre)";
            } else {
                pila += Integer.toString(valores[x]);
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

    public void setCapacidad(int capacidad) {
        this.cambiarCapacidad(capacidad);
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
