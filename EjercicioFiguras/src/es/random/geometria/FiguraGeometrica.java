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


/**
 * Interfaz que implementa los requisitos del ejercicio
 */

interface Figura {

    public String getEtiqueta();
    public String getTipoFigura();
    public double calcularArea();
    public void dibujarTxt();
    public void imprimirDescripcion();
}


public abstract class FiguraGeometrica implements Figura {
    private String etiqueta = "etiqueta desconocida";
    private String tipoFigura = "figura desconocida";
    
    abstract public double calcularArea();
    abstract public void dibujarTxt();

    public FiguraGeometrica() {
    }

    public FiguraGeometrica(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    /**
     * @return the tipoFigura
     */
    public String getTipoFigura()
    {
        return tipoFigura;
    }

    public void setTipoFigura(String tipo) {
        tipoFigura = tipo;
    }

    /**
     * @return the etiqueta
     */
    public String getEtiqueta()
    {
        return etiqueta;
    }

    /**
     * @param etiqueta the etiqueta to set
     */
    public void setEtiqueta(String etiqueta)
    {
        this.etiqueta = etiqueta;
    }

    public void imprimirDescripcion() {
            System.out.println("---------------");
            System.out.println(getTipoFigura());
            System.out.println("Dimentsiones: " + toString());
            System.out.println("Etiqueta: " + getEtiqueta());
            System.out.println("Área: "+ calcularArea());
            System.out.println("");
            dibujarTxt();
            System.out.println("---------------");
    }
}