
package GestionDeAlmacenes;

import GestionDeProductos.Unidad;
import GestionDeProductos.Producto;
import static GestionDeAlmacenes.tipoAlmacen.a;
import static GestionDeAlmacenes.tipoAlmacen.b;
import static GestionDeAlmacenes.tipoAlmacen.c;

public class Almacen {
    //Codigo almacen parametro estatico
    private String codAlmacen;
    private tipoAlmacen zona;
    public Unidad[] stock;
    public Unidad[] vendidos;
    public Unidad[] reservado;
    public Unidad[] libres;
    
    private static int numProdA = 0;
    private static int numProdB = 0;
    private static int numProdC = 0;

    public Almacen(String codAlmacen, tipoAlmacen zona, Unidad[] stock, Unidad[] vendidos, Unidad[] reservado, Unidad[] libres) {
        this.codAlmacen = codAlmacen;
        this.zona = zona;
        this.stock = stock;
        this.vendidos = vendidos;
        this.reservado = reservado;
        this.libres = libres;
        switch (zona) {
            case a:
                numProdA++;
                break;
            case b:
                numProdB++;
                break;
            case c:
                numProdC++;
                break;
            default:
                System.out.println("Error, no existe ese almacen\n");
                //ToDo crear nuevo almacen
                break;
        }
         
    }
    
    int i;
    public String getCodAlmacen() {
        return codAlmacen;
    }

    public void setCodAlmacen(String codAlmacen) {
        this.codAlmacen = codAlmacen;
    }

    public tipoAlmacen getZona() {
        return zona;
    }

    public void setZona(tipoAlmacen zona) {
        this.zona = zona;
    }

    public Unidad[] getStock() {
        return stock;
    }

    public void setStock(Unidad[] stock) {
        this.stock = stock;
    }

    public Unidad[] getVendidos() {
        return vendidos;
    }

    public void setVendidos(Unidad[] vendidos) {
        this.vendidos = vendidos;
    }

    public Unidad[] getReservado() {
        return reservado;
    }

    public void setReservado(Unidad[] reservado) {
        this.reservado = reservado;
    }
    
    private static void countProd(tipoAlmacen zona){
        if(null != zona)
        switch (zona) {
            case a:
                System.out.println("El numero de productos en el almacen "+zona+"es "+numProdA);
                break;
            case b:
                System.out.println("El numero de productos en el almacen "+zona+"es "+numProdB);
                break;
            case c:
                System.out.println("El numero de productos en el almacen "+zona+"es "+numProdC);
                break;
            default:
                System.out.println("Error, no existe ese almacen\n");
                break;
        }
    }    
    private static void countProdCercaDeCaducar(tipoAlmacen zona){
        //ToDo Calcular el numero de productos que estan cerca de calcular
        int numProductCad = 0;
        if(null != zona)
        switch (zona) {
            case a:
                //Calcular nuemero de productos en cada almacen
                System.out.println("El numero de productos cerca de caducar en el almacen "+zona+"es "+numProductCad);
                break;
            case b:
                //Calcular nuemero de productos en cada almacen
                System.out.println("El numero de productos cerca de caducar en el almacen "+zona+"es "+numProductCad);
                break;
            case c:
                //Calcular nuemero de productos en cada almacen
                System.out.println("El numero de productos cerca de caducar en el almacen "+zona+"es "+numProductCad);
                break;
            default:
                System.out.println("Error, no existe ese almacen\n");
                break;
        }
        
    }
    private static void eliminarProdCaducados(Producto pCaducado){
        //ToDo Eliminar producto caducado del almacen
        
    }
    
    private static void cambiarAlmacen(String referenciaProducto, Almacen almacen){
        //ToDo cambiar el tipo de almacen de un producto
        
    }

    private static void countProdA(){
        //ToDo Clcular el numero de productos que estan en estado libre
        //if (producto esta en un almacen && producto.estado=A)
        // cont ++
        
    }
    private static void countProdB(){
        //ToDo Clcular el numero de productos que estan en estado vendido
        //if (producto esta en un almacen && producto.estado = B)
        // cont ++
    }
    private static void countProdC(){
        //ToDo Clcular el numero de productos que estan en estado reservado
        //if (producto esta en un almacen && producto.estado= C)
        // cont ++
    }
    
    
    //Conteo productos libre, vendido, reservado.
    //Productos libres caducados.
}