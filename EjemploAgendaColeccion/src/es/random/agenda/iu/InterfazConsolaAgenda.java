/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.random.agenda.iu;

import es.random.agenda.datos.Contacto;
import es.random.agenda.negocio.GestorAgenda;
import es.random.java.librerias.gestion.Gestor;
import java.util.Scanner;

/**
 *
 * @author AdminLocal
 */
public class InterfazConsolaAgenda
{

    private boolean continuar = true;
    private Gestor<Contacto> gestor;
    private final int OPCION_MAXIMA=7;

    public InterfazConsolaAgenda()
    {
        gestor = new Gestor();
        int opcion = 0;
        do
        {
            mostrarMenu();
            opcion = seleccionarOpcion();
            ejecutarTarea(opcion);
        // ejecutarTarea(seleccionarOpcion());
        } while (continuar);
    }

    private void añadirContacto()
    {
        gestor.añadirContacto(obtenerDatos(false));
    }

    private void borrarContacto()
    {
        Contacto borrable = obtenerDatos(true);
        if (gestor.contieneContacto(borrable))
        {
            gestor.borrarContacto(borrable);
            System.out.println("Contacto borrado.\n");
        } else
        {
            System.out.println("No existe ningún contacto coincidente en la agenda.\n");
        }
    }

    private void cargarAgenda()
    {
        gestor.cargarTexto(Contacto.class);
    }

    private void deserializarAgenda()
    {
        gestor.deserializar();
    }

    private void guardarAgenda()
    {
        gestor.guardarTexto();
    }

    private void listarContactos()
    {
        if (gestor.estaVacio())
        {
            System.out.println("\n----- Agenda de Contactos vacía -----\n");
        } else
        {
            System.out.println(gestor.toString());
        }
    }

    private Contacto obtenerDatos(boolean borrado)
    {
        Contacto nuevo = new Contacto();
        Scanner lector = new Scanner(System.in);
        lector.useDelimiter("\n");
        System.out.print("Introduzca el nombre: ");
        nuevo.setNombre(lector.nextLine());
        System.out.print("Introduzca el primer apellido: ");
        nuevo.setPrimerApellido(lector.nextLine());
        System.out.print("Introduzca el segundo apellido: ");
        nuevo.setSegundoApellido(lector.nextLine());
        if (!borrado)
        {
            System.out.print("Introduzca la direccion: ");
            nuevo.setDireccion(lector.nextLine());
            System.out.print("Introduzca el E-Mail: ");
            nuevo.setEMail(lector.nextLine());
            boolean valido = true;
            do
            {
                System.out.print("Introduzca el número de teléfono fijo: ");
                if (lector.hasNextLong())
                {
                    nuevo.setTelefonoFijo(lector.nextLong());
                    valido = true;
                } else
                {
                    lector.next();
                    valido = false;
                }
            } while (!valido);
            valido = true;
            do
            {
                System.out.print("Introduzca el número de teléfono móvil: ");
                if (lector.hasNextLong())
                {
                    nuevo.setTelefonoMovil(lector.nextLong());
                    valido = true;
                } else
                {
                    lector.next();
                    valido = false;
                }
            } while (!valido);
        }
        return nuevo;
    }

    private void mostrarMenu()
    {
        System.out.println("**************************");
        System.out.println("* 0 - Salir");
        System.out.println("* 1 - Añadir Contacto");
        System.out.println("* 2 - Borrar Contacto");
        System.out.println("* 3 - Listar contactos");
        System.out.println("* 4 - Guardar Agenda");
        System.out.println("* 5 - Cargar Agenda");
        System.out.println("* 6 - Serializar Agenda");
        System.out.println("* 7 - Deserializar Agenda");
        System.out.println("**************************");
    }

    private void ejecutarTarea(int opcion)
    {
        switch (opcion)
        {
            case 0:
                continuar = false;
                break;
            case 1:
                añadirContacto();
                break;
            case 2:
                borrarContacto();
                break;
            case 3:
                listarContactos();
                break;
            case 4:
                guardarAgenda();
                break;
            case 5:
                cargarAgenda();
                break;
            case 6:
                serializarAgenda();
                break;
            case 7:
                deserializarAgenda();
                break;
            default:
                // codigo
                break;
        }
    }

    private int seleccionarOpcion()
    {
        int opcion = -1;
        Scanner lector = new Scanner(System.in);
        lector.useDelimiter("\n");
        do
        {
            System.out.print("Por favor, introduzca una opcion: ");
            if (lector.hasNextInt())
            {
                opcion = lector.nextInt();
                if (opcion < 0 || opcion > OPCION_MAXIMA)
                {
                    opcion = -1;
                }
            } else
            {
                lector.next();
            }
        } while (opcion == -1);
        return opcion;
    }

    private void serializarAgenda()
    {
        gestor.serializar();
    }
}
