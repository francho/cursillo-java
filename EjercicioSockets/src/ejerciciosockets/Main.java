/**
 * Escribir un cliente para Echo server y ThreadedEchoServer (corriendo en localhost)
 * Modificar EchoServer y SocketTest para utilizar un mensaje complejo:
 *  - Clase mensaje (serializable):
 *      - Nombre usuario
 *      - Contenido
 *  - Modificar los flujos para que usen
 *      - ObjectInputStream
 *      - OnjectOutputStream
 */

package ejerciciosockets;

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
    public static void main(String[] args) {
        EchoCliente cli = new EchoCliente();
    }

}
