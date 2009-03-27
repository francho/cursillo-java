/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ejemploenumeracion;

/**
 *
 * @author AdminLocal
 */


public class ContenedorEnumeracion 
{
    public enum DiasLaborables
    {
        Lunes,Martes,Miercoles,Jueves,Viernes;
    }
    public enum Dia
    {
        Lunes("Lun",1),
        Martes("Mar",2),
        Miercoles("Mie",3),
        Jueves("Jue",4),
        Viernes("Vie",5),
        Sabado("Sab",6),
        Domingo("Dom",7);
        private String nombreCorto;
        private int numeroDia;
        Dia(String nombreCorto,int numeroDia)
        {
            this.nombreCorto=nombreCorto;
            this.numeroDia = numeroDia;
        }
        public String getNombreCorto()
        {
            return nombreCorto;
        }
        public int getNumeroDia()
        {
            return numeroDia;
        }
    }

    Dia miDia;

    public ContenedorEnumeracion()
    {
        miDia = Dia.Lunes;
        System.out.println(miDia.getNombreCorto());
    }
}
