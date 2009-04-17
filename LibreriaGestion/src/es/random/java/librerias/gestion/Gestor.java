/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.random.java.librerias.gestion;

import java.io.*;
import java.lang.String;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AdminLocal
 */
public class Gestor<C extends Serializable & IFuenteDeDatos>
{

    ArrayList<C> datos;

    public Gestor()
    {
        datos = new ArrayList<C>();
    }

    public C obtenerElemento(int rowIndex)
    {
        return datos.get(rowIndex);
    }

    public int tamaño()
    {
        return datos.size();
    }

    public boolean estaVacio()
    {
        return datos.isEmpty();
    }

    public void añadirContacto(C nuevoContacto)
    {
        datos.add(nuevoContacto);
    }

    public void borrarContacto(C aEliminar)
    {
        datos.remove(aEliminar);
    }

    public void borrarContacto(int indice)
    {
        datos.remove(indice);
    }

    public boolean contieneContacto(C buscado)
    {
        return datos.contains(buscado);
    }

    public int posicionDe(C buscado)
    {
        return datos.indexOf(buscado);
    }

    @Override
    public String toString()
    {
        String cadena = "";
        for (C c : datos) {
            cadena += "****************************************\n\r";
            cadena += c.toString();
            cadena += "****************************************\n\r";
        }
        return cadena;
    }

    public void guardarTexto()
    {
        guardarTexto("default.txt");
    }

    public void cargarTexto(Class c)
    {
        cargarTexto("default.txt", c);
    }

    public void guardarTexto(String nombreFichero)
    {
        File fichero = new File(nombreFichero);
        FileWriter escritorFichero = null;
        PrintWriter escritor = null;
        try {
            if (!fichero.exists()) {
                fichero.createNewFile();
            }
            escritorFichero = new FileWriter(fichero);
            escritor = new PrintWriter(escritorFichero);
            for (C c : datos) {
                escritor.print(c.extraerTexto());
            }
        } catch (IOException ex) {
            Logger.getLogger(Gestor.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            escritor.close();
        }
    }

    private void cargarTexto(String nombreFichero, Class clase)
    {
        File fichero = new File(nombreFichero);
        FileReader lectorFichero = null;
        Scanner lector = null;
        if (fichero.exists()) {
            try {
                lectorFichero = new FileReader(fichero);
                lector = new Scanner(lectorFichero);
                lector.useDelimiter("\r\n");
                datos = new ArrayList<C>();
                C c = null;
                try {
                    c = (C) clase.newInstance();
                } catch (InstantiationException ex) {
                    Logger.getLogger(Gestor.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(Gestor.class.getName()).log(Level.SEVERE, null, ex);
                }
                String cadena = "";
                while (lector.hasNext()) {
                    cadena += lector.next() + "\r\n";
                }
                datos.clear();
                datos.addAll(c.insertarTexto(cadena));
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Gestor.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InputMismatchException ex) {
                System.out.println(ex.getMessage());
            } finally {
                lector.close();
            }
        }
    }

    public void deserializar()
    {
        File fichero = new File("serializado.dat");
        FileInputStream lectorFichero = null;
        ObjectInputStream lector = null;
        if (fichero.exists()) {
            try {
                lectorFichero = new FileInputStream(fichero);
                lector = new ObjectInputStream(lectorFichero);
                datos = (ArrayList<C>) lector.readObject();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Gestor.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Gestor.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    lector.close();
                } catch (IOException ex) {
                    Logger.getLogger(Gestor.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public void serializar()
    {
        File fichero = new File("serializado.dat");
        FileOutputStream escritorFichero = null;
        ObjectOutputStream escritor = null;
        try {
            if (!fichero.exists()) {
                fichero.createNewFile();
            }
            escritorFichero = new FileOutputStream(fichero);
            escritor = new ObjectOutputStream(escritorFichero);
            escritor.writeObject(datos);
        } catch (IOException ex) {
            Logger.getLogger(Gestor.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                escritor.close();
            } catch (IOException ex) {
                Logger.getLogger(Gestor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public String[][] obtenerMatriz()
    {
        String[][] cad = new String[0][0];

        if (tamaño() > 0) {
            cad = new String[tamaño()][obtenerNombresColumnas().length];

            int fila = 0;
            for (C c : datos) {
                cad[fila++] = c.aArray();
            }
        }
        return cad;
    }

    public String[] obtenerNombresColumnas()
    {
        if (datos.isEmpty()) {
            return new String[0];
        } else {
            return datos.get(0).obtenerNombresColumnas();
        }
    }
}
