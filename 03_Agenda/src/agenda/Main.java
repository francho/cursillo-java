/*
 * Probamos los constructores
 *
 */

package agenda;

import es.random.agenda.datos.*;

/**
 *
 * @author francho
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Contacto miContacto = new es.random.agenda.datos.Contacto("Liborio",976123123);

        miContacto.setPrimerApellido("Lopez");
        miContacto.setSegundoApellido("García");

        miContacto.setEmail("email@nospam.com");
        miContacto.setTelefonoMovil(606456456);
        miContacto.setDireccion("c\\ Bajo el puente.");

        System.out.println(miContacto.toString());

        // Probamos nuestro equals
        
        Contacto otroContacto = new es.random.agenda.datos.Contacto("Liborio",123123123);
        otroContacto.setPrimerApellido("Lopez");
        otroContacto.setSegundoApellido("García");

        System.out.println(miContacto.equals(otroContacto));

        // Comprobamos los hashCodes
        System.out.println("HashCodes: " + miContacto.hashCode() + " = " + otroContacto.hashCode());

        // Probamos nuestra clase heredada      
        ContactoEmpresa miEmpresa = new ContactoEmpresa("Liborio", 123123123);
        miEmpresa.setPrimerApellido("Lopez");
        miEmpresa.setSegundoApellido("García");

        miEmpresa.setEmpresa("ACME S.L.");
        miEmpresa.setDepartamento("Sistemas");
        miEmpresa.setExtension(10);

        System.out.println(miEmpresa.toString());

        System.out.println(miEmpresa.equals(otroContacto));
        System.out.println("HashCodes: " + miContacto.hashCode() + " = " + miEmpresa.hashCode());
    }

}
