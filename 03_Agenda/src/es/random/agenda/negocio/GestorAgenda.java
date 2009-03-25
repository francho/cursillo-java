/*
 * Clase que contiene un array de numeros enteros
 *
 * Debe poder:
 *  - Añadir un entero
 *  - Borrar un entero
 *  - Buscar la posicion de un entero
 *  - Comprobar si contiene un valor
 *
 * Condiciones:
 *  - El array debe estar ordenado
 *
 */
package es.random.agenda.negocio;

import es.random.agenda.datos.Contacto;

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
public class GestorAgenda
{

    Contacto[] contactos;

    public GestorAgenda()
    {
        contactos = new Contacto[0]; // Inicializamos el vector
    }

    /**
     * Añade un contacto al vector
     * @param nuevoContacto datos del nuevo contacto a incluir
     */
    public void añadirContacto(Contacto nuevoContacto)
    {
        // Necesitamos ampliar el tamaño de nuestro vector, así que creamos uno
        // del tamaño que necesitamos.
        Contacto[] nuevaLista = new Contacto[contactos.length + 1];

        // Si ya hay contactos anteriores debemos copiarlos primero
        if (contactos.length > 0) {
            for (int i = 0; i < contactos.length; i++) {
                nuevaLista[i] = contactos[i];
            }
        }
        // En el último añadimos el nuevo
        nuevaLista[nuevaLista.length - 1] = nuevoContacto;

        // Sobreescribimos el vector antiguo con la nueva
        contactos = nuevaLista;
    }

    /**
     * Borra un contacto del vector
     *
     * @param indice número de contacto a borrar
     */
    public void borrarContacto(int indice)
    {
        // La lista tendrá ahora un contacto menos
        Contacto[] nuevaLista = new Contacto[contactos.length - 1];

        int y = 0;
        for (int x = 0; x < contactos.length; x++) {
            if (x != indice) {
                nuevaLista[y] = contactos[x];
                y++;
            }
        }
        contactos = nuevaLista;
    }

    /**
     * Borra un contacto a partir de un objeto contacto
     *
     * Primero busca su indice y luego llama a borrar por indice
     *
     * @param aEliminar objeto de tipo Contacto
     */
    public void borrarContacto(Contacto aEliminar)
    {
        int indice = posicionDe(aEliminar);
        if (indice > -1) {
            borrarContacto(indice);
        }
    }

    /**
     * Borra un contacto
     *
     * Parametros variables. Puede recibir:
     *  - nombre
     *  - nombre + apellido
     *  - nombre + apellido + apellido
     *
     * @param nombre nombre a borrar
     */
    public void borrarContacto(String[] nombre)
    {

        if (nombre.length > 0) {
            Contacto c = new Contacto();
            c.setNombre(nombre[0]);
            if (nombre.length > 1) {
                c.setPrimerApellido(nombre[1]);
            } else if (nombre.length > 2) {
                c.setSegundoApellido(nombre[2]);
            }
            borrarContacto(c);
        }
    }

    /**
     * Busca la posicion de un objeto Contacto dentro del array de contactos
     *
     * @param aBuscar Contacto a buscar
     * @return int posicion del contacto
     */
    public int posicionDe(Contacto aBuscar)
    {
        int encontrado = -1;

        for (int i = 0; (i < contactos.length) && (encontrado == -1); i++) {
            if (contactos[i].equals(aBuscar)) {
                encontrado = i;
            }
        }
        return encontrado;
    }

    /**
     * Envoltorio de la funcion posicionDe
     *
     * @param aBuscar Contacto a buscar
     * @return true si está en la coleccion, false sino
     */
    public boolean contieneContacto(Contacto aBuscar)
    {
        return (posicionDe(aBuscar) > -1);
    }

    /**
     * Genera una cadena con todos los contactos separados por saltos de linea
     *
     * @return cadena con los contactos
     */
    @Override
    public String toString()
    {
        String cadena = "";

        int x = 0;

        System.out.println(contactos.length + " contactos encontrados.");

        // Otra forma de bucle
        // Recorre colecciones de datos (similar al foreach de php)
        for (Contacto c : contactos) {
            cadena += "\n(" + x++ + ") " +
                    "\t" + c.toString().replaceAll("\n", "\n\t");
        }

        return cadena;
    }

    /**
     * Guarda en el fichero de texto por defecto.
     */
    public void guardarTexto()
    {
        guardarTexto("default.txt");
    }

    /**
     * Guarda en un fichero de texto, permite poner el nombre del fichero
     * 
     * @param nombreFichero nombre de fichero donde guardar
     */
    public void guardarTexto(String nombreFichero)
    {
        // Creamos el gestor de fichero (necesita el nombre)
        File fichero = new File(nombreFichero);

        // Creamos el flujo que se encargará de escrir el fichero
        // Debemos hacerlo fuera del try para asegurarnos que se ejecuta

        FileWriter escritorFichero = null;
        PrintWriter escritor = null;

        try {
            // Lo primero de todo, si no existe el fichero lo creamos
            if (!fichero.exists()) {
                fichero.createNewFile();
            }
            // Asociamos el flujo con el fichero
            escritorFichero = new FileWriter(fichero);
            // Envolvemos nuestro flujo para añadirle características de
            // escritura de fichero de texto
            escritor = new PrintWriter(escritorFichero);

            // Por cada contacto escribimos sus datos
            for (Contacto c : contactos) {
                escritor.print(c.getNombre()+"\r\n");
                escritor.print(c.getPrimerApellido()+"\r\n");
                escritor.print(c.getSegundoApellido()+"\r\n");
                escritor.print(c.getDireccion()+"\r\n");
                escritor.print(c.getEmail()+"\r\n");
                escritor.print(c.getTelefonoFijo()+"\r\n");
                escritor.print(c.getTelefonoMovil()+"\r\n");
            }
        } catch (IOException ex) {
            Logger.getLogger(GestorAgenda.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // Cerramos el flujo
            // al cerrarlo se cierran todos los flujos que envuelve
            // (no es necesario cerrarlos uno a uno)
            escritor.close();
        }
    }

    public void cargarTexto()
    {
        cargarTexto("default.txt");
    }

    /**
     * Carga los datos de nuestro fichero de texto
     *
     * @param nombreFichero nombre del fichero de datos
     */
    public void cargarTexto(String nombreFichero) {
        File fichero = new File(nombreFichero);

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

                // Nos aseguramos de que nuestra lista está vacía
                contactos = new Contacto[0];
                while(lector.hasNext()) {
                    Contacto c = new Contacto();
                    c.setNombre(lector.nextLine());
                    c.setPrimerApellido(lector.nextLine());
                    c.setSegundoApellido(lector.nextLine());
                    c.setDireccion(lector.nextLine());
                    c.setEmail(lector.nextLine());
                    c.setTelefonoFijo(Long.parseLong(lector.nextLine()));
                    c.setTelefonoMovil(Long.parseLong(lector.nextLine()));
                    this.añadirContacto(c);
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(GestorAgenda.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                lector.close();
            }

        }
    }
}
