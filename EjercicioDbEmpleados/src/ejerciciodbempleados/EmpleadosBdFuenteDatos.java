/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciodbempleados;

import java.sql.SQLException;
import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.apache.derby.jdbc.ClientDataSource;

/**
 *
 * @author: $Author$
 * @version: $Rev$
 * @date: $Date$
 * $Id$
 */
public class EmpleadosBdFuenteDatos extends EmpleadosBd
{

    public EmpleadosBdFuenteDatos()
    {
        super();
    }

    /**
     * Esta clase utiliza una fuente de datos para conectar
     * 
     */
    @Override
    public void crearConexion()
    {
        try {
            // Necesitamos montar el contexto JNDI para poder
            // interactuar con el proveedor de servicio correcto, en
            // este caso, el sistema de ficheros.
            Hashtable env = new Hashtable();
            env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.fscontext.RefFSContextFactory");

            
            Context ctx = new InitialContext(env);
            // Dado el contecto JNDI, buscamos nuestro DataSource
            ClientDataSource ds = (ClientDataSource) ctx.lookup("jdbc/empleados");
            
            try {
                // Ahora obtenemos una conexión con la B.B.D.D. y
                // procedemos a realizar nuestro trabajo
                conexion = ds.getConnection();
                System.out.println("Conexion establecida.");
            } catch (SQLException ex) {
                Logger.getLogger(EmpleadosBdFuenteDatos.class.getName()).log(Level.SEVERE, null, ex);
            }            
            //con.close();


        } catch (NamingException ex) {
            Logger.getLogger(EmpleadosBdFuenteDatos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    
}
