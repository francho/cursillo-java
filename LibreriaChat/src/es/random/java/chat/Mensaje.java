/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.random.java.chat;

import java.io.Serializable;

/**
 *
 * @author ernesto.cuevas
 */
public class Mensaje implements Serializable
{
    private String contenido;
    private Tipo tipo;
    private String usuario;

    /**
     * @return the contenido
     */
    public String getContenido()
    {
        return contenido;
    }

    /**
     * @param contenido the contenido to set
     */
    public void setContenido(String contenido)
    {
        this.contenido = contenido;
    }

    /**
     * @return the tipo
     */
    public Tipo getTipo()
    {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(Tipo tipo)
    {
        this.tipo = tipo;
    }

    /**
     * @return the usuario
     */
    public String getUsuario()
    {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario)
    {
        this.usuario = usuario;
    }

    public enum Tipo implements Serializable
    {
        Log,Mensaje,MensajePrivado,Acceder,Salir,UsuarioEntra,UsuarioSale
    }

    public Mensaje()
    {
        contenido="";
        tipo = Tipo.Mensaje;
        usuario = "";
    }

    public Mensaje(String usuario, String contenido)
    {
        this();
        this.contenido = contenido;
        this.usuario = usuario;
    }

    public Mensaje(String usuario, String contenido, Tipo tipo)
    {
        this(usuario,contenido);
        this.tipo = tipo;
    }

}
