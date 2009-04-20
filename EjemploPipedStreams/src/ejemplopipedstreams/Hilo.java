/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ejemplopipedstreams;

import java.io.PipedReader;
import java.io.PipedWriter;
import java.util.Scanner;

/**
 *
 * @author: $Author$
 * @version: $Rev$
 * @date: $Date$
 * $Id$
 */
public class Hilo extends Thread{


    public PipedReader hiloEntrada;
    public PipedWriter hiloSalida;

    public Hilo(PipedReader entrada, PipedWriter salida) {
        hiloEntrada = entrada;
        hiloSalida = salida;
    }

    @Override
    public void run() {
        escuchar();
    }

    private void escuchar() {
        Scanner lector = new Scanner(hiloEntrada);
        System.out.println("El hilo se pone a la escucha");
        while(lector.hasNextLine()) {
            System.out.println(lector.next());
        }
        System.out.println("Ya no hay mas datos");

    }

}
