/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciodbempleados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Vector;
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
    public void añadirEmpleado(String nombre, int idPuesto)
    {
        try {
            // Variables que vamos a usar intermanente
            int afectadas = 0;
            // vamos a usar transacciones
            conexion.setAutoCommit(false);
            Statement orden = (Statement) conexion.createStatement();

            int id = this.siguienteId("Empleados");

            afectadas = orden.executeUpdate(sqlInsertEmpleados(id, nombre, idPuesto));
            afectadas = orden.executeUpdate(sqlInsertRegistro(id, 0, idPuesto));
            conexion.commit();

            orden.close();

        } catch (SQLException ex) {
            try {
                conexion.rollback();
            } catch (SQLException ex1) {
                mostrarErrorDB(ex1);
            }
            mostrarErrorDB(ex);

        }
    }

    /**
     * Modifica un empleazo en la BD y guarda un registro con el movimiento
     *
     * @param idEmpleado identificador del empleado a modificar
     * @param nombreNuevo nombre del empleado
     * @param idPuestoNuevo nuevo puesto
     */
    public void modificarEmpleado(int idEmpleado, String nombreNuevo, int idPuestoNuevo)
    {
        try {
            // vamos a usar transacciones
            conexion.setAutoCommit(false);
            Statement orden = (Statement) conexion.createStatement();

            String sql;

            sql = "SELECT localizacion FROM empleados WHERE id=" + idEmpleado;

            ResultSet rs = (ResultSet) orden.executeQuery(sql);

            int idPuestoViejo = -1;
            while (rs.next()) {
                idPuestoViejo = rs.getInt("localizacion");
            }

            sql = "UPDATE empleados SET localizacion = " + idPuestoNuevo + ", nombre='" + nombreNuevo + "' WHERE(id = " + idEmpleado + ")";
            if (orden.executeUpdate(sql) > 0) {
                sql = "INSERT INTO Registro(IDempleado, IDOrigen, IDDestino) VALUES (" + idEmpleado + "," + idPuestoViejo + "," + idPuestoNuevo + ")";
                if (orden.executeUpdate(sql) > 0) {
                    conexion.commit();
                } else {
                    conexion.rollback();
                }
            } else {
                conexion.rollback();
            }

            orden.close();


        } catch (SQLException ex) {
            try {
                conexion.rollback();
            } catch (SQLException ex1) {
                mostrarErrorDB(ex1);
            }

            mostrarErrorDB(ex);

        }
    }

    /**
     * Importa una coleccion a nuestra base de datos
     *
     * @param empleados Vector con los empleados a importar
     */
    public void cargarEmpleados(Vector<Empleado> empleados)
    {
        try {
            String sql;

            conexion.setAutoCommit(false);
            Statement orden = (Statement) conexion.createStatement();
            Iterator<Empleado> itEmp = empleados.iterator();
            while (itEmp.hasNext()) {
                Empleado e = itEmp.next();

                sql = sqlInsertEmpleados(e.getId(), e.getNombre(), e.getLocalizacion());
                orden.addBatch(sql);

                sql = sqlInsertRegistro(e.getId(), 0, e.getLocalizacion());
                orden.addBatch(sql);
            }
            orden.executeBatch();
            conexion.commit();
        } catch (SQLException ex) {
            try {
                conexion.rollback();
            } catch (SQLException ex1) {
                mostrarErrorDB(ex1);
            }
            mostrarErrorDB(ex);
        }
    }

    /**
     * Muestra por la consola los detalles de una exceción SQL
     * @param ex excepcion derivada del error
     */
    public void mostrarErrorDB(SQLException ex)
    {
        System.out.println("-------------------------------------------------");
        System.out.println("              ¡¡¡ Error de BD !!!");
        System.out.println("-------------------------------------------------");

        while (ex != null) {
            System.out.println("Código: " + ex.getErrorCode());
            System.out.println("Detalles: " + ex.getMessage());
            System.out.println("Estado: " + ex.getSQLState());
            System.out.println("");

            //Logger.getLogger(EmpleadosBD.class.getName()).log(Level.SEVERE, null, ex);

            ex = ex.getNextException();
        }

        System.out.println("-------------------------------------------------");
    }

    /**
     * Dada una determinada tabla devuelve el siguiente ID disponible
     *
     * @param tabla sobre la que buscar un nuevo id
     *
     * @return el siguiente id
     */
    public int siguienteId(String tabla)
    {
        int id = -1;
        try {
            Statement orden;
            // Calculamos el siguiente ID
            orden = (Statement) conexion.createStatement();
            ResultSet rs = (ResultSet) orden.executeQuery("select max(id) as id from " + tabla);

            while (rs.next()) {
                id = rs.getInt("id");
            }
            // Añadimos 1 al último id
            id++;
            rs.close();
            orden.close();

        } catch (SQLException ex) {
            mostrarErrorDB(ex);
        }
        return id;
    }

    /**
     * Crea la estructura de la BBDD
     */
    public void crearDB()
    {
        Statement orden;

        try {
            orden = (Statement) conexion.createStatement();
            String sql = "CREATE TABLE empleados (" +
                    // "id INT NOT NULL GENERATED ALWAYS AS IDENTITY," +
                    "id INT NOT NULL," +
                    "nombre VARCHAR(50) NOT NULL," +
                    "localizacion INT, " +
                    "PRIMARY KEY(id) )";
            orden.executeUpdate(sql);

            sql = "CREATE TABLE puestos (" +
                    "id INT NOT NULL GENERATED ALWAYS AS IDENTITY," +
                    "pais VARCHAR(50)," +
                    "departamento VARCHAR(50)" +
                    ")";

            orden.executeUpdate(sql);

            conexion.setAutoCommit(false);
            orden.addBatch("INSERT INTO puestos(pais,departamento) VALUES('desconocido','desconocido')");
            orden.addBatch("INSERT INTO puestos(pais,departamento) VALUES('España','Dirección')");
            orden.addBatch("INSERT INTO puestos(pais,departamento) VALUES('España','Administración')");
            orden.addBatch("INSERT INTO puestos(pais,departamento) VALUES('España','Recepción')");
            orden.addBatch("INSERT INTO puestos(pais,departamento) VALUES('España','Contabilidad')");
            orden.addBatch("INSERT INTO puestos(pais,departamento) VALUES('España','Almacén')");
            orden.executeBatch();
            conexion.commit();
            conexion.setAutoCommit(true);

            sql = "CREATE TABLE registro (" +
                    "idempleado INT," +
                    "idorigen INT," +
                    "iddestino INT" +
                    ")";

            orden.executeUpdate(sql);

            orden.close();
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadosBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Genera la SQL de insercción de empleado
     *
     * @param id
     * @param nombre
     * @param idPuesto
     * @return SQL listo para ser pasado al SGBD
     */
    public String sqlInsertEmpleados(int id, String nombre, int idPuesto)
    {
        return "INSERT INTO Empleados(id,nombre,localizacion) VALUES(" + id + ",'" + nombre + "'," + idPuesto + ")";
    }

    /**
     * Genera la SQL de insercción de registro
     *
     * @param idEmpleado
     * @param idOrigen
     * @param idDestino
     * @return SQL listo para ser pasado a SGBD
     */
    public String sqlInsertRegistro(int idEmpleado, int idOrigen, int idDestino)
    {
        return "INSERT INTO Registro(IDempleado, IDOrigen, IDDestino) VALUES (" + idEmpleado + "," + idOrigen + "," + idDestino + ")";
    }
}
