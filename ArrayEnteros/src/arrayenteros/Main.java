/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package arrayenteros;

import es.random.arrayenteros.ArrayEnteros;
import es.random.arrayenteros.ArrayEnterosUnicos;

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
        //ArrayEnteros arr = new ArrayEnteros();
        ArrayEnteros arr = new ArrayEnterosUnicos();

        arr.añadir(5);
        arr.añadir(3);
        arr.añadir(3);
        arr.añadir(3);
        arr.añadir(3);
        arr.añadir(1);

        System.out.println(arr.toString());

        // Como el metodo insertar es protected y esta en otro paquete no puedo
        // llamarlo desde aqui:
        //
        // arr.insertar(5);

        arr.borrar(3);

        System.out.println(arr.toString());

        
    }

}
