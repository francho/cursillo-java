/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciofiguras;

import es.random.geometria.Cuadrado;
import es.random.geometria.FiguraGeometrica;
import es.random.geometria.Rectangulo;
import es.random.geometria.TrianguloRectangulo;
import es.random.interfaz.ModoTexto;

/**
 *
 * @author francho
 */
public class App extends ModoTexto {
    private FiguraGeometrica figura;
    
    public App() {
        super();
    }

    public void setOpcionesMenu() {
        opcionesMenu = new String[5];
        opcionesMenu[0] = "Salir";
        opcionesMenu[1] = "Crear rectángulo";
        opcionesMenu[2] = "Crear cuadrado";
        opcionesMenu[3] = "Crear triángulo";
        opcionesMenu[4] = "Ver figura";
    }

    public void ejecutaOpcion(int numOpcion) {
        switch (numOpcion) {
            case 0:
                setTerminar(true);
                break;
            case 1:
                int base = (int) pideNumero("base del rectángulo: ",1);
                int altura = (int) pideNumero("altura del rectángulo: ",1);
                figura = new Rectangulo(base,altura);
                break;
            case 2:
                int lado = (int) pideNumero("lado del cuadrado: ",1);
                figura = new Cuadrado(lado);
                figura.setEtiqueta("Prueba Cuadrado");
                break;
            case 3:
                int cateto = (int) pideNumero("lado del triángulo: ",1);
                figura = new TrianguloRectangulo(cateto);
                break;
            case 4:
                figura.imprimirDescripcion();
                break;
        }
    }
}
    

