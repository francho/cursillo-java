/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ejerciciodbempleados;

import java.util.Vector;

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
        //db.crearDB();

        db.añadirEmpleado("Pepe Lopez", 10);

        db.modificarEmpleado(1, "Mr Potato", 3);

        Vector<Empleado> empleados = new Vector<Empleado>();
        empleados.add( new Empleado(10, "Mr T", 2) );
        empleados.add( new Empleado(11, "Ross Mary", 2) );
        empleados.add( new Empleado(12, "M.A.", 4) );

        db.cargarEmpleados(empleados);

    }

}
