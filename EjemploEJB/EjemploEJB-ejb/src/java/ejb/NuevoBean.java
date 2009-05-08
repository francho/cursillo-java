/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ejb;

import javax.ejb.Stateless;

/**
 *
 * @author Administrador
 */
@Stateless
public class NuevoBean implements NuevoRemote, NuevoLocal {

    public String saludar() {
        return "Hola caracola";
    }
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method" or "Web Service > Add Operation")
 
}
