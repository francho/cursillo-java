/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ejemplothreads;

import java.util.Date;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author: $Author$
 * @version: $Rev$
 * @date: $Date$
 * $Id$
 */
public class ClaseRunnable implements Runnable {
    int numeroHilo;
    /**
     * Define el tiempo de vida del hilo de ejecución (termnina cuando run termine)
     */

    public ClaseRunnable(int i) {
        numeroHilo = i;
    }

    public void run()
    {
        System.out.println("Hilo " + numeroHilo + " lanzado");
        Random r = new Random(new Date().getTime());
        try {
            // Creamos un tiempo ejecución del hilo aleatorio
            Thread.sleep(r.nextInt(100)*100);
            System.out.println("Hilo " + numeroHilo + " terminado");
        } catch (InterruptedException ex) {
            Logger.getLogger(ClaseRunnable.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
