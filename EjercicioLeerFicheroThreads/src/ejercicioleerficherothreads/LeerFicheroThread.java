/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ejercicioleerficherothreads;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.text.DecimalFormat;

/**
 *
 * @author: $Author$
 * @version: $Rev$
 * @date: $Date$
 * $Id$
 */
public class LeerFicheroThread extends Thread {
    private String nombreFichero;
    private ArrayList<String> cadenas;
    
    public LeerFicheroThread(String nombreFichero) {
        this.nombreFichero = nombreFichero;
    }
    
    @Override
     public void run() {
        File fichero = new File(nombreFichero);

        // Creamos las variables que vamos a necesitar luego
        FileReader lectorFichero = null;
        Scanner lector = null;

        // Machacamos el contenido actual de las cadenas
        this.cadenas = new ArrayList<String>();

        if (fichero.exists()) {
            try {
                // Creamos el manejador de lectura del archivo
                lectorFichero = new FileReader(fichero);
                lector = new Scanner(lectorFichero);

                double bytesTotal = fichero.length();
                double bytesLeido = 0;

                DecimalFormat formateador= new DecimalFormat("##0.0");
                String progreso= "";
                String progresoAnt = null;

                lector.useDelimiter("\r\n");

                while (lector.hasNext()) {
                    String linea = lector.nextLine();
                    bytesLeido+= linea.length();
                    this.cadenas.add(linea);
                    
                    progreso = formateador.format(bytesLeido * 100 / bytesTotal);
                    if( ! progreso.equals(progresoAnt) ) {
                        System.out.print("\r" + progreso + "%");
                        progresoAnt = progreso;
                    } 
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
            } finally {
                lector.close();
                System.out.println("Fichero cargado");
            }
        } else {
            System.out.println("ERR - No se encuentra el fichero (" + fichero.getAbsoluteFile() + ")");
        }
     }


}
