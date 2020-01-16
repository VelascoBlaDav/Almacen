
package GestionDeProductos;

import GestionDeAlmacenes.Almacen;
import com.mycompany.almacen.Principal;

public class Producto {
    private static int NumProductos;
    private String referencia;
    private String nombre;
    private float ancho;
    private float alto;
    private float pCompra; //Suponemos que un producto se compra siempre al mismo precio
    private float pVenta; //50% mas que el precio de compra
    private float descAplic;
    private Almacen almacen;//elegir el almacen al que va cada producto
    
    public Producto(String nombre, float ancho, float alto, float pCompra, String codAlmacen){
        NumProductos++;
        this.referencia= formatoRefProducto(NumProductos);
        this.nombre=nombre;
        this.ancho=ancho;
        this.alto=alto;
        this.pCompra=pCompra;
        this.pVenta=(float) (pCompra*1.5);
        this.descAplic=0;   //Por defecto no hay descuento aplicado al producto.
        this.almacen=Principal.buscarAlmacen(codAlmacen);
    }
    public static String formatoRefProducto(int numeroReferencia){
        String cadenaReferencia = null;
        if(1<=numeroReferencia && numeroReferencia<=9){
            cadenaReferencia="PR-00" + Integer.toString(numeroReferencia);
        }else if(10<=numeroReferencia && numeroReferencia<=99){
            cadenaReferencia="PR-0" + Integer.toString(numeroReferencia);
        }else if(100<=numeroReferencia && numeroReferencia<=999){
            cadenaReferencia="PR-" + Integer.toString(numeroReferencia);
        }
        return cadenaReferencia;
    }    

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
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
    public void setpVenta(float pVenta) {
        this.pVenta = pVenta;
    }
    
    public void setAlmacen(Almacen almacen){
        //ToDo comprobar si el tipo de almacen necesario existe y si no crearlo
        this.almacen = almacen;
    }
    
    public Almacen getAlmacen(){
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
    
    @Override
    public String toString() {
        return "Producto:" + "referencia=" + referencia + ", nombre=" + nombre + ", pCompra=" + pCompra + ", pVenta=" + pVenta;
    }
}