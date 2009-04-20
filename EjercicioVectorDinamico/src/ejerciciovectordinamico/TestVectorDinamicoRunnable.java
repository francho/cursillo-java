/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ejerciciovectordinamico;

/**
 *
 * @author: $Author$
 * @version: $Rev$
 * @date: $Date$
 * $Id$
 */
public class TestVectorDinamicoRunnable implements Runnable {

    VectorDinamicoSincronizado vector;
    
    public TestVectorDinamicoRunnable(VectorDinamicoSincronizado vector) {
        this.vector = vector;
    }

    public void run()
    {
        int num = (int) (Math.random() * 10);
        int pos;
        do {
            pos = (int) (Math.random() * 10) - 1;
        } while(pos < 0);

        vector.añadirEn(""+num, pos);

        //        vector.borrar((int)Math.random());
        System.out.println(Thread.currentThread() + ": " + vector.toString());
    }
}
