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
public class UsuarioBean implements UsuarioRemote, UsuarioLocal {

    public boolean validarUsuario(String nombre, String password) {
        return nombre.equals("usuario");
    }
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method" or "Web Service > Add Operation")
 
}
