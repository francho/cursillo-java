/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.random.agenda.datos;

import es.random.java.librerias.gestion.IFuenteDeDatos;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

/**
 *
 * @author AdminLocal
 */
public class Contacto implements Serializable, IFuenteDeDatos
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
        if (o.getClass().equals(this.getClass())) {
            Contacto otro = (Contacto) o;
            if (this.nombre.equals(otro.nombre)) {
                if (this.primerApellido.equals(otro.primerApellido)) {
                    if (this.segundoApellido.equals(otro.segundoApellido)) {
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
        if (telefonoFijo != 900555555) {
            cadena += "Telefono Fijo: " + telefonoFijo + "\n\r";
        }
        if (telefonoMovil != 900555555) {
            cadena += "Telefono Movil: " + telefonoMovil + "\n\r";
        }
        if (!direccion.equals("")) {
            cadena += "Dirección: " + direccion + "\n\r";
        }
        if (!eMail.equals("yo@yo.com") && !eMail.equals("")) {
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
        while (lector.hasNext()) {
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

    public String[] aArray()
    {
        String[] cad = new String[7];
        cad[0] = nombre;
        cad[1] = primerApellido;
        cad[2] = segundoApellido;
        cad[3] = "" + telefonoFijo;
        cad[4] = "" + telefonoMovil;
        cad[5] = eMail;
        cad[6] = direccion;
        return cad;
    }

    public String[] obtenerNombresColumnas()
    {
        String[] cad = {"nombre", "primer apellido", "segundo apellido", "teléfono fijo", "teléfono móvil", "email", "direccion"};

        return cad;
    }

    public Object obtenerElemento(int posicion)
    {
        Object obj = null;
        switch (posicion) {
            case 0:
                obj = nombre;
                break;
            case 1:
                obj = primerApellido;
                break;
            case 2:
                obj = segundoApellido;
                break;
            case 3:
                obj = telefonoFijo;
                break;
            case 4:
                obj = telefonoMovil;
                break;
            case 5:
                obj = eMail;
                break;
            case 6:
                obj = direccion;
                break;
        }
        return obj;
    }

    public int tamaño()
    {
        return obtenerNombresColumnas().length;
    }

    public void establecerElemento(Object valor, int posicion)
    {
        switch (posicion) {
            case 0:
                if (valor == null) {
                    nombre = "";
                } else if (valor instanceof String) {
                    nombre = (String) valor;
                }
                break;
            case 1:
                if (valor == null) {
                    primerApellido = "";
                } else if (valor instanceof String) {
                    primerApellido = (String) valor;
                }
                break;
            case 2:
                if (valor == null) {
                    segundoApellido = "";
                } else if (valor instanceof String) {
                    segundoApellido = (String) valor;
                }
                break;
            case 3:
                if (valor == null) {
                    telefonoFijo = 0;
                } else {
                    try {
                        telefonoFijo = Long.parseLong((String) valor);
                    } catch (Exception e) {
                        System.out.println("Fallo de conversion");
                    }
                }
                break;
            case 4:
                if (valor == null) {
                    telefonoMovil = 0;
                } else {
                    try {
                        telefonoMovil = Long.parseLong((String) valor);
                    } catch (Exception e) {
                        System.out.println("Fallo de conversion");
                    }
                }
                break;
            case 5:
                if (valor == null) {
                    eMail = "";
                } else if (valor instanceof String) {
                    eMail = (String) valor;
                }
                break;
            case 6:
                if (valor == null) {
                    direccion = "";
                } else if (valor instanceof String) {
                    direccion = (String) valor;
                }
                break;
        }
    }
}
