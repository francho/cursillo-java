/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ejemplosthreads;

/**
 *
 * @author AdminLocal
 */
public class EjemploSincronizacion {
    String[] cadenas;

    public EjemploSincronizacion(int tamaño)
    {
        cadenas = new String[tamaño];
    }

    public synchronized void añadirEn(String texto, int posicion)
    {
        if(cadenas[posicion]!= null)
        {
            return;
        }
        else
        {
            cadenas[posicion] = texto;
        }
    }

        public void borrarDe(String texto, int posicion)
    {
        if(cadenas[posicion]!= null)
        {
            return;
        }
        else
        {
            synchronized(this)
            {
                cadenas[posicion] = texto;
            }
        }
    }

}
