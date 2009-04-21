/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciovectordinamico;

/**
 *
 * @author: $Author$
 * @version: $Rev$
 * @date: $Date$
 * $Id$
 */
public class VectorDinamicoSincronizado {

    protected String[] datos;
    final static int TIMEOUT = 1000;

    public VectorDinamicoSincronizado() {
        datos = new String[0];
    }

    /**
     * Añade un número al final de la lista
     *
     * @param numero a insertar
     */
    public void añadir(String texto) {
        //insertarOrdenado(numero);
        String[] nuevo = new String[datos.length + 1];
        for (int i = 0; i < datos.length; i++) {
            nuevo[i] = datos[i];
        }
        nuevo[datos.length] = texto;
        datos = nuevo;
        loguea("pongo " + texto + " al final");
    }

    /**
     * Añade una cadena en una determinada posicion
     *
     * @param texto a añadir
     * @param posicion posición donde colocarlo
     */
    public synchronized void añadirEn(String texto, int posicion) {

        try {  // Si la posición que intentamos insertar está fuera del vector actual
            // Esperamos a ver si hay suerte y el vector crece
            while(posicion > (datos.length - 1)) {
                loguea("no puedo insertar " + texto + " en posicion " + posicion + " espero...");
                wait(TIMEOUT);
            }
            datos[posicion] = texto;
            loguea("pongo " + texto + " en " + posicion);

        } catch (InterruptedException ex) {
            // Logger.getLogger(VectorDinamicoSincronizado.class.getName()).log(Level.SEVERE, null, ex);
            loguea("HILO TERMINADO: no puedo insertar " + texto + " en posicion " + posicion + " abandono");
        }

        notifyAll();
    }

    public synchronized void borrar(int posicion) {
        String [] nueva = new String[datos.length -1];
        int n=0;

        for(int i=0;i<datos.length;i++) {
            if(i!=posicion) {
                nueva[n++] = datos[i];
            }
        }

        datos = nueva;
    }

    /**
     * Muestra por pantalla un mensaje de debug
     *
     * @param texto a mostrar
     */
    public void loguea(String texto) {
        System.out.println(Thread.currentThread().toString() + texto);
    }

    /**
     * Maqueta el contenido
     *
     * @return cadena con todos los numeros del array
     */
    @Override
    public String toString() {
        String cad = "[ ";
        for (String d : datos) {
            cad += "" + d + " ";
        }
        cad += "]";

        return cad;
    }
}
