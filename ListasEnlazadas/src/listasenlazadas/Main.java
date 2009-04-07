/*
 * Ejemplo de uso de listas enlazadas sencillas.
 * Debe:
 *
 * - Almacenar el nodo final
 * - Método añadir que inserta el nodo en orden.
 * - Una variable booleana que permitirRepeticiones (si está true permite añadir repetidos y false no)
 * - Método para borrar nodo
 *
 */

package listasenlazadas;

import es.random.listasEnlazadas.ListaEnlazadaNoObjetos;
import es.random.listasEnlazadas.ListaEnlazadaSencilla;
import es.random.listasEnlazadas.ListaEnlazadaSencillaDesordenada;
import es.random.listasEnlazadas.ListaEnlazadaSencillaOrdenada;
import java.util.Date;
import java.util.Random;

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
        // Ejemplo de uso de la clase Lista sencilla (el nodo está incluido en la clase Lista)

        ListaEnlazadaNoObjetos lista = new ListaEnlazadaNoObjetos(6);

        lista.setPermitirRepeticiones(true);

        lista.añadirNodo(1);
        lista.añadirNodo(5);
        lista.añadirNodo(2);
        lista.añadirNodo(29);
        lista.añadirNodo(4);
        lista.añadirNodo(10);
        lista.añadirNodo(100);


        if(lista.buscarValor(5) == null) {
            System.out.println("No encontrado");
        } else {
            System.out.println("Encontrado");
        }
        
        System.out.println(lista.toString());

        lista.borrarNodo(1);
        lista.borrarNodo(10);
        lista.borrarNodo(100);
        System.out.println(lista.toString());


        // Ejemplo de uso de lista desordenada
        ListaEnlazadaSencillaDesordenada lista2 = new ListaEnlazadaSencillaDesordenada();
        lista2.setPermitirDuplicados(false);
        lista2.añadir(20);
        lista2.añadir(10);
        lista2.añadir(10);
        lista2.añadir(30);
        System.out.println(lista2.toString());
        lista2.borrar(30);
        System.out.println(lista2.toString());

        // Ejemplo de lista ordenada
        ListaEnlazadaSencillaOrdenada lista3 = new ListaEnlazadaSencillaOrdenada();

        lista3.setPermitirDuplicados(true);
        
        int min = 100;
        int max = 300;
        for(int i = 0; i < 10 ; i++) {
            int aleatorio = (int)(Math.random() * (max - min) ) + min;
            lista3.añadir(aleatorio);
        }

        System.out.println(lista3.toString());

        lista3.borrar(200);

         if(lista3.buscar(250) == null) {
            System.out.println("250 No encontrado");
        } else {
            System.out.println("250 Encontrado");
        }

        System.out.println(lista3.toString());


    }

}

