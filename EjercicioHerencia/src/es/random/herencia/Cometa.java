/*
 * Define un objeto Movil tipo Cometa
 */

package es.random.herencia;

/**
 *
 * @author: $Author$
 * @version: $Rev$
 * @date: $Date$
 * $Id$
 */
public class Cometa implements Movil {
    protected double altura = 0;
    protected final double ALTURA_MAXIMA = 30;

    public void subir(double metros)  {
        altura += metros;
        System.out.println("La cometa sube " + metros + "m, ahora está a " + altura + "m");
    }

    public void bajar(double metros) {
        altura -= metros;

        System.out.println("La cometa baja " + metros + "m, ahora está a " + altura + "m");
    }
    public void desplazar(double kilometros)
    {
        System.out.println("------");
        subir(ALTURA_MAXIMA);
        System.out.println("La cometa se desplaza " + Double.toString(kilometros) + "km");
        bajar(ALTURA_MAXIMA);
        System.out.println("------");
    }

}
