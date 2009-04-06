/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.random.matrices;

/**
 *
 * @author: $Author$
 * @version: $Rev$
 * @date: $Date$
 * $Id$
 */
public class GestorMatriz
{

    InfoPalabra[][] matriz;

    public GestorMatriz()
    {
        matriz = new InfoPalabra[26][];

        for (int i = 0; i < matriz.length; i++) {
            matriz[i] = new InfoPalabra[0];
        }
    }

    /**
     * Añade o actualiza las estadísticas de aparicion de una determinada palabra
     * Si la palabra ya está incrementa en uno su valor
     *
     * @param nuevaPalabra
     */
    public void añadirPalabra(String nuevaPalabra)
    {
        // Nos quedamos con la primera letra
        char letra = nuevaPalabra.toLowerCase().charAt(0);
        
        // Si la palabra empieza por letra la contabilizamos
        if(letra >= 'a' && letra <= 'z') {
            // Vemos su posición dentro del abecedario
            char pos = (char) (letra - 'a');

            // Importante: como java pasa los parametros por referencia,
            // debemos asignar la matriz que nos devuelve a la matriz de palabras para que se actualice
            matriz[pos] = añadirPalabra(matriz[pos], nuevaPalabra.toLowerCase());
        }
    }

    /**
     * Para manejarnos mejor, usamos solo le vector de palabras que empiezan por la letra de la nueva
     *
     * @param vector puntero al vector de palabras que empiezan por la misma letra
     * @param nuevaPalabra palabra a incluir en las estadísticas
     * @return vector actualizado
     */
    public InfoPalabra[] añadirPalabra(InfoPalabra[] vector, String nuevaPalabra)
    {
        int pos = buscaPalabra(vector, nuevaPalabra);

        // Si no está la palabra la añadimos en su sitio (ordenada alfabéticamente)
        if (pos < 0) {
            // Redimensionamos el vector
            InfoPalabra nuevo[] = new InfoPalabra[vector.length + 1];
            int j = 0;
            boolean insertado = false;

            // Copiamos el vector al nuevo redimensionado;
            for (int i = 0; i < vector.length; i++) {
                if (nuevaPalabra.compareTo(vector[i].palabra) < 0) {
                    nuevo[j] = new InfoPalabra();
                    nuevo[j].palabra = nuevaPalabra;
                    nuevo[j].apariciones = 1;
                    j++;
                    insertado = true;
                }
                nuevo[j++] = vector[i];
            }

            // Si no lo ha insertado todavía lo pongo al final
            if (!insertado) {
                nuevo[j] = new InfoPalabra();
                nuevo[j].palabra = nuevaPalabra;
                nuevo[j].apariciones = 1;
            }
            // A partir de ahora el que vale es el nuevo vector
            vector = nuevo;
        } else {
            // Ya tenemos la palabra, pues incrementamos el contador
            vector[pos].apariciones++;
        }

        return vector;
    }

    /**
     * Busca una determinada palabra el su vector
     *
     * @param vector palabras que empiezan por la misma letra
     * @param palabra palabra a buscar
     * @return posicion donde está o -1 si no encontrado
     */
    public int buscaPalabra(InfoPalabra[] vector, String palabra)
    {
        int pos;
        int encontrada = -1;
        for (pos = 0; (pos < vector.length) && (encontrada < 0); pos++) {
            if (vector[pos].palabra.equals(palabra)) {
                encontrada = pos;
            }
        }
        return encontrada;
    }

    @Override
    public String toString()
    {
        String r = "";

        for (int i = 0; i < matriz.length; i++) {
            r += "** " + (char) ('a' + i) + " **\n";
            for (int j = 0; j < matriz[i].length; j++) {
                r += "\t" + matriz[i][j].palabra + ": " + matriz[i][j].apariciones + "\n";
            }
        }


        return r;
    }
}
