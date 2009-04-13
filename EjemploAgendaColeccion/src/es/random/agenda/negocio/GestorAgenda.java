/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.random.agenda.negocio;

import es.random.agenda.datos.Contacto;
import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AdminLocal
 */
public class GestorAgenda
{

    ArrayList<Contacto> contactos;

    public GestorAgenda()
    {
        contactos = new ArrayList<Contacto>();
    }

    public int tamaño()
    {
        return contactos.size();
    }

    public boolean estaVacio()
    {
        return contactos.isEmpty();
    }

    public void añadirContacto(Contacto nuevoContacto)
    {
        contactos.add(nuevoContacto);
    }

    public void borrarContacto(Contacto aEliminar)
    {
        contactos.remove(aEliminar);
    }

    public void borrarContacto(int indice)
    {
        contactos.remove(indice);
    }

    public void borrarContacto(String[] nombre)
    {
        if (nombre.length > 0)
        {
            Contacto borrable = new Contacto();
            borrable.setNombre(nombre[0]);
            if (nombre.length > 1)
            {
                borrable.setPrimerApellido(nombre[1]);
                if (nombre.length > 2)
                {
                    borrable.setSegundoApellido(nombre[2]);
                }
            }
            contactos.remove(borrable);
        }
    }

    public boolean contieneContacto(Contacto buscado)
    {
        return contactos.contains(buscado);
    }

    public int posicionDe(Contacto buscado)
    {
        return contactos.indexOf(buscado);
    }

    @Override
    public String toString()
    {
        String cadena = "";
        for (Contacto c : contactos)
        {
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

    public void cargarTexto()
    {
        cargarTexto("default.txt");
    }

    public void guardarTexto(String nombreFichero)
    {
        File fichero = new File(nombreFichero);
        FileWriter escritorFichero = null;
        PrintWriter escritor = null;
        try
        {
            if (!fichero.exists())
            {
                fichero.createNewFile();
            }
            escritorFichero = new FileWriter(fichero);
            escritor = new PrintWriter(escritorFichero);
            for (Contacto c : contactos)
            {
                escritor.print(c.getNombre() + "\r\n");
                escritor.print(c.getPrimerApellido() + "\r\n");
                escritor.print(c.getSegundoApellido() + "\r\n");
                escritor.print(c.getDireccion() + "\r\n");
                escritor.print(c.getEMail() + "\r\n");
                escritor.print(c.getTelefonoFijo() + "\r\n");
                escritor.print(c.getTelefonoMovil() + "\r\n");
            }
        } catch (IOException ex)
        {
            Logger.getLogger(GestorAgenda.class.getName()).log(Level.SEVERE, null, ex);
        } finally
        {
            escritor.close();
        }
    }

    private void cargarTexto(String nombreFichero)
    {
        File fichero = new File(nombreFichero);
        FileReader lectorFichero = null;
        Scanner lector = null;
        if (fichero.exists())
        {
            try
            {
                lectorFichero = new FileReader(fichero);
                lector = new Scanner(lectorFichero);
                lector.useDelimiter("\r\n");
                contactos = new ArrayList<Contacto>();
                while (lector.hasNext())
                {
                    Contacto c = new Contacto();
                    c.setNombre(lector.nextLine());
                    c.setPrimerApellido(lector.nextLine());
                    c.setSegundoApellido(lector.nextLine());
                    c.setDireccion(lector.nextLine());
                    c.setEMail(lector.nextLine());
                    c.setTelefonoFijo(Long.parseLong(lector.nextLine()));
                    c.setTelefonoMovil(Long.parseLong(lector.nextLine()));
                    añadirContacto(c);
                }
            } catch (FileNotFoundException ex)
            {
                Logger.getLogger(GestorAgenda.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InputMismatchException ex)
            {
                System.out.println(ex.getMessage());
            } finally
            {
                lector.close();
            }
        }
    }

    public void deserializar()
    {
        File fichero = new File("serializado.dat");
        FileInputStream lectorFichero = null;
        ObjectInputStream lector = null;
        if (fichero.exists())
        {
            try
            {
                lectorFichero = new FileInputStream(fichero);
                lector = new ObjectInputStream(lectorFichero);
                contactos = (ArrayList<Contacto>) lector.readObject();
            } catch (ClassNotFoundException ex)
            {
                Logger.getLogger(GestorAgenda.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex)
            {
                Logger.getLogger(GestorAgenda.class.getName()).log(Level.SEVERE, null, ex);
            } finally
            {
                try
                {
                    lector.close();
                } catch (IOException ex)
                {
                    Logger.getLogger(GestorAgenda.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public void serializar()
    {
        File fichero = new File("serializado.dat");
        FileOutputStream escritorFichero = null;
        ObjectOutputStream escritor = null;
        try
        {
            if (!fichero.exists())
            {
                fichero.createNewFile();
            }
            escritorFichero = new FileOutputStream(fichero);
            escritor = new ObjectOutputStream(escritorFichero);
            escritor.writeObject(contactos);
        } catch (IOException ex)
        {
            Logger.getLogger(GestorAgenda.class.getName()).log(Level.SEVERE, null, ex);
        } finally
        {
            try
            {
                escritor.close();
            } catch (IOException ex)
            {
                Logger.getLogger(GestorAgenda.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
