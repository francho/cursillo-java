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
public class Triangulo {
    private Punto p1;
    private Punto p2;
    private Punto p3;

    public Triangulo() {
        p1 = new Punto();
        p2 = new Punto();
        p3 = new Punto();
    }

    public Triangulo(Punto p1,Punto p2, Punto p3) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }

    public double[] calcularLongitudLados() {
        double[] distancia = new double[3];

        distancia[0] = p1.calcularDistancia(p2);
        distancia[1] = p1.calcularDistancia(p3);
        distancia[2] = p2.calcularDistancia(p3);

        return distancia;
    }

    @Override
    public String toString() {
        return p1.toString() + ", " + p2.toString() + ", " + p3.toString();
    }

    /**
     * @return the p1
     */
    public Punto getP1()
    {
        return p1;
    }

    /**
     * @param p1 the p1 to set
     */
    public void setP1(Punto p1)
    {
        this.p1 = p1;
    }

    /**
     * @return the p2
     */
    public Punto getP2()
    {
        return p2;
    }

    /**
     * @param p2 the p2 to set
     */
    public void setP2(Punto p2)
    {
        this.p2 = p2;
    }

    /**
     * @return the p3
     */
    public Punto getP3()
    {
        return p3;
    }

    /**
     * @param p3 the p3 to set
     */
    public void setP3(Punto p3)
    {
        this.p3 = p3;
    }
}
