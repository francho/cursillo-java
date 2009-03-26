/* Prueba la clase pila LIFO
 *
 * Comprobaciones:
 * - Crear una pila de tamaño 10.
 * - Comprobar que está vacía.
 * - Apilar los números 23, -45, -12, 67, 1, 0, -43, 89.
 * - Desapilar tres elementos.
 * - Consultar la cima de la pila
 * - Apilar los números 564, -987, -10, 56, 1111.
 * - Comprobar que está llena.
 * - Mostrar su contenido.
 * - Apilar el número 666.
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
public class Main
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        Pila pila = new Pila(10);
        pila.mostrar();

        if (pila.estaVacia()) {
            System.out.println("La pila está vacía");
        } else {
            System.out.println("Queda espacio en la pila");
        }

        pila.apilar(23);
        pila.apilar(-45);
        pila.apilar(-12);
        pila.apilar(67);
        pila.apilar(1);
        pila.apilar(0);
        pila.apilar(-43);
        pila.apilar(89);

        pila.mostrar();

        System.out.println("Cima: " + pila.verCima());

        for (int x = 0; x < 3; x++) {
            pila.desapilar();
        }

        pila.mostrar();
        System.out.println("Cima: " + pila.verCima());

        pila.apilar(564);
        pila.apilar(-978);
        pila.apilar(-10);
        pila.apilar(56);
        pila.apilar(1111);

        if (pila.estaLlena()) {
            System.out.println("La pila está llena");
        } else {
            System.out.println("la pila tiene datos");
        }
        pila.mostrar();

        pila.apilar(666);

        pila.mostrar();
    }
}
