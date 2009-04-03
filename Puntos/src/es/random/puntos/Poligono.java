/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.random.puntos;

/**
 *
 * @author: $Author$
 * @version: $Rev$
 * @date: $Date$
 * $Id$
 */
public class Poligono
{

    private Punto vertices[];

    /**
     * Crea la propiedad de la clase que va a almacenar los puntos del polígono
     * Nota: no inicializa los puntos hay que usar establecerVertice()
     *
     * @param numVertices número de vértices del polígono
     */
    public Poligono(int numVertices) throws PoligonoIncorrectoException
    {
        if(numVertices <3) {
            throw new PoligonoIncorrectoException("Son necesarios por lo menos 3 lados para definir un polígono");
        }
        this.vertices = new Punto[numVertices];
    }
    
    public Poligono() {
    }

    /**
     *
     * @param numVertice
     * @param punto
     */
    public void establecerVertice(int numVertice, Punto punto)
    {
        vertices[numVertice] = punto;
    }

    /**
     * Comprueba que todos los vértices del polígono están correctamente definidos
     *
     * @return false si falta algún punto o hay duplicados, true en caso contrario
     */
    public boolean comprobarVertices()
    {
        for (int x = 0; x < vertices.length; x++) {
            Punto punto = vertices[x];

            //
            // DUDA: Como calcular lo de punto == null con equals
            //

            if (punto == null) {
                return false;
            } else {
                for (int y = 0; y < vertices.length; y++) {
                    Punto otroPunto = vertices[y];
                    if ((x != y) && (punto.equals(otroPunto))) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public double calcularPerimetro() throws PoligonoIncorrectoException {
        if(! this.comprobarVertices()) {
            throw new PoligonoIncorrectoException("vértices incorrectos");
        }

        double perimetro=0;
        for(int x=1; x<vertices.length; x++) {
            perimetro += vertices[x].calcularDistancia(vertices[x-1]);
        }
        // Sumamos el que cierra el ultimo puto con el primero
        perimetro += vertices[0].calcularDistancia(vertices[vertices.length-1]);


        return perimetro;
    }

    /**
     * Convertimos a cadena
     * @return
     */
    @Override
    public String toString()
    {
        String cad = "";

        if (!comprobarVertices()) {
            cad = "Polígono sin definir (faltan puntos o puntos duplicados)";
        } else {
            for (Punto p : vertices) {
                cad += (cad.equals("")) ? "" : ",";
                cad += p.toString();
            }
        }
        return cad;
    }

    /**
     * @return the vertices
     */
    public Punto[] getVertices()
    {
        return vertices;
    }

    /**
     * @param vertices the vertices to set
     */
    public void setVertices(Punto[] vertices)
    {
        this.vertices = vertices;
    }
}
