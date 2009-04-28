/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ejemplojdbc;

/**
 *
 * @author AdminLocal
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GestorBD gestor = new GestorBD();
        gestor.insertarDatos(25, 2);
        gestor.obtenerDatos();

    }

}
