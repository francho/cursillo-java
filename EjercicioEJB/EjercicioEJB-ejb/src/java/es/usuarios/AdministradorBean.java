/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.usuarios;

import javax.ejb.Stateless;

/**
 *
 * @author Administrador
 */
@Stateless
public class AdministradorBean implements AdministradorRemote, AdministradorLocal {

    public boolean validarUsuario(String nombre, String passwword) {
        return nombre.equals("admin");
    }

    public void añadirUsuario(String nombre, String password) {
    }
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method" or "Web Service > Add Operation")
 
}
