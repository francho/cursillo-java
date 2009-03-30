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
public class InterfazGestorCadenas {

    private final int NUM_OPCIONES = 6;
    private GestorCadenas gestor;
    private boolean continuar = true;

    /** Linea de ultima ocurrencia encontrada con buscar */
    private int buscarUltimo = -1;
    private String buscarTexto = "";
    
    public InterfazGestorCadenas() {
        // Inicializamos el gestor de la aplicación
        gestor = new GestorCadenas();

        // Bucle de aplicación
        do {
            mostrarMenu();
            ejecutarTarea(seleccionarOpcion());
        } while (continuar);
    }

    public void mostrarMenu() {
        System.out.println("");
        System.out.println("--------------------------");
        System.out.println("         Menú         ");
        System.out.println("--------------------------");
        System.out.println(" (0) Salir");
        System.out.println(" (1) Cargar Archivo");
        System.out.println(" (2) Guardar Archivo");
        System.out.println(" (3) Mostrar");
        System.out.println(" (4) Buscar");
        System.out.println(" (5) Buscar siguiente");
        System.out.println(" (6) Reemplazar");
        System.out.println("--------------------------");

    }

    /**
     * Ejecuta la tarea correspondiente a la pulsacion del usuario
     *
     * @param opcion opcion pulsada por el usuario
     */
    private void ejecutarTarea(int opcion) {
        switch (opcion) {
            case 0: // Salir
                continuar = false;
                break;
            case 1: // Mostrar
                opCargar();
                break;
            case 2: // Guardar
                opGuardar();
                break;
            case 3: // Mostrar
                opMostrar();
                break;
            case 4: // Buscar
                opBuscar();
                break;
            case 5: // Buscar Siguiente
                opBuscarSiguiente();
                break;
            case 6: // Busca y reemplaza
                opReemplazar();
                break;
        }
    }

    public void opCargar() {
        gestor.cargarArchivo(pregunta("Introduce el nuevo nombre del fichero a cargar: "));
        buscarUltimo = -1;
    }

    public void opGuardar() {
        gestor.guardarArchivo(pregunta("Guardar como: "));
    }

    public void opMostrar() {
        for (String linea : gestor.getCadenas()) {
            System.out.println(linea);
        }
    }

    public void opBuscar() {
        buscarTexto = pregunta("Texto a buscar: ");
        buscarUltimo = -1;
        opBuscarSiguiente();
    }
    
    public void opBuscarSiguiente() {
        buscarUltimo = gestor.buscar(buscarTexto, buscarUltimo+1);
        if (buscarUltimo > -1) {
            System.out.println("(línea " + buscarUltimo + ") " + gestor.getCadenas().get(buscarUltimo));
        } else {
            System.out.println("No se ha encontrado el texto");
        }
    }
      
    public void opReemplazar() {
        String busca = pregunta("Texto a buscar: ");
        String reemplaza = pregunta("Reemplazar por: ");
        gestor.reemplazarTodo(busca, reemplaza);
    }

    /**
     * Hace una pregunta al usuario y recoge su respuesta
     * 
     * @param pregunta
     * @return String pregunta
     */
    private String pregunta(String pregunta) {
        System.out.print(pregunta);
        Scanner flujo = new Scanner(System.in);
        flujo.useDelimiter("\r\n"); // Salto de linea windows como delimitador

        return flujo.nextLine();
    }

    /**
     * Captura la opcion seleccionada por el usuario
     * Tiene en cuenta que esté en el rango de opciones del menu
     *
     * @return int opcion seleccionada
     */
    private int seleccionarOpcion() {
        int opcion = -1;
        // Clase para analizar cadenas de texto
        // le pasamos el flujo de entrada para poder analizarlo
        Scanner lector = new Scanner(System.in);
        lector.useDelimiter("\n"); // Salto de linea windows como delimitador

        do {
            System.out.print("Introduzca una opcion del menú: ");
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

}