/*
 * Implementa para manejar triangulos rectángulos isósceles
 */

package es.random.geometria;

/**
 *
 * @author: $Author$
 * @version: $Rev$
 * @date: $Date$
 * $Id$
 */
public class TrianguloRectangulo extends Triangulo {

    public TrianguloRectangulo(double lado) {
        super(lado,lado,90);
    }

    @Override
    public void dibujarTxt() {
        for(int x = 0;x < getLado1();x++) {
            for(int y = 0;y <= x;y++) {
                System.out.print(" ·");
            }
            System.out.println();
        }
    }
}
