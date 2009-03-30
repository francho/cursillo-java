/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.random.gestorcadenas.ui;

import es.random.gestorcadenas.GestorCadenas;
import java.util.Scanner;

/**
 *
 * @author: $Author$
 * @version: $Rev$
 * @date: $Date$
 * $Id$
 */
public class InterfazGestorCadenas
{

    private final int NUM_OPCIONES = 7;
    private GestorCadenas gestor;
    private boolean continuar = true;

    public InterfazGestorCadenas()
    {
        // Inicializamos el gestor de la aplicación
        gestor = new GestorCadenas();

        // Bucle de aplicación
        do {
            mostrarMenu();
            ejecutarTarea(seleccionarOpcion());
        } while (continuar);
    }

    public void mostrarMenu()
    {
        System.out.println("");
        System.out.println("-----------------------------------------");
        System.out.println("\t         Menú         ");
        System.out.println("\t--------------------------");
        System.out.println("\t (0) Salir                ");
        System.out.println("\t (1) Cargar Archivo       ");
        System.out.println("\t (2) Guardar Archivo       ");
        System.out.println("\t (3) Mostrar");



        System.out.println("\t--------------------------");

    }

    /**
     * Captura la opcion seleccionada por el usuario
     * Tiene en cuenta que esté en el rango de opciones del menu
     *
     * @return int opcion seleccionada
     */
    private int seleccionarOpcion()
    {
        int opcion = -1;
        // Clase para analizar cadenas de texto
        // le pasamos el flujo de entrada para poder analizarlo
        Scanner lector = new Scanner(System.in);
        lector.useDelimiter("\n"); // Salto de linea windows como delimitador

        do {
            System.out.print("\tIntroduzca una opcion del menú: ");
            // Comprobamos que es lo que nos meten
            if (lector.hasNextInt()) {
                opcion = lector.nextInt();
                // comprobamos que este en nuestro rango de opciones
                if ((opcion < 0) || (opcion > NUM_OPCIONES)) {
                    opcion = -1;
                }
            } else {
                lector.next(); // Vaciamos el buffer para la siguiente vez
            }
        } while (opcion == -1);

        return opcion;
    }

    /**
     * Ejecuta la tarea correspondiente a la pulsacion del usuario
     *
     * @param opcion opcion pulsada por el usuario
     */
    private void ejecutarTarea(int opcion)
    {
        Scanner flujo = new Scanner(System.in);
        switch (opcion) {
            case 0: // Salir
                continuar = false;
                break;
            case 1: // Mostrar

                String nombreCargar = "";

                System.out.print("Introduce el nuevo nombre del fichero a cargar: ");
                gestor.cargarArchivo(flujo.nextLine());
                break;
            case 2: // Guardar
                String nombreGuardar = "";

                System.out.print("Guardar como: ");
                gestor.guardarArchivo(flujo.nextLine());
                break;
            case 3: // Mostrar

                for (String linea : gestor.getCadenas()) {
                    System.out.println(linea + "\r\n");
                }

                break;
        }
    }
}
