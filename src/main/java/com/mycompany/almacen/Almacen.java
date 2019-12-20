
package com.mycompany.almacen;

public class Almacen {
    private String codAlmacen;
    private tipoAlmacen zona;
    private Unidad[] stock;
    private Unidad[] vendidos;
    private Unidad[] reservado;

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
    
    private static int countProd(int numProduct){
        //ToDo Calcular el numero de productos en un almacen
        return numProduct;
    }
    private static void countProdCercaDeCaducar(){
        //ToDo Calcular el numero de productos que estan cerca de calcular
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
    private static void eliminarProdCaducados(Producto pCaducado){
        //ToDo Eliminar producto caducado del almacen
    }
    
    
}