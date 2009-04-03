/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package puntos;

import es.random.puntos.Poligono;
import es.random.puntos.PoligonoIncorrectoException;
import es.random.puntos.Punto;
import java.util.Scanner;

/**
 *
 * @author: $Author$
 * @version: $Rev$
 * @date: $Date$
 * $Id$
 */
public class PruebaPoligono
{

    /**
     * Probamos nuestra clase Polígono basándonos en los parametros que mete el usuario
     *
     */
    public PruebaPoligono()
    {
        // Creamos el poligono vacio que usaremos luego
        Poligono pol = poligonoNuevo();

        // Mostramos el polígono
        p("Polígono definido: " + pol.toString() + "\n");

        // Calculamos su diametro
        try {
            p("Diámetro: " + pol.calcularPerimetro() + "\n");
        } catch (PoligonoIncorrectoException ex) {
            p("Imposible calcular el diámetro, polígono incorrecto");
        }
    }

    /**
     * Pedimos al usuario los datos del polígono
     * No salimos hasta que esta todo correctamente definido.
     *
     */
    public Poligono poligonoNuevo() {
        Poligono pol = new Poligono();
        
        // Primero nos enteramos de cuantos lados tiene que ser
        int lados = 0;
        do {
            try {
                lados = (int)pideNumero("¿De cuantos lados quieres el polígono? : ");
                pol = new Poligono(lados);
            } catch (PoligonoIncorrectoException ex) {
                p("El número de lados debe ser un entero mayor que 3");
            }
        } while (lados < 3);

        // Luego pedimos al usuario que defina los vertices
        do {
            for(int n=0; n < pol.getVertices().length; n++) {
                p("** Vertice " + n + " **\n");
                double x = pideNumero("x = ");
                double y = pideNumero("y = ");

                pol.establecerVertice(n, new Punto(x,y));
            }
        } while(!pol.comprobarVertices());

        return pol;
    }

    /**
     * Pide un numero entero por pantalla
     * Lo sigue pidiendo hasta que se introduce un número válido
     *
     * @param Texto a mostrar
     * @return el numero entero
     */
    public double pideNumero(String texto) {
        boolean ok = false;
        double num = 0;

        do {
            try {
                num = new Integer(pregunta(texto));
                ok = true;
            } catch (NumberFormatException ex) {
                p("Error, debes introducir un número. Vuelve a intentarlo.\n");
                ok = false;
            }
        } while (!ok);

        return num;
    }


    public String pregunta(String pregunta)
    {
        p(pregunta);

        Scanner flujo = new Scanner(System.in);
        return flujo.nextLine();
    }

    public void p(String texto) {
        System.out.print(texto);
    }
}


