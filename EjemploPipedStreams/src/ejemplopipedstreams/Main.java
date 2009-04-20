/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ejemplopipedstreams;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

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

    private static PipedWriter flujoSalida;
        // Al crear el de entrada le paso el flujo anterior para enlazarlos
    private static PipedReader flujoEntrada;

    public static void main(String[] args) throws IOException, InterruptedException {
        flujoSalida = new PipedWriter();
        flujoEntrada = new PipedReader(flujoSalida);

        Hilo unHilo = new Hilo(flujoEntrada,null);
        unHilo.start();
        System.out.println("Hilo lanzado");
        Thread.sleep(5000);

        mandarDatos();
    }

    static void mandarDatos() throws IOException
    {
        flujoSalida.write("hola Mundo");
        flujoSalida.flush();
        flujoSalida.close();
        System.out.println("Fin del programa principal");
    }

}
