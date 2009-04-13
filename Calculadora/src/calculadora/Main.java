/*
 * Ejercicio: Calculadora sencilla
 *   - Implementar la Interfaz de usuario
 *   - Implementar los métodos siguientes a través de los listeners adecuados:
 *          - Sumar
 *          - Restar
 *          - Multiplicar
 *          - Dividir
 */

package calculadora;

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
        // TODO code application logic here
        VentanaCalculadora calculadora = new VentanaCalculadora();
        calculadora.setVisible(true);
    }

}
