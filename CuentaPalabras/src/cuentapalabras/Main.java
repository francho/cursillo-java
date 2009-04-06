/*
 * Ejercicio Revisor:
 * 
 * - Pedir nombre de un fichero
 * - Leer palabra por palabra el fichero
 * - Ir creando estadísticas:
 *      + Nº de palabras
 *      + Nº de líneas
 *      + Apariciones de cada palabra
 * - Mostrar al final las estadísticas
 *
 * Nota las estadisticas deberan guardarse en una un vector de 26 elementos (uno por cada letra)
 * y cada vector contendra otro vector de elementos del tipo
 *  InfoPalabra{
 *      String Palabra
 *      int apariciones
 * }
 *
 *
 *
 */
 

package cuentapalabras;

import es.random.ficheros.FicheroTexto;
import es.random.interfaz.ModoTexto;

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
        ModoTexto app = new ModoTexto() {
            @Override
            public void setOpcionesMenu() {}

            @Override
            public void ejecutaOpcion(int numOpcion) {}
        };

        FicheroTexto fich = new FicheroTexto(app.pregunta("Nombre de fichero: "));

        fich.estadisticas();
    }

}

