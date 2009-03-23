/*
 * Ejemplo para probar:
 *  - Herencia
 *
 */

package es.random.agenda.datos;

/**
 * Clase que para gestionar los contactos tipo empresa
 *
 * @author: $Author$
 * @version: $Rev$
 * @Fecha: $Date$
 */
public class ContactoEmpresa extends Contacto {
    protected String empresa;
    protected String departamento;
    protected int extension;

    /**
     * Constructor por defecto
     *
     * Inicializa los valores:
     * - Tipos cadena a ""
     * - extension a 0
     * - telefonoFijo y telefonoMovil a 111111111
     * - email a yo@yo.com
     */
    public ContactoEmpresa() {
        super(); // Llamamos al constructor del padre
        this.empresa = "";
        this.departamento = "";
        this.extension = 0;
    }

    /**
     * Convierte los datos del contacto en cadena.
     *
     * @return String cadena con los datos rellenados (usa saltos de linea)
     */
    @Override
    public String toString() {
        String cadena = super.toString(); // Accedemos primero al metodo de la clase padre

        if(!this.empresa.equals("")) {
            cadena += "Empresa: " + this.empresa + "\n";
            if(!this.departamento.equals("")) {
                cadena += "Departamento: " + this.departamento + "\n";
            }

            if(this.extension != 0) {
                cadena += "Extension: " + this.extension + "\n";
            }
        }

        return cadena;
    }

    /**
     * Redefinimos tambien este constructor para que la clase se pueda inicializar como la nueva
     *
     */
    public ContactoEmpresa(String nombre, int telefonoFijo) {
        // Inicializamos con el constructor por defecto
        this();

        // Cargamos los datos recibidos
        this.nombre = nombre;
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

    
}
