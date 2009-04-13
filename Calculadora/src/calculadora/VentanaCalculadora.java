/*
 * Interfaz para nuestra calculadora sencilla
 */
package calculadora;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author: $Author$
 * @version: $Rev$
 * @date: $Date$
 * $Id$
 */
public class VentanaCalculadora extends JFrame {

    /** numero tecleado */
    JTextField pantalla;
    
    /** guarda el resultado de la operacion anterior o el número tecleado */
    double resultado;
    
    /** para guardar la operacion a realizar */
    String operacion;    
    
    /** Los paneles donde colocaremos los botones */
    JPanel panelNumeros, panelOperaciones;
    
    /**  Indica si estamos iniciando o no una operación */
    boolean nuevaOperacion = true;
    
    
    /**
     * Constructor. Crea los botones y componentes de la calculadora
     */
    public VentanaCalculadora() {
        super();
        setSize(250, 300);
        setTitle("Calculadora Simple");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        
        // Vamos a dibujar sobre el panel
        JPanel panel = (JPanel) this.getContentPane();
        panel.setLayout(new BorderLayout());

        pantalla = new JTextField("0", 20);
        pantalla.setBorder(new EmptyBorder(4, 4, 4, 4));
        pantalla.setFont(new Font("Arial", Font.BOLD, 25));
        pantalla.setHorizontalAlignment(JTextField.RIGHT);
        pantalla.setEditable(false);
        pantalla.setBackground(Color.WHITE);
        panel.add("North", pantalla);

        panelNumeros = new JPanel();
        panelNumeros.setLayout(new GridLayout(4, 3));
        panelNumeros.setBorder(new EmptyBorder(4, 4, 4, 4));

        for (int n = 9; n >= 0; n--) {
            nuevoBotonNumerico("" + n);
        }

        nuevoBotonNumerico(".");

        panel.add("Center", panelNumeros);

        panelOperaciones = new JPanel();
        panelOperaciones.setLayout(new GridLayout(6, 1));
        panelOperaciones.setBorder(new EmptyBorder(4, 4, 4, 4));

        nuevoBotonOperacion("+");
        nuevoBotonOperacion("-");
        nuevoBotonOperacion("*");
        nuevoBotonOperacion("/");
        nuevoBotonOperacion("=");
        nuevoBotonOperacion("CE");

        panel.add("East", panelOperaciones);


        validate();
    }

    /**
     * Crea un boton del teclado numérico y enlaza sus eventos con el listener correspondiente
     * 
     * @param digito boton a crear
     */
    private void nuevoBotonNumerico(String digito) {
            JButton btn = new JButton();
            btn.setText(digito);
            btn.addMouseListener(
                    new MouseAdapter() {

                        @Override
                        public void mouseReleased(MouseEvent evt) {
                            JButton btn = (JButton) evt.getSource();
                            numeroPulsado(btn.getText());
                        }
                    });

            panelNumeros.add(btn);
        
    }
    
    /**
     * Crea un botón de operacion y lo enlaza con sus eventos.
     * 
     * @param operacion
     */
    private void nuevoBotonOperacion(String operacion) {
        JButton btn = new JButton(operacion);
        btn.setForeground(Color.RED);

        btn.addMouseListener(
                new MouseAdapter() {

                    @Override
                    public void mouseReleased(MouseEvent evt) {
                        JButton btn = (JButton) evt.getSource();
                        operacionPulsado(btn.getText());
                    }
                });

        panelOperaciones.add(btn);
    }

    /**
     * Gestiona las pulsaciones de teclas numéricas
     * 
     * @param digito tecla pulsada
     */
    private void numeroPulsado(String digito) {
        if (pantalla.getText().equals("0") || nuevaOperacion) {
            pantalla.setText(digito);
        } else {
            pantalla.setText(pantalla.getText() + digito);
        }
        nuevaOperacion = false;
    }

    /**
     * Gestiona el gestiona las pulsaciones de teclas de operación
     * @param tecla
     */
    private void operacionPulsado(String tecla) {
        if (tecla.equals("=")) {
            calcularResultado(); 
        } else if(tecla.equals("CE")) {
            resultado = 0;
            pantalla.setText("");
            nuevaOperacion = true;
        } else {
            operacion = tecla;
            if((resultado > 0) && !nuevaOperacion) {
                calcularResultado();
            } else {
                resultado = new Double(pantalla.getText());
            }
        }
        
        nuevaOperacion = true;
    }

    /**
     * Calcula el resultado y lo muestra por pantalla
     */
    private void calcularResultado() {
        if (operacion.equals("+")) {
            resultado += new Double(pantalla.getText());
        } else if (operacion.equals("-")) {
            resultado -= new Double(pantalla.getText());
        } else if (operacion.equals("/")) {
            resultado /= new Double(pantalla.getText());
        } else if (operacion.equals("*")) {
            resultado *= new Double(pantalla.getText());
        }

        pantalla.setText("" + resultado);
        operacion = "";
    }
}
