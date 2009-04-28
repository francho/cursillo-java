/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ejerciciodbempleados;

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
        EmpleadosBD db = new EmpleadosBD();

        db.crearConexion();

        db.insertarEmpleado("Pepe Lopez", 10);

        db.actualizarEmpleado(1, "Mr Potato", 3);

    }

}
