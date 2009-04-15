/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.random.java.librerias.gestion;

import java.util.Collection;

/**
 *
 * @author AdminLocal
 */
public interface TextoSerializable <T>
{

    public String extraerTexto();

    public Collection<T> insertarTexto(String s);

    public String[] toArray();
    public String[] nombreCampos();
    
}
