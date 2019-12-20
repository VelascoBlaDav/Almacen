
package com.mycompany.almacen;

import java.util.Date;

public class Unidad {
    private Producto tipoProducto;
    private int descuento;
    private Date fCaducidad;
    private Almacen localizacion; 

    public Producto getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(Producto tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    public int getDescuento() {
        return descuento;
    }

    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }

    public Date getfCaducidad() {
        return fCaducidad;
    }

    public void setfCaducidad(Date fCaducidad) {
        this.fCaducidad = fCaducidad;
    }

    public Almacen getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(Almacen localizacion) {
        this.localizacion = localizacion;
    }
    
    
}
