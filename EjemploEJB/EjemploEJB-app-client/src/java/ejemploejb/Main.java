/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ejemploejb;

import ejb.NuevoRemote;
import javax.ejb.EJB;

/**
 *
 * @author Administrador
 */
public class Main {
    @EJB
    private static NuevoRemote nuevoBean;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println(nuevoBean.saludar());
    }

}
