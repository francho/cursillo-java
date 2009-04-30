/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciodbempleados;

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
public class UtilesContexto
{

    String servidor = "localhost";
    int puerto;
    String basedatos = "";
    String usuario = "";
    String clave = "";
    String nombreContexto = "";

    /**
     * Crea le contexto para nuestra fuente de datos
     */
    public UtilesContexto(String servidor, int puerto, String basedatos, String usuario, String clave, String nombreContexto)
    {
        this.servidor = servidor;
        this.puerto = puerto;
        this.basedatos = basedatos;
        this.usuario = usuario;
        this.clave = clave;
        this.nombreContexto = nombreContexto;
        

    }

    public void crearContexto()
    {
        try {
            // Para utilizar los parámetros, necesitamos crear y poblar
            // un Hashtable.
            Hashtable env = new Hashtable();

            env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.fscontext.RefFSContextFactory");
            // Creamos el contexto inicial
            Context ctx = new InitialContext(env);
            // Aquí creamos el DataSource y asignamos los parámetros
            // relevantes

            ClientDataSource ds = new ClientDataSource();
            ds.setServerName(servidor);
            ds.setDatabaseName(basedatos);
            ds.setPortNumber(puerto);
            ds.setUser(usuario);
            ds.setPassword(clave);
            ds.setDescription("JDBC DataSource Connection");
            // Ahora enlazamos el objeto DataSource al nombre
            // que hemos seleccionado anteriormente
            ctx.rebind(nombreContexto, ds);

            ctx.close();
        } catch (NamingException ex) {
            Logger.getLogger(UtilesContexto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
