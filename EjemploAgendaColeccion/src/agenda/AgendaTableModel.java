/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package agenda;


import es.random.agenda.datos.Contacto;
import javax.swing.table.*;
import es.random.java.librerias.gestion.*;

/**
 *
 * @author: $Author$
 * @version: $Rev$
 * @date: $Date$
 * $Id$
 */
public class AgendaTableModel extends AbstractTableModel {
    Gestor agenda = new Gestor<Contacto>();

    public int getRowCount() {
        return agenda.obtenerMatriz().length;
    }

    public int getColumnCount() {
        return agenda.obtenerNombresCol().length;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        return agenda.obtenerMatriz()[rowIndex][columnIndex];
    }

}
