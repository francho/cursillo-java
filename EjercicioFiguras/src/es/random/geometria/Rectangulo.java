/*
 * Implementa la figura geométrica rectángulo
 *
 */

package es.random.geometria;

/**
 *
 * @author: $Author$
 * @version: $Rev$
 * @date: $Date$
 * $Id$
 */
public class Rectangulo extends FiguraGeometrica {
    private int base = 0;
    private int altura = 0;
    

    public Rectangulo(int base, int altura) {
        setTipoFigura("Rectángulo");
        this.base = base;
        this.altura = altura;
    }

    public double calcularArea()
    {
        return base * altura;
    }

    /**
     * Dibuja el rectángulo usando caracteres ASCII
     */
    public void dibujarTxt()
    {
        for( int y = 0 ; y < altura ; y++ ) {
            for( int x = 0; x < base ; x++ ) {
                System.out.print(" · ");
            }
            System.out.print("\n");
        }
    }

    @Override
    public String toString() {
        return "( " + base + " x " + altura + " )";
    }

    /**
     * @return the base
     */
    public int getBase()
    {
        return base;
    }

    /**
     * @param base the base to set
     */
    public void setBase(int base)
    {
        this.base = base;
    }

    /**
     * @return the altura
     */
    public int getAltura()
    {
        return altura;
    }

    /**
     * @param altura the altura to set
     */
    public void setAltura(int altura)
    {
        this.altura = altura;
    }



}
