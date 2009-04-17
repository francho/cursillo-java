/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ejercicioleerficherothreads;

import java.lang.Thread.State;

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
        LeerFicheroThread t = new LeerFicheroThread("datos.txt");
        t.run();

        do {
            System.out.println("Proceso principal esperando...");
            t.join(5000);
        } while(t.getState() != State.TERMINATED);
    }

}
