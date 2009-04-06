/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.random.ficheros;

import es.random.matrices.GestorMatriz;
import java.io.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author: $Author$
 * @version: $Rev$
 * @date: $Date$
 * $Id$
 */
public class FicheroTexto {

    private String nombreFichero;
    

    private int numLineas = 0;
    private int numPalabras = 0;
    private GestorMatriz palabras;


    /**
     * Constructores de la clase
     */
    public FicheroTexto() {
        nombreFichero = "";
        numLineas = 0;
        numPalabras = 0;
        palabras = new GestorMatriz();
    }
    
    /**
     * Constructor
     * @param nombreFichero fichero a cargar
     */
    public FicheroTexto(String nombreFichero) {
        this();
        this.nombreFichero = nombreFichero;
        cargar();
    }

    /**
     * Carga el fichero de texto
     */
    public void cargar() {
        File fichero = new File(nombreFichero);

        // Creamos las variables que vamos a necesitar luego
        FileReader lectorFichero = null;
        Scanner lector = null;

        if (fichero.exists()) {
            try {
                // Creamos el manejador de lectura del archivo
                lectorFichero = new FileReader(fichero);
                lector = new Scanner(lectorFichero);

                // El limitador de
                lector.useDelimiter("\r\n");
                
                while (lector.hasNext()) {
                    String linea = lector.nextLine();
                    numLineas ++;

                    Scanner lectorPalabras = new Scanner(linea);
                    lectorPalabras.useDelimiter(" |\n|\r\n");
                    while(lectorPalabras.hasNext()) {
                        String palabra = lectorPalabras.next();
                        palabras.añadirPalabra(palabra);                        
                        numPalabras ++;
                    }
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(FicheroTexto.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                lector.close();
            }
        } else {
            System.out.println("ERR - No se encuentra el fichero (" + fichero.getAbsoluteFile() + ")");
        }

    }

    
    /**
     * Muestra las estadísticas del fichero
     * 
     */
    public void estadisticas() {
        // Pista: para las estadisticas de palabra usar el Scanner con el delimitador por defecto (" ")
        File fich = new File(this.nombreFichero);
        
        System.out.println("Tamaño: "+fich.length());
        System.out.println("Líneas: " + numLineas);
        System.out.println("Palabras: " + numPalabras);
        System.out.println(palabras.toString());
    }
    

    
    
}
