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
public class Cita {
    Date hora;
    DiasLaborables dia;

    public Cita(Date hora, DiasLaborables dia)
    {
        this.hora = hora;
        this.dia = dia;
    }

}
