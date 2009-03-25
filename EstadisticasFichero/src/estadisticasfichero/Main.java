/*
 * Ejercicio:
 *
 * Crear una clase que realice las siguientes tareas:
 *  - Cargar un fichero de texto (pidiendo el nombre)
 *  - Guardar un fichero de texto (pidiendo el nombre)
 *  - Mostrar una serie de estadísticas sobre el fichero:
 *      + Nº de palabras
 *      + Nº de lineas
 *
 */

package estadisticasfichero;

import es.random.mifichero.FicheroTexto;

/**
 * Almacena los datos de un contacto.
 *
 * @author: $Author$
 * @version: $Rev$
 * @Fecha: $Date$
 * $Id$
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FicheroTexto fich = new FicheroTexto("prueba.txt");

        fich.cargar();
        System.out.println(fich.getContenido());

    }

}
