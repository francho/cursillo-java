/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package agenda;


import es.random.agenda.datos.Contacto;
import javax.swing.event.TableModelListener;
import javax.swing.table.*;
import es.random.java.librerias.gestion.*;

/**
 *
 * @author: $Author$
 * @version: $Rev$
 * @date: $Date$
 * $Id$
 */
public class ContactoTableModel extends DefaultTableModel {
    private Gestor<Contacto> miGestor;

    public ContactoTableModel() {
        miGestor = new Gestor<Contacto>();
        miGestor.deserializar();
    }

    @Override
    public int getRowCount() {
        if(miGestor == null) {
            return 0;
        } else {
            return miGestor.tamaño();
        }
    }

    @Override
    public int getColumnCount() {
        return miGestor.obtenerNombresColumnas().length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
       return miGestor.obtenerElemento(rowIndex).obtenerElemento(columnIndex).toString();
        //return miGestor.obtenerMatriz()[rowIndex][columnIndex];
    }

    /**
     * @param gestorAgenda the gestorAgenda to set
     */
    public void setGestorAgenda(Gestor gestorAgenda)
    {
        this.miGestor = gestorAgenda;
    }

    @Override
    public String getColumnName(int columnIndex)
    {
        String nombre = miGestor.obtenerNombresColumnas()[columnIndex];
        return nombre;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex)
    {
        return false;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        miGestor.obtenerElemento(rowIndex).establecerElemento(aValue, columnIndex);
    }

    void addRow()
    {
        miGestor.añadirContacto(new Contacto());
    }

    /*
    public Class<?> getColumnClass(int columnIndex)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void addTableModelListener(TableModelListener l)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void removeTableModelListener(TableModelListener l)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }
*/


}
