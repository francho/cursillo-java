/*
 * Define un Vehiculo tipo Moto
 */

package es.random.herencia;

/**
 *
 * @author: $Author$
 * @version: $Rev$
 * @date: $Date$
 * $Id$
 */
public class Motocicleta extends Vehiculo {
    public Motocicleta() {
        this.setVelocidadCrucero(90);
    }


    @Override
    public void arrancar()
    {
        System.out.println("La moto arranca");
    }

    @Override
    public void frenar(double velocidad)
    {
        System.out.println("La moto frena hasta " + velocidad + "km/h");
    }

    @Override
    public void acelerar(double velocidad)
    {
        System.out.println("La moto acelera hasta " + velocidad + "km/h");
    }

    @Override
    public void parar()
    {
        frenar(0);
        System.out.println("La moto esta parada");
    }

    @Override
    public void setVelocidadCrucero(double velocidadCrucero)
    {
        this.velocidadCrucero = velocidadCrucero;
    }

}
