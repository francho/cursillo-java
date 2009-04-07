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
        ListaEnlazada l = new ListaEnlazada(6);

        l.setPermitirRepeticiones(true);

        l.añadirNodo(2);
        l.añadirNodo(5);
        l.añadirNodo(2);
        l.añadirNodo(29);
        l.añadirNodo(4);


        if(l.buscarValor(5) == null) {
            System.out.println("No encontrado");
        } else {
            System.out.println("Encontrado");
        }
        
        System.out.println(l.toString());

        l.borrarNodo(2);
        System.out.println(l.toString());
    }

}
