/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ejerciciodbempleados;

import java.io.Serializable;

/**
 *
 * @author: $Author$
 * @version: $Rev$
 * @date: $Date$
 * $Id$
 */
public class Empleado implements Serializable {
    private int id;
    private String nombre;
    private int localizacion;

    public Empleado(int id, String nombre, int localizacion) {
        this.id = id;
        this.nombre = nombre;
        this.localizacion = localizacion;
    }

    /**
     * @return the id
     */
    public int getId()
    {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id)
    {
        this.id = id;
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
     * @return the localizacion
     */
    public int getLocalizacion()
    {
        return localizacion;
    }

    /**
     * @param localizacion the localizacion to set
     */
    public void setLocalizacion(int localizacion)
    {
        this.localizacion = localizacion;
    }
}
