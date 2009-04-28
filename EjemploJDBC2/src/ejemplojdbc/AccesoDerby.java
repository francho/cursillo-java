/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplojdbc;

import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.DriverManager;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.derby.client.am.Connection;
import org.apache.derby.client.am.DatabaseMetaData;
import org.apache.derby.client.am.PreparedStatement;
import org.apache.derby.client.am.ResultSet;
import org.apache.derby.client.am.Savepoint;
import org.apache.derby.client.am.Statement;

/**
 *
 * @author AdminLocal
 */
public class AccesoDerby
{

    private Connection conexion;

    public void conectar()
    {
        String url = "jdbc:derby://localhost:1527/Prueba";
        String user = "ernesto";
        String password = "ernesto";
        conectar(url, user, password);
    }

    public void conectar(String url, String user, String password)
    {
        try
        {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            DriverManager.registerDriver(new org.apache.derby.jdbc.ClientDriver());
            conexion = (Connection) DriverManager.getConnection(url, user, password);
        }
        catch (SQLException ex)
        {
            Logger.getLogger(AccesoDerby.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (ClassNotFoundException ex)
        {
            Logger.getLogger(AccesoDerby.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void mostrarDatos()
    {
        String query = "Select * from elementos";
        mostrarDatos(query);
    }

    public void mostrarDatos(String peticion)
    {
        try
        {
            Statement st = (Statement) conexion.createStatement();
            st = (Statement) conexion.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = (ResultSet) st.executeQuery(peticion);
            while (rs.next())
            {
                String nombre = rs.getString("nombre");
                int id = rs.getInt(1);
                nombre = rs.getString("nombre");
                System.out.println("Nombre: " + nombre + " con ID: " + id);
            }
        }
        catch (SQLException ex)
        {
            Logger.getLogger(AccesoDerby.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void estructuraTabla(String peticion)
    {
        try
        {
            Statement orden = (Statement) conexion.createStatement();
            ResultSet resultado = (ResultSet) orden.executeQuery(peticion);
            ResultSetMetaData metadatos = resultado.getMetaData();
            int col = metadatos.getColumnCount();
            for (int i = 1; i <= col; i++)
            {
                System.out.println();
                System.out.print(metadatos.getColumnLabel(i) + "\t\t");
                System.out.print(metadatos.getColumnClassName(i) + "\t\t");
                System.out.print(metadatos.getColumnName(i) + "\t\t");
                System.out.print(metadatos.getColumnType(i) + "\t\t");
                System.out.print(metadatos.getColumnTypeName(i) + "\t\t");
            }
            System.out.println();
        }
        catch (SQLException ex)
        {
            Logger.getLogger(AccesoDerby.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void analizarTabla()
    {
        String peticion = "Select * from tabla1 order by id";
        analizarTabla(peticion);
    }

    private ArrayList<Columna> analizarMetadata(ResultSetMetaData metadatos)
    {
        ArrayList<Columna> columnas = new ArrayList<Columna>();
        try
        {
            int numColumnas = metadatos.getColumnCount();
            Columna c = null;
            for (int i = 1; i <= numColumnas; i++)
            {
                c = new Columna();
                c.setNombre(metadatos.getColumnLabel(i));
                c.setTipo(metadatos.getColumnType(i));
                columnas.add(c);
            }
        }
        catch (SQLException ex)
        {
            Logger.getLogger(AccesoDerby.class.getName()).log(Level.SEVERE, null, ex);
        }
        return columnas;
    }

    public void mostrarDatos(ArrayList<Columna> columnas, String peticion)
    {
        try
        {
            Statement st = (Statement) conexion.createStatement();
            ResultSet rs = (ResultSet) st.executeQuery(peticion);
            while (rs.next())
            {
                for (Columna c : columnas)
                {
                    switch (c.getTipo())
                    {
                        case java.sql.Types.ARRAY:
                            System.out.print(rs.getInt(c.getNombre()) + "\t\t");
                            break;
                        case java.sql.Types.BIGINT:
                            System.out.print(rs.getLong(c.getNombre()) + "\t\t");
                            break;
                        case java.sql.Types.INTEGER:
                            System.out.print(rs.getInt(c.getNombre()) + "\t\t\t");
                            break;
                        case java.sql.Types.REAL:
                            System.out.print(rs.getFloat(c.getNombre()) + "\t\t\t");
                            break;
                        case java.sql.Types.FLOAT:
                            System.out.print(rs.getDouble(c.getNombre()) + "\t\t\t");
                            break;
                        case java.sql.Types.DECIMAL:
                            System.out.print(rs.getBigDecimal(c.getNombre()) + "\t\t\t");
                            break;
                        case java.sql.Types.BIT:
                            System.out.print(rs.getBoolean(c.getNombre()) + "\t\t\t");
                            break;
                        case java.sql.Types.BOOLEAN:
                            System.out.print(rs.getBoolean(c.getNombre()) + "\t\t\t");
                            break;
                        case java.sql.Types.VARCHAR:
                            System.out.print(rs.getString(c.getNombre()) + "\t\t");
                            break;
                        case java.sql.Types.LONGVARCHAR:
                            System.out.print(rs.getString(c.getNombre()) + "\t\t");
                            break;
                        case java.sql.Types.CHAR:
                            System.out.print(rs.getString(c.getNombre()) + "\t\t");
                            break;
                        case java.sql.Types.DATE:
                            System.out.print(rs.getDate(c.getNombre()) + "\t\t");
                            break;
                        case java.sql.Types.TIME:
                            System.out.print(rs.getTime(c.getNombre()) + "\t\t");
                            break;
                        case java.sql.Types.TIMESTAMP:
                            System.out.print(rs.getTimestamp(c.getNombre()) + "\t\t");
                            break;
                        case java.sql.Types.OTHER:
                            System.out.print(rs.getObject(c.getNombre()) + "\t\t");
                            break;
                        case java.sql.Types.JAVA_OBJECT:
                            System.out.print(rs.getObject(c.getNombre()) + "\t\t");
                            break;
                        case java.sql.Types.TINYINT:
                            System.out.print(rs.getShort(c.getNombre()) + "\t\t");
                            break;
                        default:
                            break;
                    }
                }
                System.out.println();
            }
        }
        catch (SQLException ex)
        {
            Logger.getLogger(AccesoDerby.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void analizarTabla(String peticion)
    {
        try
        {
            Statement st = (Statement) conexion.createStatement();
            ResultSet rs = (ResultSet) st.executeQuery(peticion);
            ResultSetMetaData metadatos = rs.getMetaData();
            String peticionMin = peticion.toLowerCase();
            int posicionFrom = peticionMin.indexOf("from");
            int posicionFinal = peticionMin.indexOf(" ", posicionFrom + 6);
            String tabla = "";
            if (posicionFinal == -1)
            {
                tabla = peticion.substring(posicionFrom + 5);
            }
            else
            {
                tabla = peticion.substring(posicionFrom + 5, posicionFinal);
            }
            ArrayList<Columna> columnas = null;
            columnas = analizarMetadata(metadatos);
            estructuraTabla(peticion);
            mostrarDatos(columnas, peticion);
        }
        catch (SQLException ex)
        {
            Logger.getLogger(AccesoDerby.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void mostrarDataBaseMetaData()
    {
        try
        {
            DatabaseMetaData metadatosBD;
            metadatosBD = (DatabaseMetaData) conexion.getMetaData();
            System.out.println("DBMS: " + metadatosBD.getDatabaseProductName());
            System.out.println("DBMS Version: " + metadatosBD.getDatabaseProductVersion());
            System.out.println("DBMS Major Version: " + metadatosBD.getDatabaseMajorVersion());
            System.out.println("DBMS Minor Version: " + metadatosBD.getDatabaseMinorVersion());
            System.out.println("Soporte de Transacciones: " + metadatosBD.supportsTransactions());
            System.out.println("Soporte del Niveles de Aislamiento de Transacciones 'TRANSACTION_NONE': " + metadatosBD.supportsTransactionIsolationLevel(java.sql.Connection.TRANSACTION_NONE));
            System.out.println("Soporte del Niveles de Aislamiento de Transacciones 'TRANSACTION_READ_COMMITTED': " + metadatosBD.supportsTransactionIsolationLevel(java.sql.Connection.TRANSACTION_READ_COMMITTED));
            System.out.println("Soporte del Niveles de Aislamiento de Transacciones 'TRANSACTION_READ_UNCOMMITTED': " + metadatosBD.supportsTransactionIsolationLevel(java.sql.Connection.TRANSACTION_READ_UNCOMMITTED));
            System.out.println("Soporte del Niveles de Aislamiento de Transacciones 'TRANSACTION_REPEATABLE_READ': " + metadatosBD.supportsTransactionIsolationLevel(java.sql.Connection.TRANSACTION_REPEATABLE_READ));
            System.out.println("Soporte del Niveles de Aislamiento de Transacciones 'TRANSACTION_SERIALIZABLE': " + metadatosBD.supportsTransactionIsolationLevel(java.sql.Connection.TRANSACTION_SERIALIZABLE));
            System.out.println("Soporte de Savepoints: " + metadatosBD.supportsSavepoints());
            System.out.println("Soporte de Batch Updates: " + metadatosBD.supportsBatchUpdates());
            System.out.println("Soporte de Procedimientos Almacenados: " + metadatosBD.supportsStoredProcedures());
            System.out.println("Driver: " + metadatosBD.getDriverName());
            System.out.println("Driver Version: " + metadatosBD.getDriverVersion());
            System.out.println("Driver Major Version: " + metadatosBD.getDriverMajorVersion());
            System.out.println("Driver Minor Version: " + metadatosBD.getDriverMinorVersion());
            System.out.println("Soporte de JDBC: " + metadatosBD.getJDBCMajorVersion());
            System.out.println("Soporte de JDBC: " + metadatosBD.getJDBCMinorVersion());
            System.out.println("Dirección de la BBDD: " + metadatosBD.getURL());
            System.out.println("Nombre del Usuario: " + metadatosBD.getUserName());
            ResultSet rs = (ResultSet) metadatosBD.getTables(null, null, null, new String[]{"TABLE"});
            ResultSetMetaData metadatos = rs.getMetaData();
            System.out.println("Lista de las tablas:");
            while (rs.next())
            {
                System.out.println("\tNombre de la Tabla: " + rs.getString("TABLE_NAME"));
            }
        }
        catch (SQLException ex)
        {
            Logger.getLogger(AccesoDerby.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

        public void procedimientoAlmacenado() {
        try {
            /** Creating Statement*/
            CallableStatement call = conexion.prepareCall("call proceduretest.get_nombre(?)");
            call.setInt(1, 2);
            call.execute();
            ResultSet rs=(ResultSet) call.getResultSet();
            //call.executeUpdate();
            System.out.println("The addition is " + call.getInt(3));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    public void limpiarTabla()
    {
        try
        {
            Statement st = (Statement) conexion.createStatement();
            st.executeUpdate("delete from elementos where id_elemento>9");
        }
        catch (SQLException ex)
        {
            Logger.getLogger(AccesoDerby.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void ejecutarProcedimientoPreparado(Object[][] lista)
    {

        try
        {
            PreparedStatement ordenPreparada = (PreparedStatement) conexion.prepareStatement("INSERT INTO elementos values (?,?) ");
            for (int i = 0; i < lista.length; i++)
            {
                ordenPreparada.setInt(1, (Integer) (lista[i][0]));
                ordenPreparada.setString(2, (String) (lista[i][1]));
                int filasAfectada = ordenPreparada.executeUpdate();
            }
        }
        catch (SQLException ex)
        {
            Logger.getLogger(AccesoDerby.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void establecerSavePoints()
    {
        Statement orden = null;
        try
        {
            // desactivamos el método de autoentrega.
            conexion.setAutoCommit(false);
            orden = (Statement) conexion.createStatement();
            int i = 10;
            // Insertamos tres registros en la tabla de usuarios
            orden.executeUpdate("INSERT INTO elementos  VALUES (" + i + ",'Alarico')");
            i++;
            orden.executeUpdate("INSERT INTO elementos  VALUES (" + i + ",'Alarico')");
            i++;
            orden.executeUpdate("INSERT INTO elementos  VALUES (" + i + ",'Alarico')");
            i++;
            // Creamos un punto de salvaguarda en este momento.
            Savepoint sp = (Savepoint) conexion.setSavepoint("PUNTO1");
            // Insertamos tres registros mas en la tabla de usuarios
            orden.executeUpdate("INSERT INTO elementos  VALUES (" + i + ",'Witerico')");
            i++;
            orden.executeUpdate("INSERT INTO elementos  VALUES (" + i + ",'Witerico')");
            i++;
            orden.executeUpdate("INSERT INTO elementos  VALUES (" + i + ",'Witerico')");
            i++;
            // Hacemos un rollback al punto PUNTO1:
            conexion.rollback(sp);
            // Entregamos los cambios anteriores a punto1 a la BBDD:
            // Insertamos tres registros mas en la tabla de usuarios
            orden.executeUpdate("INSERT INTO elementos  VALUES (" + i + ",'Chindasvinta')");
            i++;
            orden.executeUpdate("INSERT INTO elementos  VALUES (" + i + ",'Chindasvinta')");
            i++;
            orden.executeUpdate("INSERT INTO elementos  VALUES (" + i + ",'Chindasvinta')");
            i++;
            conexion.releaseSavepoint(sp);
            conexion.commit();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (orden != null)
            {
                try
                {
                    orden.close();
                }
                catch (SQLException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }

    public void ejecutarTransaccion()
    {
        int estado = -1;

        try
        {
            estado = conexion.getTransactionIsolation();
            conexion.setAutoCommit(false);
            System.out.println("Nivel de aislamiento: " + estado);
            if (!(estado == java.sql.Connection.TRANSACTION_SERIALIZABLE))
            {
                conexion.setTransactionIsolation(java.sql.Connection.TRANSACTION_SERIALIZABLE);
            }
            System.out.println("Nivel de aislamiento: " + conexion.getTransactionIsolation());
            for (int i = 1; i < 4; i++)
            {
                Statement st = (Statement) conexion.createStatement();
                st.executeUpdate("insert into elementos (id_elemento,nombre) values (" + i + ",'Steve')");
            }
            conexion.commit();
        }
        catch (Exception ex)
        {
            try
            {
                conexion.rollback();
                Logger.getLogger(AccesoDerby.class.getName()).log(Level.SEVERE, null, ex);
            }
            catch (SQLException ex1)
            {
                Logger.getLogger(AccesoDerby.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        finally
        {
            try
            {
                if (estado != -1)
                {
                    conexion.setTransactionIsolation(estado);
                }
                conexion.setAutoCommit(true);
            }
            catch (SQLException e)
            {
                System.out.println("Error al realizar las operaciones finales");
            }
        }
        System.out.println("Nivel de aislamiento: " + estado);
    }

    public void ejecutarLote()
    {
        int estado = -1;

        try
        {
            estado = conexion.getTransactionIsolation();
            conexion.setAutoCommit(false);
            System.out.println("Nivel de aislamiento: " + estado);
            if (!(estado == java.sql.Connection.TRANSACTION_SERIALIZABLE))
            {
                conexion.setTransactionIsolation(java.sql.Connection.TRANSACTION_SERIALIZABLE);
            }
            System.out.println("Nivel de aislamiento: " + conexion.getTransactionIsolation());
            Statement st = (Statement) conexion.createStatement();
            st.addBatch("update elementos set nombre='Joe' where nombre='JoeBis'");
            st.addBatch("update elementos set nombre='Mat' where nombre='MatBis'");
            st.addBatch("update elementos set nombre='Steve' where nombre='SteveBis'");
            int[] filasAfectadas = st.executeBatch();
            for (int i = 0; i < filasAfectadas.length; i++)
            {
                System.out.println("Filas afectadas por la operacion número " + i + ": " + filasAfectadas[i]);
            }
            conexion.commit();
        }
        catch (Exception ex)
        {
            try
            {
                conexion.rollback();
                Logger.getLogger(AccesoDerby.class.getName()).log(Level.SEVERE, null, ex);
            }
            catch (SQLException ex1)
            {
                Logger.getLogger(AccesoDerby.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        finally
        {
            try
            {
                if (estado != -1)
                {
                    conexion.setTransactionIsolation(estado);
                }
                conexion.setAutoCommit(true);
            }
            catch (SQLException e)
            {
                System.out.println("Error al realizar las operaciones finales");
            }
        }
        System.out.println("Nivel de aislamiento: " + estado);
    }

    class Columna implements Serializable
    {

        private String nombre;
        private int tipo;

        public Columna()
        {
            nombre = "";
            tipo = 0;
        }

        public Columna(String nombre, int tipo)
        {
            this.nombre = nombre;
            this.tipo = tipo;
        }

        public String getNombre()
        {
            return nombre;
        }

        public void setNombre(String nombre)
        {
            this.nombre = nombre;
        }

        public int getTipo()
        {
            return tipo;
        }

        public void setTipo(int tipo)
        {
            this.tipo = tipo;
        }
    }
}
