/*
 * Clase vehiculo que implementa el interfaz Movil
 * Es abstracta para obligar a que sus hijas implementen los metodos definidos como abstract
 * 
 */

package es.random.herencia;

/**
 *
 * @author: $Author$
 * @version: $Rev$
 * @date: $Date$
 * $Id$
 */

 public abstract class Vehiculo implements Movil {
    /** Velocidad de crucero del vehículo en Km/h */
    protected double velocidadCrucero = 1;

    abstract public void arrancar();
    abstract public void frenar(double velocidad);
    abstract public void acelerar(double velocidad);
    abstract public void parar();

    /**
     * Desplaza el vehículo X kilometros
     *
     * @param kilometos a mover el vehículo
     */
    public void desplazar(double kilometros) {
        System.out.println("------");
        arrancar();
        acelerar(velocidadCrucero);

        System.out.println("El " + this.getClass().getName() 
                + " se desplaza a " + Double.toString(velocidadCrucero) + "km/h "
                + " hasta que recorre " + Double.toString(kilometros) + "km");
        parar();
        System.out.println("------");
    }

    /**
     * @return the velocidadCrucero
     */
    public /** Velocidad de crucero del vehículo en Km/h */
    double getVelocidadCrucero()
    {
        return velocidadCrucero;
    }

    /**
     * @param velocidadCrucero the velocidadCrucero to set
     */
    abstract public void setVelocidadCrucero(double velocidadCrucero);
    


}
