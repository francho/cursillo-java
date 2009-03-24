/*
 * Ejercicio: Hacer una clase que sirva para gestionar una lista de números enteros
 *
 * Debe poder:
 *  - Añadir un entero
 *  - Borrar un entero
 *  - Buscar la posicion de un entero
 *  - Comprobar si contiene un valor
 *
 * Condiciones:
 *  - El array debe estar ordenado
 *
 * Mejora:
 *  - Hacer una subclase que controle que no haya números duplicados
 *
 */

package arrayenteros;

import es.random.arrayenteros.ArrayEnteros;
import es.random.arrayenteros.ArrayEnterosUnicos;

/**
 *
 * @author: $Author$
 * @version: $Rev$
 * @date: $Date$
 * $Id$
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Inicializamos la clase a probar

        ArrayEnteros misEnteros = new ArrayEnteros();
        //ArrayEnteros misEnteros = new ArrayEnterosUnicos();

        // Cargamos el array de la clase

        misEnteros.añadir(5);
        misEnteros.añadir(3);
        misEnteros.añadir(3);
        misEnteros.añadir(100);
        misEnteros.añadir(3);
        misEnteros.añadir(3);
        misEnteros.añadir(1);

        System.out.println(misEnteros.toString());

        // Como el metodo insertar es protected y esta en otro paquete no puedo
        // llamarlo desde aqui:
        //
        // arr.insertar(5);

        misEnteros.borrar(100); // Borramos un valor existente
        misEnteros.borrar(8); // Probamos con valores inexistentes

        misEnteros.borrarTodos(3); // Borramos todas las ocurrencias de 3

        System.out.println(misEnteros.toString());

        
    }

}
