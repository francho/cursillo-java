/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.random.mifichero;

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
    private String contenido;

    /**
     * Constructores de la clase
     */
    public FicheroTexto() {
        contenido = "";
        nombreFichero = "";
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
        File fichero = new File(getNombreFichero());

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
                    this.contenido += lector.nextLine() + "\r\n";
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
     * Guarda el contenido actual de la clase en el archivo
     */
    public void guardar() {
        // Creamos el gestor de fichero (necesita el nombre)
        File fichero = new File(this.getNombreFichero());

        // Creamos el flujo que se encargará de escrir el fichero
        // Debemos hacerlo fuera del try para asegurarnos que se ejecuta

        FileWriter escritorFichero = null;
        PrintWriter escritor = null;

        // Lo primero de todo, si no existe el fichero lo creamos
        try {

            if (!fichero.exists()) {
                fichero.createNewFile();
            }
            // Asociamos el flujo con el fichero
            escritorFichero = new FileWriter(fichero);
            // Envolvemos nuestro flujo para añadirle características de
            // escritura de fichero de texto
            escritor = new PrintWriter(escritorFichero);

            escritor.print(this.contenido);
            escritor.flush();
        } catch (IOException ex) {
            Logger.getLogger(FicheroTexto.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            escritor.close();
        }


    }
    
    /**
     * Guarda el contenido actual con otro nombre
     * 
     * @param nombreFichero nuevo nombre de fichero
     */
    public void guardarComo(String nombreFichero) {
        this.setNombreFichero(nombreFichero);
        this.guardar();
    }

    /**
     * Muestra las estadísticas del fichero
     * 
     */
    public void estadisticas() {
        // Pista: para las estadisticas de palabra usar el Scanner con el delimitador por defecto (" ")
        File fich = new File(this.nombreFichero);
        
        System.out.println("Tamaño: "+fich.length());
        System.out.println("Líneas: " + Integer.toString(numLineas()));
        System.out.println("Palabras: " + Integer.toString(numPalabras()));       
    }
    
    /**
     * Calcula el número de lineas que tiene el fichero
     * 
     * @return int numero de líneas
     */
    public int numLineas() {
        return cuenta("\r\n");        
    }    
    
    /**
     * Cuenta el número de palabras que tiene el fichero.
     * 
     * @return int número de palabras
     */
    public int numPalabras() {
        return cuenta(" |\r\n");        
    }
    
    /**
     * Cuenta el número ocurrencias que estan separadas por el separador
     * 
     * @param delimitador 
     * @return numero de ocurrencias
     */
    private int cuenta(String delimitador) {
        Scanner lector = new Scanner(this.contenido);
        lector.useDelimiter(delimitador);
        int x=0;
        while(lector.hasNext()) { lector.next(); x++; }
        
        return x;
    }
    
    
    
    /**
     * @return the nombreFichero
     */
    public String getNombreFichero() {
        return nombreFichero;
    }

    /**
     * @param nombreFichero the nombreFichero to set
     */
    public void setNombreFichero(String nombreFichero) {
        this.nombreFichero = nombreFichero;
    }

    /**
     * @return the contenido
     */
    public String getContenido() {
        return contenido;
    }

    /**
     * @param contenido the contenido to set
     */
    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
}
