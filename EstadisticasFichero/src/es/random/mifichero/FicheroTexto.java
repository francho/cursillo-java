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

    public FicheroTexto(String nombreFichero) {
        this.nombreFichero = nombreFichero;
        contenido = "";
    }

    public void cargar() {
        File fichero = new File(getNombreFichero());

        

        // Creamos las variables que vamos a necesitar luego
        FileReader lectorFichero = null;
        Scanner lector = null;

        if(fichero.exists()) {
            try {
                // Creamos el manejador de lectura del archivo
                lectorFichero = new FileReader(fichero);
                lector = new Scanner(lectorFichero);

                // El limitador de
                lector.useDelimiter("\r\n");

                while(lector.hasNext()) {
                    setContenido(getContenido() + lector.nextLine());
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(FicheroTexto.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                lector.close();
            }
        } else {
            System.out.println("ERR - No se encuentra el fichero (" + fichero.getAbsoluteFile() +")");
        }

    }

    public void guardar() {

    }

    public void estadisticas() {
        // Pista: para las estadisticas de palabra usar el Scanner con el delimitador por defecto (" ")
    }

    /**
     * @return the nombreFichero
     */
    public String getNombreFichero()
    {
        return nombreFichero;
    }

    /**
     * @param nombreFichero the nombreFichero to set
     */
    public void setNombreFichero(String nombreFichero)
    {
        this.nombreFichero = nombreFichero;
    }

    /**
     * @return the contenido
     */
    public String getContenido()
    {
        return contenido;
    }

    /**
     * @param contenido the contenido to set
     */
    public void setContenido(String contenido)
    {
        this.contenido = contenido;
    }



}
