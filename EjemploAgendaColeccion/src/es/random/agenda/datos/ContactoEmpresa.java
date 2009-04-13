/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.random.agenda.datos;

/**
 *
 * @author AdminLocal
 */
public class ContactoEmpresa extends Contacto
{
    protected String empresa;
    protected String departamento;
    protected int extension;

    public ContactoEmpresa()
    {
        super();
        empresa = "";
        departamento = "";
        extension = 0;
    }

    public ContactoEmpresa(String nombre)
    {
        this();
        this.nombre=nombre;
    }

    public ContactoEmpresa(String nombre,long telefonoFijo)
    {
        this(nombre);
        this.telefonoFijo = telefonoFijo;
    }
    /**
     * @return the empresa
     */
    public String getEmpresa()
    {
        return empresa;
    }

    /**
     * @param empresa the empresa to set
     */
    public void setEmpresa(String empresa)
    {
        this.empresa = empresa;
    }

    /**
     * @return the departamento
     */
    public String getDepartamento()
    {
        return departamento;
    }

    /**
     * @param departamento the departamento to set
     */
    public void setDepartamento(String departamento)
    {
        this.departamento = departamento;
    }

    /**
     * @return the extension
     */
    public int getExtension()
    {
        return extension;
    }

    /**
     * @param extension the extension to set
     */
    public void setExtension(int extension)
    {
        this.extension = extension;
    }

    @Override
    public String toString()
    {
        String cadena="";
        cadena += super.toString();
        if(!empresa.equals(""))
        {
            cadena += "Empresa: " + empresa + "\n\r";
        }
        if(!departamento.equals(""))
        {
            cadena += "Departamento: " + departamento + "\n\r";
        }
        if(extension != 0)
        {
            cadena += "Extension: " + extension + "\n\r";
        }
        return cadena;
    }

}
