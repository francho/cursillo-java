/*
 * Probamos los constructores
 *
 */

package agenda;

/**
 *
 * @author francho
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Contacto miContacto = new agenda.Contacto("Liborio",976123123);

        miContacto.setPrimerApellido("Lopez");
        miContacto.setSegundoApellido("García");

        miContacto.setEmail("email@nospam.com");
        miContacto.setTelefonoMovil(606456456);
        miContacto.setDireccion("c\\ Bajo el puente.");

        System.out.println(miContacto.toString());

        // Probamos nuestro equals
        
        Contacto otroContacto = new agenda.Contacto("Liborio",123123123);
        otroContacto.setPrimerApellido("Lopez");
        otroContacto.setSegundoApellido("García");

        System.out.println(miContacto.equals(otroContacto));

        // Comprobamos los hashCodes
        System.out.println("HashCodes: " + miContacto.hashCode() + " = " + otroContacto.hashCode());


    }

}
