
package GestionDeProductos;

import GestionDeAlmacenes.Almacen;
import com.mycompany.almacen.Principal;
import java.util.Date;

public class Unidad {
    /*Por cada producto, 0 o mas unidades
    El almacen hay que declararlo en el producto y mantenerlo en la unidad
    Todas las unidades tienen que estar en el mismo almacen
    */
    private Producto tipoProducto;
    private int descuento;
    private Date fCaducidad;
    private estadoProducto estadoProducto;

    public Unidad(String refProducto, Date fCaducidad){
        this.tipoProducto=Principal.buscarProducto(refProducto);
        this.fCaducidad=fCaducidad;
        this.descuento=0;                       //Por defecto no tiene descuento.
        this.estadoProducto=estadoProducto.a;   //Por defecto está libre.
    }
    
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
    
    public estadoProducto getEstadoProducto() {
        //Declarar una dependencia hacia el cliente
        return estadoProducto;
    }

    public void setEstadoProducto(estadoProducto estadoProducto) {
        this.estadoProducto = estadoProducto;
    }
    
}
