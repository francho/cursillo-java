/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ejemplojdbc;

/**
 *
 * @author AdminLocal
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        AccesoDerby prueba=new AccesoDerby();
        prueba.conectar();
        prueba.mostrarDataBaseMetaData();
        //prueba.limpiarTabla();
        prueba.analizarTabla();
        //prueba.analizarTabla("Select * from person");
        //prueba.ejecutarTransaccion();
        //prueba.ejecutarLote();
        //prueba.establecerSavePoints();
        //Object[][] lista=new Object[][]{{19,"Pedrito"},{20,"Jorgito"},{21,"Pablito"},{22,"Juanito"}};
        //prueba.ejecutarProcedimientoPreparado(lista);
        //prueba.procedimientoAlmacenado();
        //prueba.analizarTabla();
        //prueba.analizarTabla("Select * from person");
        //prueba.mostrarDatos();
        //prueba.analizarTabla("select * from customer");
    }

}
