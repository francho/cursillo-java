/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ejemplotreeset;

import java.util.Comparator;
import java.util.TreeSet;

/**
 *
 * @author AdminLocal
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TreeSet<Pedido> pedidosID = new TreeSet<Pedido>();
        pedidosID.add(new Pedido("Primero",1));
        pedidosID.add(new Pedido("Quinto",5));
        pedidosID.add(new Pedido("Tercero",3));
        pedidosID.add(new Pedido("Cuarto",4));
        pedidosID.add(new Pedido("Segundo",2));
        pedidosID.add(new Pedido("Sexto",6));
        for(Pedido p : pedidosID)
        {
            System.out.println("ID: " + p.ID + "\tProveedor: " + p.proveedor);
        }
        System.out.println("\n");
        TreeSet<Pedido> pedidosProveedor = new TreeSet<Pedido>(new Comparator() {

            public int compare(Object o1, Object o2)
            {
                if(o1 instanceof Pedido && o2 instanceof Pedido)
                {
                    Pedido pedido1 = (Pedido)o1;
                    Pedido pedido2 = (Pedido)o2;
                    return pedido1.proveedor.compareTo(pedido2.proveedor);
                }
                return 0;
            }
        });
        pedidosProveedor.addAll(pedidosID);
        for(Pedido p : pedidosProveedor)
        {
            System.out.println("ID: " + p.ID + "\tProveedor: " + p.proveedor);
        }

    }

}
