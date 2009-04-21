/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ejerciciosockets;

import java.io.Serializable;

/**
 *
 * @author: $Author$
 * @version: $Rev$
 * @date: $Date$
 * $Id$
 */
public class Mensaje implements Serializable {
    private String nombre;
    private String texto;


    public Mensaje() {
        nombre = "desconocido";
        texto = "";
    }

    public Mensaje(String nombre, String texto) {
        this.nombre = nombre;
        this.texto = texto;
    }

    /**
     * @return the nombre
     */
    public String getNombre()
    {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    /**
     * @return the texto
     */
    public String getTexto()
    {
        return texto;
    }

    /**
     * @param texto the texto to set
     */
    public void setTexto(String texto)
    {
        this.texto = texto;
    }

    
}
