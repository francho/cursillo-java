/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ejercicioejb;

import es.usuarios.AdministradorRemote;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Administrador
 */
public class App extends ModoTexto {

    @Override
    public void setOpcionesMenu() {
        opcionesMenu = new String[3];
        opcionesMenu[0] = "Salir";
        opcionesMenu[1] = "Como Admin";
        opcionesMenu[2] = "Como Usuario";

    }

    @Override
    public void ejecutaOpcion(int numOpcion) {
        switch(numOpcion) {
            case 0:
                setTerminar(true);
                break;
            case 1: // admin - validar usaurio
                AdministradorRemote adminBean = lookupAdministradorBean();
                String nombre = this.pregunta("Nombre: ");
                String password = this.pregunta("Clave");
                if(adminBean.validarUsuario(nombre, password)) {
                    _("Es admin");
                } else {
                    _("No es admin");
                }
                break;
            case 2:
                break;
        }
    }

    private AdministradorRemote lookupAdministradorBean() {
        try {
            Context c = new InitialContext();
            return (AdministradorRemote) c.lookup("java:comp/env/AdministradorBean");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }


}
