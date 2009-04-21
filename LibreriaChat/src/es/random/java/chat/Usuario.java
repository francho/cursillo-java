/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.random.java.chat;

import es.random.java.chat.Mensaje.Tipo;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ernesto.cuevas
 */
public class Usuario implements Runnable
{

    private String nombre;
    private Socket puerto;
    private ObjectOutputStream escritor;
    private ObjectInputStream lector;

    public Usuario()
    {
        nombre = "";
        puerto = new Socket();
        inicializarFlujos();
    }

    public Usuario(String nombre)
    {
        this();
        this.nombre = nombre;
        inicializarFlujos();
    }

    public Usuario(String nombre, Socket puerto)
    {
        this(nombre);
        this.puerto = puerto;
        inicializarFlujos();
    }

    private void inicializarFlujos()
    {
        try
        {
            escritor = new ObjectOutputStream(puerto.getOutputStream());
            lector = new ObjectInputStream(puerto.getInputStream());
        }
        catch (IOException ex)
        {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void enviarMensaje(Mensaje nuevoMensaje)
    {
        try
        {
            escritor.writeObject(nuevoMensaje);
            escritor.flush();
        }
        catch (IOException ex)
        {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void run()
    {
        Mensaje nuevoMensaje = new Mensaje();
        do
        {
            try
            {
                nuevoMensaje = (Mensaje) lector.readObject();
            }
            catch (IOException ex)
            {
                Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
            }
            catch (ClassNotFoundException ex)
            {
                Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (nuevoMensaje.getTipo() != Tipo.Salir)
            {
                enviarMensaje(nuevoMensaje);
            }
        }
        while (nuevoMensaje.getTipo() != Tipo.Salir);
        try
        {
            escritor.close();
            lector.close();
        }
        catch (IOException ex)
        {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
