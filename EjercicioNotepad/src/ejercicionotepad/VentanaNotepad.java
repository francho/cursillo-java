/*
 * Editor de textos sencillo
 */
package ejercicionotepad;

import es.random.ficheros.GestorFicheroTexto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Iterator;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author: $Author$
 * @version: $Rev$
 * @date: $Date$
 * $Id$
 */
public class VentanaNotepad extends JFrame
{

    /** Zona de texto donde escribirá el usuario, es global porque debemos accederla desde varios sitios */
    JTextArea areaTexto;
    /** Posicion donde nos hemos quedado en la búsqueda **/
    int buscarDesde = 0;
    /** Texto que se está buscando **/
    String buscarTexto = "";

    /**
     * Constructor, inciliza el interfaz
     */
    public VentanaNotepad()
    {
        super();
        inicializarInterfaz();
    }

    /**
     * Crea los
     */
    private void inicializarInterfaz()
    {
        setTitle("Editor de texto sencillo");
        setSize(600, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        crearMenu();
        crearAreaTexto();
    }

    /** 
     * Inicializa el area de texto en la que trabajará el usuario
     */
    private void crearAreaTexto()
    {
        // Zona de escritura

        areaTexto = new JTextArea(8, 40);
        areaTexto.setName("areaTexto");
        areaTexto.setLineWrap(true);

        JScrollPane scroll = new JScrollPane(areaTexto);

        add(scroll);
    }

    /**
     * Crea el menu y submenus de la ventana
     */
    private void crearMenu()
    {
        // Menu archivo
        JMenu menuArchivo = new JMenu("Archivo");
        menuArchivo.setMnemonic('a');

        menuArchivo.add(crearElementoMenu("Nuevo", "ctrl N", 'n', "Empieza un nuevo documento"));
        menuArchivo.add(crearElementoMenu("Abrir", "ctrl O", 'b', "Abrir un documento existente"));
        menuArchivo.add(crearElementoMenu("Guardar", "ctrl S", 'G', "Guardar el contenido actual"));


        menuArchivo.addSeparator();

        // Otra forma, definimos todo directamente
        JMenuItem itemSalir = new JMenuItem("Salir");
        itemSalir.addActionListener(new ActionListener()
        {

            public void actionPerformed(ActionEvent e)
            {
                System.exit(0);
            }
        });
        menuArchivo.add(itemSalir);


        // Menu edición (otra forma de crear los menus)
        //definimos los items con action porque pueden ser utilizados de muchas formas direfentes (por ejemplo podemos reutilizarlo luego en menús contextuales)

        JMenu menuEdicion = new JMenu("Editar");
        menuEdicion.setMnemonic('E');

        // Tambien podemos asignar mas propiedades en la misma linea
        menuEdicion.add(new AccionEdicion("Copiar")).setIcon(new ImageIcon("media/copiar.png"));
        menuEdicion.add(new AccionEdicion("Cortar")).setIcon(new ImageIcon("media/cortar.png"));
        menuEdicion.add(new AccionEdicion("Pegar")).setIcon(new ImageIcon("media/pegar.png"));
        menuEdicion.addSeparator();
        menuEdicion.add(new AccionEdicion("Buscar"));
        menuEdicion.add(new AccionEdicion("Buscar Siguiente"));
        menuEdicion.add(new AccionEdicion("Reemplazar"));
        menuEdicion.add(new AccionEdicion("Reemplazar Todo"));

        // Menu de ayuda
        JMenu menuAyuda = new JMenu("Ayuda");
        menuAyuda.setMnemonic('y');

        JMenuItem itemAcercaDe = new JMenuItem("Acerca de...");
        itemAcercaDe.addActionListener(new ActionListener()
        {

            public void actionPerformed(ActionEvent e)
            {
                VentanaAcercaDe acerca = new VentanaAcercaDe(VentanaNotepad.this);
                acerca.setVisible(true);
            }
        });
        menuAyuda.add(itemAcercaDe);

        // Creamos el menu
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        menuBar.add(menuArchivo);
        menuBar.add(menuEdicion);
        menuBar.add(menuAyuda);
    }

    /**
     * Crea un nuevo elemento de menu
     *
     * @param nombre texto del item
     * @param atajo combinacion de teclas atajo
     * @param mnemonico letra de acceso rápido
     * @param ayuda el texto de ayuda que se mostrará en el tooltip
     *
     * @return item creado
     */
    public JMenuItem crearElementoMenu(String nombre, String atajo, char mnemonico, String ayuda)
    {
        JMenuItem elementoMenu = new JMenuItem();
        elementoMenu.setName(nombre);
        elementoMenu.setAccelerator(KeyStroke.getKeyStroke(atajo));
        elementoMenu.setMnemonic(mnemonico);
        elementoMenu.setText(nombre);
        elementoMenu.addActionListener(new OyenteArchivo());
        elementoMenu.setToolTipText(ayuda);
        elementoMenu.setIcon(new ImageIcon("media/" + nombre.toLowerCase() + ".png"));

        return elementoMenu;
    }

    /**
     * Clase interna que gestionará las acciones de menu referentes a ficheros
     *
     */
    class OyenteArchivo implements ActionListener
    {

        /**
         * Ejecuta la accion asociada a un evento del menu de archivo
         * @param e
         */
        public void actionPerformed(ActionEvent e)
        {
            String opcion = (String) e.getActionCommand();

            if (opcion.equals("Nuevo")) {
                accionNuevo();
            } else if (opcion.equals("Abrir")) {
                accionAbrir();
            } else if (opcion.equals("Guardar")) {
                accionGuardar();
            }
        }
    }

    /**
     * Ejecuta la acción asociada a un evento del menu de edicion
     */
    class AccionEdicion extends AbstractAction
    {

        public AccionEdicion(String nombre)
        {
            super(nombre);
        }

        public void actionPerformed(ActionEvent e)
        {
            String opcion = (String) getValue(Action.NAME);

            if (opcion.equals("Copiar")) {
                areaTexto.copy();
            } else if (opcion.equals("Cortar")) {
                areaTexto.cut();
            } else if (opcion.equals("Pegar")) {
                areaTexto.paste();
            } else if (opcion.equals("Buscar")) {
                accionBuscar();
            } else if (opcion.equals("Buscar Siguiente")) {
                accionBuscarSiguiente();
            } else if (opcion.equals("Reemplazar")) {
                accionReemplazar(false);
            } else if (opcion.equals("Reemplazar Todo")) {
                accionReemplazar(true);
            }
        }
    }

    private void accionNuevo()
    {
        areaTexto.setText("");
    }

    private void accionAbrir()
    {
        GestorFicheroTexto fich = new GestorFicheroTexto();

        JFileChooser fichSel = dialogoSeleccionarFichero();

        int rtdoFich = fichSel.showOpenDialog(areaTexto);

        if (rtdoFich == JFileChooser.APPROVE_OPTION) {
            String nombreFichero = fichSel.getSelectedFile().getPath();

            fich.cargarArchivo(nombreFichero);

            // Cargamos el texto del fichero
            String texto = "";
            Iterator linea = fich.getCadenas().iterator();
            while (linea.hasNext()) {
                texto += linea.next() + "\r\n";
            }

            // Lo "dibujamos" en el editor
            areaTexto.setText(texto);
        }
    }

    private void accionGuardar()
    {
        JFileChooser fichSel = dialogoSeleccionarFichero();

        int rtdoFich = fichSel.showSaveDialog(areaTexto);

        if (rtdoFich == JFileChooser.APPROVE_OPTION) {
            String nombreFichero = fichSel.getSelectedFile().getPath();
            GestorFicheroTexto fich = new GestorFicheroTexto();
            fich.setCadenas(areaTexto.getText());
            fich.guardarArchivo(nombreFichero);
        }
    }

    private JFileChooser dialogoSeleccionarFichero()
    {
        JFileChooser fichSel = new JFileChooser();
        fichSel.setCurrentDirectory(new File("."));
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Ficheros de texto", "txt");
        fichSel.setFileFilter(filter);
        return fichSel;
    }

    private void accionBuscar()
    {
        buscarTexto = JOptionPane.showInputDialog(
                VentanaNotepad.this, "Texto a buscar", "Buscar...", JOptionPane.QUESTION_MESSAGE);

        buscarDesde = 0;
        accionBuscarSiguiente();
    }

    private void accionBuscarSiguiente()
    {
        if (!buscarTexto.equals("")) {
            int inicio = areaTexto.getText().indexOf(buscarTexto, buscarDesde);
            if (inicio >= 0) {
                int fin = inicio + buscarTexto.length();
                areaTexto.select(inicio, fin);
                buscarDesde = inicio + 1;
            } else {
                JOptionPane.showMessageDialog(VentanaNotepad.this, "No se ha encontado ninguna conincidencia");
            }
        }
    }

    /**
     * Reemplaza
     * @param reemplazarTodo si true reemplaza todas las ocurrencias, si false solo reemplaza la primera
     */
    private void accionReemplazar(boolean reemplazarTodo)
    {
        String textoBuscar = JOptionPane.showInputDialog( 
                VentanaNotepad.this, "Texto a buscar", "Buscar...", JOptionPane.QUESTION_MESSAGE);

        if (textoBuscar != null) {
            String textoReemplazar = JOptionPane.showInputDialog(
                    VentanaNotepad.this, "reemplazar por", "reemplazar...", JOptionPane.QUESTION_MESSAGE);
            if (textoReemplazar != null) {
                if (reemplazarTodo) {
                    areaTexto.setText(areaTexto.getText().replaceAll(textoBuscar, textoReemplazar));
                } else {
                    areaTexto.setText(areaTexto.getText().replaceFirst(textoBuscar, textoReemplazar));
                }
            }
        }
    }
}