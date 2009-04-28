/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciodbempleados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.derby.client.am.ResultSet;
import org.apache.derby.client.am.Statement;

/**
 *
 * @author: $Author$
 * @version: $Rev$
 * @date: $Date$
 * $Id$
 */
public class EmpleadosBD
{
    Connection conexion;

    public EmpleadosBD()
    {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            DriverManager.registerDriver(new org.apache.derby.jdbc.ClientDriver());
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadosBD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EmpleadosBD.class.getName()).log(Level.SEVERE, null, ex);
        }

        crearConexion();
        System.out.println("Conexion Establecida");
    }

    /**
     * Conecta con la BD del ejercicio
     */
    public void crearConexion()
    {
        try {
            conexion = (Connection) DriverManager.getConnection("jdbc:derby://localhost:1527/empleados", "usuario", "clave");
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadosBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Inserta un nuevo empleado en la BD
     *
     * @param nombre del empleado
     * @param idPuesto identificador del puesto donde va a estar
     */
    public void insertarEmpleado(String nombre, int idPuesto) {
        try {
            // Variables que vamos a usar intermanente
            String sql;
            int afectadas;
            // vamos a usar transacciones
            conexion.setAutoCommit(false);
            Statement orden = (Statement) conexion.createStatement();

            int id = siguienteId("empleados");
            sql = "INSERT INTO Empleados(ID,nombre,puesto) VALUES("+ id +",'"+ nombre +"'," + idPuesto + ")";
            afectadas = orden.executeUpdate(sql);

            if(afectadas != 1) {
                conexion.rollback();
            } else {
                sql = "INSERT INTO Registro(IDempleado, IDOrigen, IDDestino) VALUES (" + id + "," + 0 + "," + idPuesto + ")";

                afectadas =  orden.executeUpdate(sql);

                if(afectadas != 1) {
                    conexion.rollback();
                } else {
                    conexion.commit();
                }
            }

            orden.close();

        } catch (SQLException ex) {
            Logger.getLogger(EmpleadosBD.class.getName()).log(Level.SEVERE, null, ex);
            try {
                conexion.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(EmpleadosBD.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }


    }

    public void actualizarEmpleado(int idEmpleado, String nombre, int idPuestoNuevo) {
        try {
            // vamos a usar transacciones
            conexion.setAutoCommit(false);
            Statement orden = (Statement) conexion.createStatement();

            String sql;

            sql = "SELECT puesto FROM empleados WHERE id="+idEmpleado;

            ResultSet rs = (ResultSet) orden.executeQuery(sql);

            int idPuestoViejo = -1;
            while(rs.next()) {
                idPuestoViejo = rs.getInt("puesto");
            }

            sql = "UPDATE empleados SET puesto = " + idPuestoNuevo + ", nombre='"+ nombre +"' WHERE(id = " + idEmpleado + ")";
            if(orden.executeUpdate(sql) > 0 ) {
                sql = "INSERT INTO Registro(IDempleado, IDOrigen, IDDestino) VALUES (" + idEmpleado + "," + idPuestoViejo + "," + idPuestoNuevo + ")";
                if(orden.executeUpdate(sql) > 0) {
                    conexion.commit();
                } else {
                    conexion.rollback();
                }
            } else {
                conexion.rollback();
            }

            orden.close();


        } catch (SQLException ex) {
            Logger.getLogger(EmpleadosBD.class.getName()).log(Level.SEVERE, null, ex);
            try {
                conexion.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(EmpleadosBD.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }

    /**
     * Dada una determinada tabla devuelve el siguiente ID disponible
     *
     * @param tabla sobre la que buscar un nuevo id
     *
     * @return el siguiente id
     */
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
            Logger.getLogger(EmpleadosBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }

    public void crearDB() {
        String sql = "CREATE TABLE empleados )" +
                "id INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 5 INCREMENT BY 1)," +
                "nombre VARCHAR(50) NOT NULL," +
                "puesto INT" +
                ") " +
                "PRIMARY KEY (ID) ";

        /*
         * puestos ( id, pais, puesto)
         * registro( idusuario, idviejo, id nuevo)
         *
         */



    }

}
