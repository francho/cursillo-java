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
public interface IFuenteDeDatos <T>
{

    public String extraerTexto();

    public Collection<T> insertarTexto(String s);

    public String[] aArray();
    public String[] obtenerNombresColumnas();
    public int tamaño();
    public Object obtenerElemento(int posicion);
    public void establecerElemento(Object valor, int posicion);

}
