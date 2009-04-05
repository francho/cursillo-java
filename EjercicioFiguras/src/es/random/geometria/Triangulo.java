/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.random.geometria;

/**
 *
 * @author: $Author$
 * @version: $Rev$
 * @date: $Date$
 * $Id$
 */
public abstract class Triangulo extends FiguraGeometrica {
    private double lado1;
    private double lado2;
    private double angulo;
    
    public Triangulo(double lado1, double lado2, double angulo) {
        this.lado1 = lado1;
        this.lado2 = lado2;
        this.angulo = angulo;        
    }
    
    @Override
    public double calcularArea() {
        return lado1 * lado2 * Math.sin(angulo) / 2;
    }

    abstract public void dibujarTxt();

    public double getLado1() {
        return lado1;
    }

    public void setLado1(double lado1) {
        this.lado1 = lado1;
    }

    public double getLado2() {
        return lado2;
    }

    public void setLado2(double lado2) {
        this.lado2 = lado2;
    }

    public double getAngulo() {
        return angulo;
    }

    public void setAngulo(double angulo) {
        this.angulo = angulo;
    }

    @Override
    public String toString() {
        return "(" + lado1 + ", " + lado2 + ", " + angulo + "º)";
    }

}
