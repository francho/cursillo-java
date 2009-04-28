/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ejemplojdbc;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.derby.client.am.Connection;
import org.apache.derby.client.am.ResultSet;
import org.apache.derby.client.am.Statement;

/**
 *
 * @author AdminLocal
 */
public class GestorBD {

    Connection conexion;

    public GestorBD()
    {
        try
        {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            DriverManager.registerDriver(new org.apache.derby.jdbc.ClientDriver());
        } catch (SQLException ex)
        {
            Logger.getLogger(GestorBD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex)
        {
            Logger.getLogger(GestorBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        crearConexion();
        System.out.println("Conexion Establecida");
    }

    public void crearConexion()
    {
        try
        {
            conexion = (Connection) DriverManager.getConnection("jdbc:derby://localhost:1527/Prueba", "ernesto", "ernesto");
        } catch (SQLException ex)
        {
            Logger.getLogger(GestorBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void obtenerDatos()
    {
        try
        {
            Statement orden = (Statement) conexion.createStatement();
            ResultSet rs = (ResultSet) orden.executeQuery("Select * from tabla1");
            while(rs.next())
            {
                System.out.println("Nombre: " + rs.getInt("Nombre") + "\r\n");
                System.out.println("ID: " + rs.getInt("ID") + "\r\n");
            }
            orden.close();
        } catch (SQLException ex)
        {
            Logger.getLogger(GestorBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void insertarDatos(int nombre, int id)
    {
        try
        {
            Statement orden = (Statement) conexion.createStatement();
            String cadena = "Insert into tabla1 (Nombre,ID) values(" + nombre + "," + id + ")";
            int filas = orden.executeUpdate(cadena);
            System.out.println("Inserción de datos realizada.");
            System.out.println(filas + " fila(s) afectada(s).");
        } catch (SQLException ex)
        {
            Logger.getLogger(GestorBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
