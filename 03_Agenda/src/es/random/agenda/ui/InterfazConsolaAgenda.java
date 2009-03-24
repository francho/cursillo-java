/*
 * Vista "Modo Consola" para la aplicacion
 */
package es.random.agenda.ui;

import es.random.agenda.datos.Contacto;
import es.random.agenda.negocio.GestorAgenda;
import java.util.Scanner;

/**
 *
 * @author: $Author$
 * @version: $Rev$
 * @date: $Date$
 * $Id$
 */
public class InterfazConsolaAgenda
{

    private boolean continuar = true;
    private GestorAgenda gestor;

    /**
     * Constructor de la clase
     *
     * - Muestra el menu
     * - Captura pulsacion
     * - Ejecuta la tarea correspondiente
     *
     */
    public InterfazConsolaAgenda()
    {
        // Inicializamos el gestor de la aplicación
        gestor = new GestorAgenda();

        // Bucle de aplicación
        do {
            mostrarMenu();
            ejecutarTarea(seleccionarOpcion());
        } while (continuar);
    }

    /**
     * Muestra el menu de texto con las opciones disponibles
     */
    private void mostrarMenu()
    {
        System.out.println("************************");
        System.out.println("*         Menú         *");
        System.out.println("*                      *");
        System.out.println("* (0) Salir            *");
        System.out.println("* (1) Añadir contacto  *");
        System.out.println("* (2) Borrar contacto  *");
        System.out.println("* (3) Listar contactos *");
        System.out.println("*                      *");
        System.out.println("************************");
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
            System.out.print("Introduzca una opcion del menú: ");
            // Comprobamos que es lo que nos meten
            if (lector.hasNextInt()) {
                opcion = lector.nextInt();
                // comprobamos que este en nuestro rango de opciones
                if ((opcion < 0) || (opcion > 3)) {
                    opcion = -1;
                }
            } else {
                lector.next(); // Vaciamos el buffer para la siguiente vez
            }
        } while (opcion == -1);

        return opcion;
    }

    private void ejecutarTarea(int opcion)
    {
        switch (opcion) {
            // Salir
            case 0:
                continuar = false;
                break;
            // Añadir
            case 1:
                titulo("Introduzca los datos del nuevo contacto");
                gestor.añadirContacto(obtenerDatos());
                break;
            // Borrar
            case 2:
                titulo("Introduzca los datos del contacto a borrar");
                gestor.borrarContacto(obtenerDatos());
                break;
            // Listar
            case 3:
                titulo("Listado de contactos");
                System.out.println(gestor.toString());
                break;
            default:
                System.out.println("ERR: Opción incorrecta");

        }
    }

    private Contacto obtenerDatos()
    {
        // Inicializamos las variables que vamos a necesitar
        Contacto nuevo = new Contacto();
        Scanner lector = new Scanner(System.in);
        lector.useDelimiter("\n"); // Salto de linea windows como delimitador

        System.out.print("nombre: ");
        nuevo.setNombre(lector.nextLine());

        System.out.print("primer apellido: ");
        nuevo.setPrimerApellido(lector.nextLine());

        System.out.print("segundo apellido: ");
        nuevo.setSegundoApellido(lector.nextLine());

        System.out.print("dirección: ");
        nuevo.setDireccion(lector.nextLine());

        System.out.print("email: ");
        nuevo.setEmail(lector.nextLine());

        boolean valido = false;
        do {
            System.out.print("teléfono: ");
            if (lector.hasNextLong()) {
                nuevo.setTelefonoFijo(lector.nextLong());
                valido = true;
            } else {
                lector.next();

                valido = false;
            }
        } while (!valido);

        do {
            System.out.print("móvil: ");
            if (lector.hasNextLong()) {
                nuevo.setTelefonoMovil(lector.nextLong());
                valido = true;
            } else {
                lector.next();
                valido = false;
            }
        } while (!valido);

        return nuevo;
    }

    private void titulo(String texto)
    {
        
        // Revisar esto para maquear
        //    http://www.javaworld.com/javaworld/javaqa/2002-12/02-qa-1220-console.html
        System.out.println("\n" +texto+"\n");
    }
}
