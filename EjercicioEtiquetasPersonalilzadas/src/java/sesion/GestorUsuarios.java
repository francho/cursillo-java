/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sesion;

import java.io.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AdminLocal
 */
public class GestorUsuarios implements Serializable {

    private ArrayList<Usuario> usuarios;

    public GestorUsuarios() {
        cargarUsuarios();
    }

    public void añadirUsuario(Usuario u) {
        usuarios.add(u);
    }

    public boolean validarUsuario(Usuario u) {
        Boolean validado = false;
        for (Usuario us : usuarios) {
            if (us.getIdentificador().equals(u.getIdentificador()) && us.getPassword().equals(u.getPassword())) {
                validado = true;
                us.setValidado(true);
                u.setNombreCompleto(us.getNombreCompleto());
                u.setValidado(true);
            }
        }
        return validado;
    }

    public void cargarUsuarios() {
        File fichero = new File("usuarios.dat");
        ObjectInputStream entrada = null;
        if (fichero.exists()) {
            try {
                entrada = new ObjectInputStream(new FileInputStream(fichero));
                usuarios = (ArrayList<Usuario>) entrada.readObject();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(GestorUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(GestorUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(GestorUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            }finally{
                try {
                    entrada.close();
                } catch (IOException ex) {
                    Logger.getLogger(GestorUsuarios.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        } else {
            usuarios = new ArrayList<Usuario>();
        }
    }

    public void guardarUsuarios() {
        File fichero = new File("usuarios.dat");
        ObjectOutputStream salida = null;
        if (!(fichero.exists())) {
            try {
                fichero.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(GestorUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try {
            salida = new ObjectOutputStream(new FileOutputStream(fichero));
            salida.writeObject(usuarios);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GestorUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GestorUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                salida.close();
            } catch (IOException ex) {
                Logger.getLogger(GestorUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}
