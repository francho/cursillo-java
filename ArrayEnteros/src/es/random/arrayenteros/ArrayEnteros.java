/* Clase que contiene un array de numeros enteros
 *
 * Debe poder:
 *  - Añadir un entero
 *  - Borrar un entero
 *  - Buscar la posicion de un entero
 *  - Comprobar si contiene un valor
 *
 * Condiciones:
 *  - El array debe estar ordenado
 */

package es.random.arrayenteros;

/**
 *
 * @author: $Author$
 * @version: $Rev$
 * @date: $Date$
 * $Id$
 */
public class ArrayEnteros
{

    protected int[] enteros;

    public ArrayEnteros()
    {
        enteros = new int[0];
    }

    /**
     * Añade un número a la lista
     *
     * @param numero a insertar
     */
    public void añadir(int numero) {
        insertarOrdenado(numero);
    }

    /**
     * Añade un elemento a la lista dejandola ordenada
     * 
     * @param numero a añadir
     */
    protected void insertarOrdenado(int numero)
    {

        int[] nuevoEnteros = new int[enteros.length + 1];

        // Comprobamos si es el primero
        if (enteros.length == 0) {
            nuevoEnteros[0] = numero;
            enteros = nuevoEnteros;
            return;
        }

        // Recorremos la lista colocandolo en su sitio
        boolean insertado = false;

        int n = 0;
        for (int x = 0; x < enteros.length; x++) {
            if (numero < enteros[x] && !insertado) {
                nuevoEnteros[n++] = numero;
                insertado = true;
            }
            nuevoEnteros[n++] = enteros[x];
        }

        // Si todavía no lo hemos insertado, es el último
        if(!insertado) {
            nuevoEnteros[n] = numero;
        }

        enteros = nuevoEnteros;
    }

    /**
     * Borra la primera ocurrencia de la lista
     *
     * @param aBorrar numero a borrar
     */
    public void borrar(int aBorrar)
    {
        int pos = buscar(aBorrar);
        if(pos > -1) {
            int[] nuevoEnteros = new int[enteros.length-1];
            int n = 0;
            for(int x=0; x<enteros.length; x++) {
                if(x != pos) {
                    nuevoEnteros[n++] = enteros[x];
                }
            }

            enteros = nuevoEnteros;
        }
    }

    /**
     * Borra todas las ocurrencias de un numero
     *
     * @param aBorrar numero a borrar
     */

    public void borrarTodos(int aBorrar) {
        while(this.contiene(aBorrar)) {
            this.borrar(aBorrar);
        }
    }

    /**
     * Devuelve la posicion de la primera ocurrencia de un numero en la lista
     *
     * @param aBuscar número a buscar
     * @return posicion de la primera ocurrencia
     */
    public int buscar(int num)
    {
        for (int x = 0; x < enteros.length; x++) {
            if(enteros[x] == num) { return x; }
        }
        return -1;
    }

    /**
     * Comprueba si un numero está o no en la lista
     *
     * @param num
     * @return boolean true si está, false sino
     */
    public boolean contiene(int num)
    {
        return buscar(num) > -1;
    }

    /**
     * Maqueta el contenido
     *
     * @return cadena con todos los numeros del array
     */
    @Override
    public String toString()
    {
        String cad = "";
        for (int x = 0; x < enteros.length; x++) {
            cad += "[" + x + "] " + enteros[x] + "\n";
        }

        return cad;
    }
}
