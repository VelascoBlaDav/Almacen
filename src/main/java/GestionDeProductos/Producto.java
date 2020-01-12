
package GestionDeProductos;

import GestionDeAlmacenes.Almacen;

public class Producto {
    private String referencia;
    private float ancho;
    private float alto;
    private float pCompra; //Suponemos que un producto se compra siempre al mismo precio
    private float pVenta; //50% mas que el precio de compra
    private float descAplic;
    // Eliminar: private Date fCaducidad; Cambiado a unidad.
    public Almacen almacen;//elegir el almacen al que va cada producto
    
    public Producto(){
        
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public float getAncho() {
        return ancho;
    }

    public void setAncho(float ancho) {
        this.ancho = ancho;
    }

    public float getAlto() {
        return alto;
    }

    public void setAlto(float alto) {
        this.alto = alto;
    }

    public float getpCompra() {
        return pCompra;
    }

    public void setpCompra(float pCompra) {
        this.pCompra = pCompra;
    }

    public float getpVenta() {
        return pVenta;
    }

    public void setpVenta() {   
        this.pVenta = (float) (pCompra + 0.5*pCompra); //Por defecto, sera el 50% de pCompra
    }
    public void setpVenta(float pVenta) {
        this.pVenta = pVenta;
    }
    
    public void setAlmacen(Almacen almacen){
        //ToDo comprobar si el tipo de almacen necesario existe y si no crearlo
        this.almacen = almacen;
    }
    
    public Almacen getAlmacen(Almacen almacen){
        return almacen;
    }

    public float getDescAplic() {
        return descAplic;
    }

    public void setDescAplic(float descAplic) {
        this.descAplic = descAplic;
    }
    
    //Agregar productos a un almacen concreto
    //Mover producto de un almacen a otro
}