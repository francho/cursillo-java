package es.random.gestorcadenas;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.B4C6CBC8-C5CB-1868-08FC-6B1F432A5BAA]
// </editor-fold> 
public class GestorCadenas extends Gestor implements Buscador {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.02A730D7-FCAB-26FF-AB6A-00C1C1DF7DC5]
    // </editor-fold> 
    private ArrayList<String> cadenas;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.6CF43914-698C-1CE4-C801-A231AD751E9C]
    // </editor-fold> 
    public GestorCadenas() {
        // Inicializamos la colecion de datos
        // el <String> indica que solo va a trabajar con elementos de tipo String
        cadenas = new ArrayList<String>();
    }
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.734EC5A9-C724-319A-BAC4-9FDB864FF668]
    // </editor-fold> 
    public ArrayList<String> getCadenas() {
        return cadenas;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.67B2218B-22E7-2E9C-6F18-CA49DD04E556]
    // </editor-fold> 
    public void setCadenas(ArrayList<String> val) {
        this.cadenas = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.41F93B78-372C-A23C-9275-2B3495B9F593]
    // </editor-fold> 
    public int buscar(String cadena) {
        return buscar(cadena, 0);
    }

    /**
     * Busca un texto empezando en una determinada linea
     * 
     * @param cadena a buscar
     * @param lineaInicio linea en la que empezar a buscar
     * @return
     */
    public int buscar(String cadena, int lineaInicio) {
        int contador = lineaInicio;
        int encontrado = -1;

        while ((contador < cadenas.size()) && (encontrado == -1)) {
            String aux = cadenas.get(contador);

            if (aux.contains(cadena)) {
                encontrado = contador;
            } else {
                contador++;
            }
        }

        return encontrado;
    }

    public void reemplazarTodo(String busca, String reemplaza) {
        int contador = 0;
        while ((contador < cadenas.size())) {
            String nueva = cadenas.get(contador).replaceAll(busca, reemplaza);
            cadenas.set(contador, nueva);
            contador++;
        }

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

            for (String linea : this.cadenas) {
                escritor.print(linea + "\r\n");
            }
            escritor.flush();
        } catch (IOException ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
        } finally {
            escritor.close();
        }

    }
}
