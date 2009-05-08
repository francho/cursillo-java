/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.usuarios;

import javax.ejb.Remote;

/**
 *
 * @author Administrador
 */
@Remote
public interface UsuarioRemote {

    boolean validarUsuario(String nombre, String password);
    
}
