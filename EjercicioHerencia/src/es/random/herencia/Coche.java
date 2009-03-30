/*
 * Define un Vehículo tipo Coche
 */

package es.random.herencia;

/**
 *
 * @author: $Author$
 * @version: $Rev$
 * @date: $Date$
 * $Id$
 */
public class Coche extends Vehiculo{

    public Coche() {
        this.setVelocidadCrucero(120);
    }

    @Override
    public void arrancar()
    {
        System.out.println("El coche arranca");
    }

    @Override
    public void frenar(double velocidad)
    {
        System.out.println("El coche frena hasta "+ Double.toString(velocidad) + "km/h");
    }

    @Override
    public void acelerar(double velocidad)
    {
        System.out.println("El coche acelera");
    }

    @Override
    public void parar()
    {
        frenar(0);
        System.out.println("El coche está parado");
    }

    @Override
    public void setVelocidadCrucero(double velocidadCrucero)
    {
        this.velocidadCrucero = velocidadCrucero;
    }


}
