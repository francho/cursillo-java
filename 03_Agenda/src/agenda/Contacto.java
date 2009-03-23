/*
 * Ejemplo para probar:
 *  - Sobrecarga
 *  - Metodos get / set
 *  - Sobreescritura
 */
package agenda;

/**
 * Almacena los datos de un contacto.
 *
 * @author: $Author$
 * @version: $Rev$
 * @Fecha: $Date$
 * $id$
 */
public class Contacto
{

    protected String nombre;
    protected String primerApellido;
    protected String segundoApellido;
    protected long telefonoFijo;
    protected long telefonoMovil;
    protected String email;
    protected String direccion;

    /**
     * Constructor "Por defecto" de la clase
     * Inicializa las propiedades de la clase
     */
    public Contacto()
    {
        this.nombre = "";
        this.primerApellido = "";
        this.segundoApellido = "";
        this.telefonoFijo = 900555555;
        this.telefonoMovil = 900555555;
        this.email = "yo@yo.com";
        this.direccion = "";
    }

    /**
     * Sobrecargamos el constructor.
     *
     * Lo hacemos privado, porque ¿para que queremos un contacto con sólo nombre?
     *
     */
    private Contacto(String nombre)
    {
        // Accedemos al constructor por defecto
        // Esto solo se puede hacer desde los constructores
        this();

        // Una vez cargados los datos por defecto, cargamos el parametro
        this.nombre = nombre;
    }

    /**
     * Otro ejemplo de constructor
     *
     */
    public Contacto(String nombre, long telefono)
    {
        // Llamamos primero al constructor que recibe nombre
        this(nombre);
        this.telefonoFijo = telefono;
    }

    /*
     * Sobreescribimos los métodos heredados de la superclase object.
     * Conviene sobreescribir por lo menos:
     *  - equals()
     *  - hashCode()
     *  - toString()
     *
     * 
     * Override es una anotación que indica que estamos sobreescribiendo
     */
    /**
     * Compara dos contactos.
     *
     * Devuelve true si los nombres y los apellidos son iguales y false en caso contrario
     *
     * @param otro el contacto a comparar
     * @return ver explicación general
     */
    @Override
    public boolean equals(Object otro)
    {
        boolean iguales = false;

        // 1º .- Nos aseguramos que los dos objetos son de la misma clase
        if (otro.getClass().equals(this.getClass())) {
            // 2º.- Convertimos el objeto recibido a nuestra clase para poder comparar
            Contacto otroContacto = (Contacto) otro;

            // Comparamos las propiedades difernciadoras
            String x = (this.nombre + this.primerApellido + this.segundoApellido);
            String y = (otroContacto.nombre + otroContacto.primerApellido + otroContacto.segundoApellido);

            iguales = x.equals(y);

            // Otra forma de hacerlo
            // iguales = this.hashCode() == otroContacto.hashCode();
        //
        }
        return iguales;
    }

    /**
     * Genera el hashCode de la clase Contacto.
     *
     * Esta funcion ha sido generadada automáticamente por el netBeans
     *
     * @return hashCode int
     */
    @Override
    public int hashCode()
    {
        int hash = 7;
        hash = 79 * hash + (this.nombre != null ? this.nombre.hashCode() : 0);
        hash = 79 * hash + (this.primerApellido != null ? this.primerApellido.hashCode() : 0);
        hash = 79 * hash + (this.segundoApellido != null ? this.segundoApellido.hashCode() : 0);
        return hash;
    }

    /**
     * Convierte los datos del contacto en cadena.
     *
     * @return String cadena con los datos rellenados (usa saltos de linea)
     */
    @Override
    public String toString()
    {
        String cadena = "";

        if (!this.nombre.equals("")) {
            cadena += "Nombre: " + this.nombre;
            if (!this.primerApellido.equals("")) {
                cadena += " " + this.primerApellido;
                if (!this.segundoApellido.equals("")) {
                    cadena += " " + this.segundoApellido;
                }
            }
            cadena += "\n";
        } else {
            cadena += "(Nombre desconocido)\n";
        }

        if (this.telefonoFijo != 900555555) {
            cadena += "Tlf: " + this.telefonoFijo + "\n";
        }

        if (this.telefonoMovil != 900555555) {
            cadena += "Móvil:" + this.telefonoMovil + "\n";
        }

        if (!this.email.equals("yo@yo.com")) {
            cadena += "Email: " + this.email + "\n";
        }

        if (!this.direccion.equals("")) {
            cadena += "Direccion: " + this.direccion + "\n";
        }

        return cadena;
    }

    /*************************************************************
     * Funciones generadas automaticamente con el Netbeans
     *
     * Boton Dcho / Reestructurar / Encapsular Campos
     *************************************************************/
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
     * @return the email
     */
    public String getEmail()
    {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email)
    {
        this.email = email;
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
}
