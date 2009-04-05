/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.random.interfaz;

import java.util.Scanner;

/**
 *
 * @author francho
 */
abstract public class ModoTexto {
    protected String[] opcionesMenu;
    private boolean terminar=false;
    
    abstract public void setOpcionesMenu();
    abstract public void ejecutaOpcion(int numOpcion);
   
    
    public ModoTexto() {
        terminar = false;
        // Cargamos las opciones del menu
        setOpcionesMenu();
    }
    
    public void ejecuta() {
        // Ejecutamos el bucle de la aplicacion
        do {
            verMenu();
            int opcion = -1;
            do {
                opcion = (int)pideNumero("Opción del menú: ");
            } while( (opcion < 0) || (opcion >= opcionesMenu.length) ) ;
            ejecutaOpcion(opcion);
        } while(!terminar);
    }
    
    public void verMenu() {
        _("-----------------------\n");
        _("   M E N U\n");
        _("-----------------------\n");
        for(int x = 0; x < opcionesMenu.length; x++) {
           _("   [" + x + "] " + opcionesMenu[x] + "\n"); 
        }
        _("-----------------------\n");
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
                num = new Double(pregunta(texto));
                ok = true;
            } catch (NumberFormatException ex) {
                _("Error, debes introducir un número. Vuelve a intentarlo.\n");
                ok = false;
            }
        } while (!ok);

        return num;
    }

    /**
     * Sobrecarga del método pideNumero
     * 
     * pregunta hasta que se mete un número mayor que minimo
     * 
     * @param texto
     * @param minimo el número que introduzca el usuario deberá ser mayor o igual que este 
     * @return el número tecleado
     */
    public double pideNumero(String texto, double minimo) {
        double num;
        do {
            num = pideNumero(texto);
        } while(num < minimo);
        return num;
    }

    public String pregunta(String pregunta)
    {
        _(pregunta);

        Scanner flujo = new Scanner(System.in);
        return flujo.nextLine();
    }

    public void _(String texto) {
        System.out.print(texto);
    }

    public boolean isTerminar() {
        return terminar;
    }

    public void setTerminar(boolean terminar) {
        this.terminar = terminar;
    }
}
