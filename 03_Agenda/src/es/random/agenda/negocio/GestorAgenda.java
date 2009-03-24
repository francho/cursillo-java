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
        for(int x = 0; x < contactos.length ; x++) {
            if(x != indice) {
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

    public void borrarContacto(Contacto aEliminar) {
        int indice = posicionDe(aEliminar);
        if(indice > -1) {
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
    public void borrarContacto(String[] nombre) {

        if(nombre.length > 0) {
            Contacto c = new Contacto();
            c.setNombre(nombre[0]);
            if(nombre.length > 1) {
                c.setPrimerApellido(nombre[1]);
            } else if(nombre.length > 2) {
                c.setSegundoApellido(nombre[2]);
            }
            borrarContacto(c);
        }
    }
    
    public int posicionDe(Contacto aBuscar) {
        int i=0;
        int encontrado = -1;

        do {
            if(contactos[i].equals(aBuscar)) {
                encontrado = i;
            }          
        } while( (i++ < contactos.length) && ( encontrado == -1 ) );


        return encontrado;
    }

    /**
     * Envoltorio de la funcion posicionDe
     *
     * @param aBuscar Contacto a buscar
     * @return true si está en la coleccion, false sino
     */
    public boolean contieneContacto(Contacto aBuscar) {
        return (posicionDe(aBuscar) > -1);
    }

    /**
     * Genera una cadena con todos los contactos separados por saltos de linea
     *
     * @return cadena con los contactos
     */
    @Override
    public String toString() {
        String cadena = "";

        int x=0;

        System.out.println(contactos.length);

        // Otra forma de bucle
        // Recorre colecciones de datos (similar al foreach de php)
        for(Contacto c: contactos) {
            cadena += "\n("+ x++ +") \n" + c.toString();
        }

        return cadena;
    }
}
