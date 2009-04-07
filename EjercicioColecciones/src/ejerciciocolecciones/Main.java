/*
 * Crear una lista generica y otra basada en InfoPalabra
 *
 * ArrayList Lista Generica
 * ArrayList<InfoPalabra> listaCadenas
 *
 * - Añadir varios elementos
 * - Recuperarlos
 * - Comprobar si la lista contiene un elemento
 * - Borrar algún elemento
 *
 */

package ejerciciocolecciones;

import java.util.ArrayList;
import java.util.Iterator;

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
        // Creamos una coleccion del tipo generico
        ArrayList lista1 = new ArrayList();
        // Añadimos elementos
        lista1.add("hola");
        lista1.add("mundo");

        // Buscamos un objeto dentro de la coleccion
        String buscar = "hola";
        
        if(lista1.contains(buscar)) {
            System.out.println("La lista contiene la palabra " + buscar);
        }

        // Los recorremos con un iterador
        Iterator iterador = lista1.iterator();

        while(iterador.hasNext()) {
            System.out.println(iterador.toString());
            iterador.next();
        }

        // Borramos un elemento
        lista1.remove("mundo");

        // Comprobamos el resultado
        System.out.println(lista1.toString());

        ArrayList<InfoPalabra> lista2 = new ArrayList<InfoPalabra>();

        lista2.add( new InfoPalabra("una",5) );
        lista2.add( new InfoPalabra("dos",15) );

        System.out.println(lista2.toString());

        lista2.remove(new InfoPalabra("dos",15));

        System.out.println(lista2.toString());

    }

}
