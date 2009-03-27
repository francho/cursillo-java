/*
 * Clase que comprueba el funcionamiento de la clase Punto según el enunciado
 */
package puntos;

import es.random.puntos.Punto;

/**
 *
 * @author: $Author$
 * @version: $Rev$
 * @date: $Date$
 * $Id$
 */
public class PruebaPuntos
{

    private Punto punto;

    PruebaPuntos()
    {
        punto = new Punto();
    }

    public void apartado1()
    {
        punto = new Punto(1, 2);
    }

    public void apartado2()
    {
        p("Representacion del punto " + punto);
    }

    public void apartado3(String[] args)
    {
        if (args.length != 2) {
            p("Error, necesito dos argumentos para definir un punto.");
        } else {
            double x = new Double(args[0]);
            double y = new Double(args[1]);

            punto = new Punto(x, y);
        }
    }

    /**
     * Apartado 4: Distancia al origen
     *
     */
    public void apartado4()
    {
        p("Distancia al origen: " + punto.calcularDistanciaOrigen());
    }

    /**
     *  Apartado 5: Métodos get
     */
    public void apartado5()
    {
        p("x = " + punto.getX());
        p("y = " + punto.getY());
    }

    /**
     * Apartado 6: Distancia entre dos puntos
     */
    public void apartado6()
    {
        Punto punto2 = new Punto(10, 20);
        p("La distancia a " + punto2.toString() + " es: " + punto.calcularDistancia(punto2) );
    }

    /**
     * Apartado 7
     */
    public void apartado7() {
        punto.setX(0);
        punto.setY(0);

        p(punto.toString() + " Cuadrante: " + punto.calcularCuadrante());

        punto.setX(1);
        punto.setY(1);
        p(punto.toString() + " Cuadrante: " + punto.calcularCuadrante());

        punto.setX(-1);
        p(punto.toString() + " Cuadrante: " + punto.calcularCuadrante());

        punto.setY(-1);
        p(punto.toString() + " Cuadrante: " + punto.calcularCuadrante());

        punto.setX(1);
        p(punto.toString() + " Cuadrante: " + punto.calcularCuadrante());
    }

    /**
     * Apartado 8
     */

    public void apartado8() {
        punto.setX(2);
        punto.setY(2);

        Punto[] puntos = new Punto[3];
        puntos[0] = new Punto(10,10);
        puntos[1] = new Punto(1,2);
        puntos[2] = new Punto(4,2);

        Punto cercano = punto.calcularMasCercano(puntos);

        p(punto.toString() + " el mas cercano de la lista es " + cercano.toString());
    }

    /**
     * Método alias que muestra el parámetro recibido por pantalla
     * Creado por legibilidad del código
     *
     * @param texto a mostrar
     */
    public void p(String texto)
    {
        System.out.println(texto);
    }
}
