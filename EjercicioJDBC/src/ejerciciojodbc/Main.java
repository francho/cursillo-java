/*
 * Crear una tabla con las siguientes caracteristicas:
 *  - Nombre (String)
 *  - ID (int)
 *  - Telefono (long)
 *
 * Crear los métodos adecuadsos para recuperar los valores de la tabla y mostrar los datos por pantalla
 * y para introducir datos
 *
 */

package ejerciciojodbc;

import java.util.Scanner;

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
        GestorBD db = new GestorBD();

        db.crearConexion();
        db.obtenerDatos();

        Scanner flujo = new Scanner(System.in);

        System.out.print("Nombre: ");
        String nombre = flujo.nextLine();

        System.out.print("Telefono: ");
        long telefono = new Long(flujo.nextLine());


        db.insertarDatos(nombre, telefono);
    }

}
