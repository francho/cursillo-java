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
        int num = (int) (Math.random() * 100);
        vector.añadir(num);
        vector.borrar((int)Math.random());
        System.out.println(Thread.currentThread() + ": " + vector.toString());
    }

}
