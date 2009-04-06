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
        Lista l = new Lista();

        l.añadirElemento(1);
        l.añadirElemento(2);
        l.añadirElemento(3);

        System.out.println(l.toString());
    }

}
