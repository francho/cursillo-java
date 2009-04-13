/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplotreeset;

/**
 *
 * @author AdminLocal
 */
public class Pedido implements Comparable
{

    String proveedor;
    long ID;

    public Pedido()
    {
        proveedor = "";
        ID = 0;
    }

    public Pedido(String proveedor,long ID)
    {
        this.proveedor = proveedor;
        this.ID = ID;
    }

    public int compareTo(Object o)
    {
        if (o instanceof Pedido)
        {
            Pedido aux = (Pedido) o;
            if (aux != null)
            {
                if (ID < aux.ID)
                {
                    return -1;
                } else if (ID > aux.ID)
                {
                    return 1;
                } else
                {
                    return 0;
                }
            }
        }
        return 0;
    }
}
