package es.random.ficheros;

import java.io.*;
import java.util.ArrayList; 
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class GestorFicheroTexto  {


    private ArrayList<String> cadenas;

    public GestorFicheroTexto () {
        // Inicializamos la colecion de datos
        // el <String> indica que solo va a trabajar con elementos de tipo String
        cadenas = new ArrayList<String>();
    }

    public ArrayList<String> getCadenas () {
        return cadenas;
    }

    public void setCadenas (ArrayList<String> val) {
        this.cadenas = val;
    }

    public void setCadenas (String texto) {
        cadenas = new ArrayList<String>();

        Scanner lector = new Scanner(texto);

                // El limitador de
                lector.useDelimiter("\r\n");

                while (lector.hasNext()) {
                    this.cadenas.add(lector.nextLine());
                }
    }


    public int buscar (String cadena) {
        int contador = 0;

        int encontrado = -1;

        while((contador < cadenas.size()) && (encontrado == -1) ) {
            String aux = cadenas.get(contador++);
            
            if(aux.contains(cadena)) {
                encontrado = contador;
            }
        }

        return encontrado;
    }

    public void cargarArchivo(String nombreFichero) {
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

                // El limitador de
                lector.useDelimiter("\r\n");

                while (lector.hasNext()) {
                    this.cadenas.add(lector.nextLine());
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
            } finally {
                lector.close();
            }
        } else {
            System.out.println("ERR - No se encuentra el fichero (" + fichero.getAbsoluteFile() + ")");
        }
    }

    public void guardarArchivo(String nombreFichero) {
         // Creamos el gestor de fichero (necesita el nombre)
        File fichero = new File(nombreFichero);

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

            for(String linea: this.cadenas) {
                escritor.print(linea+"\r\n");
            }
            escritor.flush();
        } catch (IOException ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
        } finally {
            escritor.close();
        }

    }
}

