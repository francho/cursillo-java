/*
 * - Crear una clase abstracta Vehiculo:
 *      arrancar()
 *      frenar()
 *      acelerar()
 *      parar()
 * - Crear una interfaz Movil
 *      desplazar()
 * - Crear una clase Cometa
 *      subir()
 *      bajar()
 * - Crear las clases Coche y Motocicleta que descienden de vehículo
 *
 */

package ejercicioherencia;

import es.random.herencia.Coche;
import es.random.herencia.Cometa;
import es.random.herencia.Motocicleta;
import es.random.herencia.Movil;
import es.random.herencia.Vehiculo;

/**
 *
 * @author: $Author$
 * @version: $Rev$
 * @date: $Date$
 * $Id$
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Coche coche = new Coche();
        coche.desplazar(50);

        Motocicleta moto = new Motocicleta();
        moto.desplazar(10);

        Cometa cometa = new Cometa();
        cometa.desplazar(0.5);

        // Otra forma de implementar interfaces sin tener que definir una clase
        // Definimos los metodos necesarios al instanciar el objeto

        Movil pelota = new Movil() {

            public void desplazar(double kilometros)
            {
                System.out.println("La pelota se desplaza " + kilometros + "km");
            }
        };

        pelota.desplazar(2);

        // Manejamos nuestros vehiculos a la vez
        Vehiculo[] vehiculos = new Vehiculo[2];
        vehiculos[0] = coche;
        vehiculos[1] = moto;
        
        System.out.println("* Arrancamos nuestros vehiculos");
        for(Vehiculo v: vehiculos) {
            v.arrancar();

            // En este tipo de bucles tambien puedo hacer condiciones de este tipo
            if(v instanceof Coche) {
                System.out.println("(es un objeto de tipo " + v.getClass().getName() + ")") ;
            }
        }

        // Desplazamos todos los moviles al mismo tiempo
        Movil[] moviles = new Movil[4];
        moviles[0] = coche;
        moviles[1] = moto;
        moviles[2] = cometa;
        moviles[3] = pelota;

        System.out.println("** Moviendo objetos de tipo Movil");
        for(Movil cosa: moviles) {
            cosa.desplazar(1);
        }


    }

}
