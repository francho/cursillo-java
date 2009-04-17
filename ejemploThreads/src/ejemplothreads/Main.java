/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ejemplothreads;

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
    public static void main(String[] args) throws InterruptedException {
        //pruebaThreadPorInterfaz();
        
        

        // Ejemplo de ejecucion usando clase que extiende a Thread
        for(int i=0; i<10; i++) {
            ClaseThread t = new ClaseThread(i);
            t.start();
            t.join(5000); // El jilo espera hasta que termina el o pasan 5 segundos
        }


        System.out.println("Termina el hilo principal");
    }

    public static void pruebaThreadPorInterfaz() {
        // Ejemplo usando clase que implementa interfaz
        for(int i=0; i<10; i++) {
            Thread t = new Thread(new ClaseRunnable(i));
            t.start();
        }
    }

}
