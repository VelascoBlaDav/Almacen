
package com.mycompany.almacen;

import java.util.Date;

public class Producto {
    private String referencia;
    private float ancho;
    private float alto;
    private float pCompra;
    private float pVenta; //50% mas que el precio de compra
    private float descAplic;
    private Date fCaducidad;
    public Almacen almacen;//elegir el almacen al que va cada producto
    private estadoProducto estadoProducto;

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

    public void setpVenta(float pVenta) {
        this.pVenta = (float) (pCompra + 0.5*pCompra); //sera el 50% de pCompra
    }

    public Date getfCaducidad() {
        return fCaducidad;
    }

    public void setfCaducidad(Date fCaducidad) {
        this.fCaducidad = fCaducidad;
    }
    
    public void setAlmacen(Almacen almacen){
        //ToDo comprobar si el tipo de almacen necesario existe y si no crearlo
        this.almacen = almacen;
    }
    
    public Almacen getAlmacen(Almacen almacen){
        return almacen;
    }
}