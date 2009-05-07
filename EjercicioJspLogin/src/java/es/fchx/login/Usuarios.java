/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.fchx.login;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrador
 */
public class Usuarios {
    ArrayList<UsuarioBean> usuarios;

    public Usuarios() {
        usuarios = new ArrayList<UsuarioBean>();
        try {
            cargarUsuarios();
        } catch (FileNotFoundException ex) {
            // Si no puede cargar los datos, creamos un nuevo fichero de contraseñas
            guardarUsuarios();
        }
    }

    public boolean usuarioAutentificado(UsuarioBean u) {

        return usuarios.contains(u);
        
    }


    public void nuevoUsuario(UsuarioBean u) {
        usuarios.add(u);
        guardarUsuarios();
    }

    public void cargarUsuarios() throws FileNotFoundException
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
                usuarios = (ArrayList<UsuarioBean>) lector.readObject();
            } catch (ClassNotFoundException ex)
            {
                Logger.getLogger(Usuarios.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex)
            {
                Logger.getLogger(Usuarios.class.getName()).log(Level.SEVERE, null, ex);
            } finally
            {
                try
                {
                    lector.close();
                } catch (IOException ex)
                {
                    Logger.getLogger(Usuarios.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public void guardarUsuarios()
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
            escritor.writeObject(usuarios);
        } catch (IOException ex)
        {
            Logger.getLogger(Usuarios.class.getName()).log(Level.SEVERE, null, ex);
        } finally
        {
            try
            {
                escritor.close();
            } catch (IOException ex)
            {
                Logger.getLogger(Usuarios.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
