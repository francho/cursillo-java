/*
 * Crear una implementación sincronizada de un vector dinámico
 *
 * Métodos:
 *  - añadir(elemento)
 *  - añadirEn(elemento, posicion)
 *  - borrar(elemento)
 *  - borrar(posicion)
 */

package ejerciciovectordinamico;

/**
 *
 * @author: $Author$
 * @version: $Rev$
 * @date: $Date$
 * $Id$
 */
public class Main {
    public static final int HILOS = 10;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        VectorDinamicoSincronizado vector = new VectorDinamicoSincronizado();

        for(int i=0; i< HILOS; i++) {
            TestVectorDinamicoRunnable r = new TestVectorDinamicoRunnable(vector);
            Thread t = new Thread(r);
            t.start();
        }

        System.out.println("Hilo principal terminado");

    }

}
