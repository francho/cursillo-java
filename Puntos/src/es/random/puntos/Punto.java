/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.random.puntos;

/**
 *
 * @author: $Author$
 * @version: $Rev$
 * @date: $Date$
 * $Id$
 */
public class Punto {
    private double x;
    private double y;


    /**
     * Constructor básico de la clase
     */

    public Punto() {
        x = 0;
        y = 0;
    }

    /**
     * Constructor de la clase con parametros
     *
     * @param x coordenada x
     * @param y coordenada y
     */

    public Punto(double x,double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Calcula la distancia del punto actual a otro punto
     * 
     * @param punto coordenada del otro punto
     */
    public double calcularDistancia(Punto punto) {
        return Math.sqrt(Math.pow(x - punto.getX(), 2) + Math.pow(y - punto.getY(), 2));
    }

    /**
     * Calcula la distancia del punto al origen
     *
     * @return distancia
     */
    public double calcularDistanciaOrigen() {
        return calcularDistancia(new Punto(0,0));
    }

    /**
     * Calcula el cuadrante en el que está el punto
     * @return cuadrante
     *  0 = Origen
     *  1 = cuadrante 1 (x,y positivos)
     *  2 = cuadrante 2 (x negativo, y positivo)
     *  3 = cuadrante 3 (x,y negativos)
     *  4 = cuadrante 4 (x poitivo, y negativo)
     * -1 = cuadrante desconocido
     */
    public int calcularCuadrante() {
        int cuadrante = -1;

        if(x == 0 && y == 0) {
            cuadrante = 0;
        } else if ( x >= 0  && y >= 0) {
            cuadrante = 1;
        } else if ( x <0 && y >=0 ) {
            cuadrante = 2;
        } else if ( x <0 && y <0 ) {
            cuadrante = 3;
        } else if ( x >= 0 && y < 0 ) {
            cuadrante = 4;
        }
        return cuadrante;
    }

    /**
     * Calcula el punto mas cercano al actual
     * @param otrosPuntos lista de puntos a comprobar
     * @return el mas cercano
     */
    public Punto calcularMasCercano(Punto[] otrosPuntos) {
        boolean hayCercano = false;
        Punto cercano = new Punto();
        for(Punto p: otrosPuntos) {
            if(!hayCercano) {
                cercano = p;
                hayCercano = true;
            } else if(this.calcularDistancia(p) < this.calcularDistancia(cercano)) {
                cercano = p;
            }
        }

        return cercano;
    }

    /**
     * Compara el punto actual con otro.
     *
     * @param Punto con el que comparar
     * @return true si los dos tienen las mismas coordenadas
     */
    @Override
    public boolean equals(Object aComparar) {
        if(! (aComparar instanceof Punto)) {
            return false;
        } else {
            Punto p = (Punto) aComparar;
            return (x == p.getX()) && (y == p.getY());
        }
    }

    @Override
    public int hashCode()
    {
        int hash = 3;
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.x) ^ (Double.doubleToLongBits(this.x) >>> 32));
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.y) ^ (Double.doubleToLongBits(this.y) >>> 32));
        return hash;
    }

    /**
     * Convertimos nuestros datos en cadena para que sean visibles
     *
     * @return cadena con la representacion del punto
     */
    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }

    /**
     * @return the x
     */
    public double getX()
    {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(double x)
    {
        this.x = x;
    }

    // Apartado 5;

    /**
     * @return the y
     */
    public double getY()
    {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(double y)
    {
        this.y = y;
    }
}
