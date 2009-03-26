/*
 * Interfaz básico para interactuar con el usuario en este ejercicio
 */
package estadisticasfichero;

import java.util.Scanner;

/**
 *
 * @author: $Author$
 * @version: $Rev$
 * @date: $Date$
 * $Id$
 */
public class InterfazUsuario {
    /**
     * Pide al usuario que introduzca un nuevo texto
     * Espera a que una línea contenga la palabra clave EOF para terminar
     *
     * @return Texto tecleado por el usuario con saltos de linea Windows
     */
    public String pideNuevoTexto() {
        Scanner flujo = new Scanner(System.in);
        System.out.println("Introduce el nuevo texto. Teclea EOF para salir.\n");

        String nuevoTexto = "";
        String linea = "";
        do {
            linea = flujo.nextLine();
            if(! linea.contains("EOF") ) {
                nuevoTexto += linea + "\r\n";
            }
        } while (!linea.contains("EOF"));
        return nuevoTexto;
    }

    /**
     * Pide un nuevo nombre de fichero
     * @return la cadena con el nuevo nombre (siempre termina con la extension .txt)
     */
    public String pideNombreFicheroTxt() {
        Scanner flujo = new Scanner(System.in);
        String nombre = "";

        System.out.print("Introduce el nuevo nombre del fichero: ");

        nombre = flujo.nextLine();

        if( !nombre.equals("") && !nombre.matches("txt$")) {
            nombre += ".txt";
        }
        return nombre;
    }
}
