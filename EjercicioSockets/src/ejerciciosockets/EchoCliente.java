/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ejerciciosockets;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author: $Author$
 * @version: $Rev$
 * @date: $Date$
 * $Id$
 */
public class EchoCliente {
    static final String servidor = "127.0.0.1";
    static final int puerto = 8189;
    int debug = 0;
    public EchoCliente() {

        try {
            // Establecemos la conexion con el servidor
            Socket conexion = new Socket(servidor, puerto);
            mDebug("Conectado con el servidor");

            // Creamos los flujos para comunicarnos con el servidor
            // IMPORTANTE:
            // debemos crearlos en el orden que marca el servidor
            // Si el servidor primero crea el de lectura, nosotros crearemos primero el de escritura

            PrintWriter escritorRemoto = new PrintWriter(conexion.getOutputStream());
            Scanner lectorRemoto = new Scanner(conexion.getInputStream());

            // El flujo para capturar lo que el usuario escribe
            Scanner lector = new Scanner(System.in);

            // Mostramos el mensaje de bienvenida del servidor
            System.out.println(lectorRemoto.nextLine());

            String texto ="";
            while(! texto.equals("BYE")) {
                mDebug("--- usuario teclea ---");
                System.out.print("> ");
                texto = lector.nextLine();
                escritorRemoto.println(texto);
                escritorRemoto.flush();

                mDebug("--- servidor responde ---");
                System.out.println(lectorRemoto.nextLine());
                
            }
            
            conexion.close();
            mDebug("Cerrado socket");
        
        } catch (UnknownHostException ex) {
            Logger.getLogger(EchoCliente.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
            Logger.getLogger(EchoCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    

    private void mDebug(String string)
    {
        if(this.debug > 0) {
            System.out.println("DEBUG -- " + string);
        }
    }
}

