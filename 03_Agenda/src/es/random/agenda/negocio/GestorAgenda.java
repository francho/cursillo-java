/*
 * El controlador de nuestra aplicaciones
 *
 */

package es.random.agenda.negocio;

import es.random.agenda.datos.Contacto;

/**
 *
 * @author: $Author$
 * @version: $Rev$
 * @date: $Date$
 * $Id$
 */
public class GestorAgenda {
    Contacto[] contactos;

    public GestorAgenda(){
        contactos = new Contacto[0]; // Inicializamos el vector
    }

    /**
     * Añade un contacto al vector
     * @param nuevoContacto datos del nuevo contacto a incluir
     */
    public void AñadirContacto(Contacto nuevoContacto) {
        // Necesitamos ampliar el tamaño de nuestro vector, así que creamos uno
        // del tamaño que necesitamos.
        Contacto[] nuevaLista = new Contacto[contactos.length + 1];

        // Si ya hay contactos anteriores debemos copiarlos primero
        if(contactos.length > 0) {
            for(int i = 0; i < contactos.length; i++) {
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
    public void borrarContacto(int indice) {
        // La lista tendrá ahora un contacto menos
        Contacto[] nuevaLista = new Contacto[contactos.length - 1];

        int y = 0;
        for(int x = 0; x < contactos.length - 1; x++) {
            if(x != indice) {
                nuevaLista[y++] = contactos[x];
            }
        }
        contactos = nuevaLista;
    }

    /**
     * Borra un contacto
     *
     * @param aEliminar objeto de tipo Contacto
     */

    public void borrarContacto(Contacto aEliminar) {
        // Buscar indice
        // Llamar a borrar por ind
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
    public void borrarContacto(String[] nombre) {
        // Crear nuevo objeto
        // Llamar a borrar pasando el contacto
    }
    
    public int buscarIndiceContacto(Contacto aBuscar) {
        // TODO -
    }
}
