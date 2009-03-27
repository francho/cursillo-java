/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ejemploenumeracion;

import ejemploenumeracion.ContenedorEnumeracion.DiasLaborables;
import java.util.Date;

/**
 *
 * @author AdminLocal
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Cita miCita = new Cita(new Date(),DiasLaborables.Martes);
    }

}
