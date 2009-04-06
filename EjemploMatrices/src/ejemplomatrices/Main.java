/*
 * Ejemplo que ilustra el uso de matrices
 *
 */

package ejemplomatrices;

/**
 *
 * @author: $Author$
 * @version: $Rev$
 * @date: $Date$
 * $Id$
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Creamos una matriz de enteros
        // Las matrices son vectores de vectores
        int[][] matriz;

        // Inicializamos la matriz entera
        matriz = new int[5][5];

        // Otra forma de inicializar: parcialmente
        // Luego deberemos incializar los elementos
        matriz = new int[5][];
        for(int x=0; x < matriz.length; x++) {
            // Inicializamos cada uno de los elementos de un tamaño distinto
            matriz[x] = new int[x];
        }

        // La recorremos entera llenadola de valores.
        // hay que tener cuidado por que no sabemos con certeza del la dimension exacta

        for(int x=0; x<matriz.length; x++) {
            for(int y=0;y < matriz[x].length; y++) {
                matriz[x][y] = x*y;
                System.out.print(matriz[x][y] + " ");
            }
            System.out.println();
        }

    }

}
