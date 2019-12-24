
package com.mycompany.almacen;

import static com.mycompany.almacen.tipoAlmacen.a;
import static com.mycompany.almacen.tipoAlmacen.b;
import static com.mycompany.almacen.tipoAlmacen.c;


public class Almacen {
    private String codAlmacen;
    private tipoAlmacen zona;
    private Unidad[] stock;
    private Unidad[] vendidos;
    private Unidad[] reservado;
    
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
        int numProduct = 0;
        if(null != zona)
        switch (zona) {
            case a:
                //Calcular nuemero de productos en cada almacen
                System.out.println("El numero de productos en el almacen "+zona+"es "+numProduct);
                break;
            case b:
                //Calcular nuemero de productos en cada almacen
                System.out.println("El numero de productos en el almacen "+zona+"es "+numProduct);
                break;
            case c:
                //Calcular nuemero de productos en cada almacen
                System.out.println("El numero de productos en el almacen "+zona+"es "+numProduct);
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
    
    //private static void cambiarAlmacen(String referenciaProducto, Almacen almacen){
        //ToDo cambiar el tipo de almacen de un producto
        //Producto.setAlmacen(almacen);
    //}

    /*private static void countProdA(){
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
    }*/    
    
}