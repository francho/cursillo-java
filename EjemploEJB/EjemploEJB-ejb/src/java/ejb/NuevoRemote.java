/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ejb;

import javax.ejb.Remote;

/**
 *
 * @author Administrador
 */
@Remote
public interface NuevoRemote {

    String saludar();
    
}
