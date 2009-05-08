/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.usuarios;

import javax.ejb.Local;

/**
 *
 * @author Administrador
 */
@Local
public interface AdministradorLocal {

    boolean validarUsuario(String nombre, String passwword);

    void añadirUsuario(String nombre, String password);
    
}
