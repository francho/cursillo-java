/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciojodbc;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.derby.client.am.Connection;
import org.apache.derby.client.am.ResultSet;
import org.apache.derby.client.am.Statement;

/**
 *
 * @author: $Author$
 * @version: $Rev$
 * @date: $Date$
 * $Id$
 */
public class GestorBD
{

    Connection conexion;

    public GestorBD()
    {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            DriverManager.registerDriver(new org.apache.derby.jdbc.ClientDriver());
        } catch (SQLException ex) {
            Logger.getLogger(GestorBD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestorBD.class.getName()).log(Level.SEVERE, null, ex);
        }

        crearConexion();
        System.out.println("Conexion Establecida");
    }

    public void crearConexion()
    {
        try {
            conexion = (Connection) DriverManager.getConnection("jdbc:derby://localhost:1527/EjercicioJDBC", "usuario", "clave");
        } catch (SQLException ex) {
            Logger.getLogger(GestorBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void obtenerDatos()
    {
        try
        {
            Statement orden = (Statement) conexion.createStatement();
            ResultSet rs = (ResultSet) orden.executeQuery("SELECT * FROM tabla");
            while(rs.next())
            {
                System.out.println("ID: " + rs.getInt("ID"));
                System.out.println("Nombre: " + rs.getString("Nombre"));
                System.out.println("Telefono: " + rs.getString("Telefono"));
                System.out.println("-----------------------------");
            }
            rs.close();
            orden.close();
        } catch (SQLException ex)
        {
            Logger.getLogger(GestorBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void insertarDatos(String nombre, long telefono) {
        Statement orden;
        try {
            int id = siguienteId("tabla");
            // Ejecutamos el insert
            orden = (Statement) conexion.createStatement();
            String sql = "INSERT INTO tabla(id,nombre,telefono) VALUES (" + id + ",'" + nombre + "'," + telefono + ")" ;
            int afectadas = orden.executeUpdate(sql);
            System.out.println("Insert realizado, " + afectadas + " filas afectadas");
        } catch (SQLException ex) {
            Logger.getLogger(GestorBD.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public int siguienteId(String tabla) {
        int id = -1;
        try {
            Statement orden;
            // Calculamos el siguiente ID
            orden = (Statement) conexion.createStatement();
            ResultSet rs = (ResultSet) orden.executeQuery("select max(id) as id from " + tabla);

            while (rs.next()) {
                id = rs.getInt("id");
            }
            id++;
            rs.close();
            orden.close();

        } catch (SQLException ex) {
            Logger.getLogger(GestorBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }

}