/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.random.agenda.datos;

import es.random.java.librerias.gestion.TextoSerializable;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

/**
 *
 * @author AdminLocal
 */
public class Contacto implements Serializable, TextoSerializable
{

    public String nombre;
    public String primerApellido;
    public String segundoApellido;
    public long telefonoFijo;
    public long telefonoMovil;
    public String eMail;
    public String direccion;

    public Contacto()
    {
        nombre = "";
        primerApellido = "";
        segundoApellido = "";
        telefonoFijo = 900555555;
        telefonoMovil = 900555555;
        eMail = "yo@yo.com";
        direccion = "";
    }

    public Contacto(String nombre)
    {
        this();
        this.nombre = nombre;
    }

    public Contacto(String nombre, long telefonoFijo)
    {
        this(nombre);
        this.telefonoFijo = telefonoFijo;
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
     * @return the primerApellido
     */
    public String getPrimerApellido()
    {
        return primerApellido;
    }

    /**
     * @param primerApellido the primerApellido to set
     */
    public void setPrimerApellido(String primerApellido)
    {
        this.primerApellido = primerApellido;
    }

    /**
     * @return the segundoApellido
     */
    public String getSegundoApellido()
    {
        return segundoApellido;
    }

    /**
     * @param segundoApellido the segundoApellido to set
     */
    public void setSegundoApellido(String segundoApellido)
    {
        this.segundoApellido = segundoApellido;
    }

    /**
     * @return the telefonoFijo
     */
    public long getTelefonoFijo()
    {
        return telefonoFijo;
    }

    /**
     * @param telefonoFijo the telefonoFijo to set
     */
    public void setTelefonoFijo(long telefonoFijo)
    {
        this.telefonoFijo = telefonoFijo;
    }

    /**
     * @return the telefonoMovil
     */
    public long getTelefonoMovil()
    {
        return telefonoMovil;
    }

    /**
     * @param telefonoMovil the telefonoMovil to set
     */
    public void setTelefonoMovil(long telefonoMovil)
    {
        this.telefonoMovil = telefonoMovil;
    }

    /**
     * @return the eMail
     */
    public String getEMail()
    {
        return eMail;
    }

    /**
     * @param eMail the eMail to set
     */
    public void setEMail(String eMail)
    {
        this.eMail = eMail;
    }

    /**
     * @return the direccion
     */
    public String getDireccion()
    {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion)
    {
        this.direccion = direccion;
    }

    @Override
    public boolean equals(Object o)
    {
        if (o.getClass().equals(this.getClass()))
        {
            Contacto otro = (Contacto) o;
            if (this.nombre.equals(otro.nombre))
            {
                if (this.primerApellido.equals(otro.primerApellido))
                {
                    if (this.segundoApellido.equals(otro.segundoApellido))
                    {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public int hashCode()
    {
        int hash = 7;
        hash = 71 * hash + (this.nombre != null ? this.nombre.hashCode() : 0);
        hash = 71 * hash + (this.primerApellido != null ? this.primerApellido.hashCode() : 0);
        hash = 71 * hash + (this.segundoApellido != null ? this.segundoApellido.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString()
    {
        String cadena = "";
        cadena += "Nombre: " + nombre + " " + primerApellido + " " + segundoApellido + "\n\r";
        if (telefonoFijo != 900555555)
        {
            cadena += "Telefono Fijo: " + telefonoFijo + "\n\r";
        }
        if (telefonoMovil != 900555555)
        {
            cadena += "Telefono Movil: " + telefonoMovil + "\n\r";
        }
        if (!direccion.equals(""))
        {
            cadena += "Dirección: " + direccion + "\n\r";
        }
        if (!eMail.equals("yo@yo.com") && !eMail.equals(""))
        {
            cadena += "E-Mail: " + eMail + "\n\r";
        }
        return cadena;
    }

    public String extraerTexto()
    {
        String cadena = "";
        cadena += this.getNombre() + "\r\n";
        cadena += this.getPrimerApellido() + "\r\n";
        cadena += this.getSegundoApellido() + "\r\n";
        cadena += this.getDireccion() + "\r\n";
        cadena += this.getEMail() + "\r\n";
        cadena += this.getTelefonoFijo() + "\r\n";
        cadena += this.getTelefonoMovil() + "\r\n";
        return cadena;
    }

    public Collection insertarTexto(String s)
    {
        Scanner lector = new Scanner(s);
        lector.useDelimiter("\r\n");
        ArrayList<Contacto> contactos = new ArrayList<Contacto>();
        while (lector.hasNext())
        {
            Contacto c = new Contacto();
            c.setNombre(lector.nextLine());
            c.setPrimerApellido(lector.nextLine());
            c.setSegundoApellido(lector.nextLine());
            c.setDireccion(lector.nextLine());
            c.setEMail(lector.nextLine());
            c.setTelefonoFijo(Long.parseLong(lector.nextLine()));
            c.setTelefonoMovil(Long.parseLong(lector.nextLine()));
            contactos.add(c);
        }
        return contactos;
    }

    public Object obtenerInstancia()
    {
        return new Contacto();
    }
}
