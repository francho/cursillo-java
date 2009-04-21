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
public class Main
{

    public static final int HILOS = 8;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        VectorDinamicoSincronizado vector = new VectorDinamicoSincronizado();

        // Este array nos permitirá controlar los hilos que creemos
        //Thread[] manejador = new Thread[HILOS];

        // Creamos los hilos que intentarán modificar posiciones del vector con valores aleatorios
        for (int i = 0; i < HILOS; i++) {
            TestVectorDinamicoRunnable r = new TestVectorDinamicoRunnable(vector);
            Thread t = new Thread(r);
            t.start();
        //manejador[i] = new Thread(r);
        //manejador[i].start();
        }

        // Ahora llenamos el vector para que los hilos que puedan los sobreescriban
        for (int i = 0; i < HILOS; i++) {
            vector.añadir("-");
        }

        // Damos un tiempo para que los hilos intenten hacer su trabajo
        espera(5000);

        // Cerramos los hilos que quedan abiertos
        int numActivas = Thread.activeCount();
        Thread[] manejador = new Thread[numActivas];
        Thread.enumerate(manejador);
        for (Thread t : manejador) {
            if (t.isAlive()) {
                t.interrupt();
            }
        }

        System.out.println(vector);

        System.out.println("Hilo principal terminado");

    }

    public static void espera(int milisegundos)
    {

        long t0, t1;

        t0 = System.currentTimeMillis();
        do {
            t1 = System.currentTimeMillis();
        } while (t1 - t0 < milisegundos);
    }
}
