
package GestionDeProductos;
import Principal.Principal;
import java.util.Date;

public class Unidad {
    /*Por cada producto, 0 o mas unidades
    El almacen hay que declararlo en el producto y mantenerlo en la unidad
    Todas las unidades tienen que estar en el mismo almacen
    */
    private static int NumUnidades;
    private String referencia;
    private Producto tipoProducto;
    private int descuento;
    private Date fCaducidad;
    private estadoProducto estadoProducto;

    public Unidad(String refProducto, Date fCaducidad){
        NumUnidades++;
        this.referencia=formatoRefUnidad(NumUnidades);
        this.tipoProducto=Principal.buscarProducto(refProducto);
        this.fCaducidad=fCaducidad;
        this.descuento=0;                       //Por defecto no tiene descuento.
        this.estadoProducto=estadoProducto.a;   //Por defecto está libre.
    }
    
    public static String formatoRefUnidad(int numeroReferencia){
        String cadenaReferencia = null;
        if(1<=numeroReferencia && numeroReferencia<=9){
            cadenaReferencia="UP-00" + Integer.toString(numeroReferencia);
        }else if(10<=numeroReferencia && numeroReferencia<=99){
            cadenaReferencia="UP-0" + Integer.toString(numeroReferencia);
        }else if(100<=numeroReferencia && numeroReferencia<=999){
            cadenaReferencia="UP-" + Integer.toString(numeroReferencia);
        }
        return cadenaReferencia;
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

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    @Override
    public String toString() {
        return "Unidad{" + "referencia=" + referencia + "tipoProducto=" + tipoProducto + ", estadoProducto=" + estadoProducto + '}';
    }
    
}
