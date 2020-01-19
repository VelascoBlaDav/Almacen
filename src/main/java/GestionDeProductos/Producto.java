
package GestionDeProductos;

import GestionDeAlmacenes.Almacen;
import Principal.Principal;

public class Producto {
    private static int NumProductos;
    private String referencia;
    private String nombre;
    private float ancho;
    private float alto;
    private float pCompra; //Suponemos que un producto se compra siempre al mismo precio
    private float pVenta; //50% mas que el precio de compra
    private Almacen almacen;//elegir el almacen al que va cada producto
    
    public Producto(String nombre, float ancho, float alto, float pCompra, String codAlmacen){
        NumProductos++;
        this.referencia= formatoRefProducto(NumProductos);
        this.nombre=nombre;
        this.ancho=ancho;
        this.alto=alto;
        this.pCompra=pCompra;
        this.pVenta=(float) (pCompra*1.5);
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
        this.almacen = almacen;
    }
    
    public Almacen getAlmacen(){
        return almacen;
    }
    
    @Override
    public String toString() {
        return "Producto:" + "referencia=" + referencia + 
                ", nombre=" + nombre + 
                ", ancho=" + ancho + 
                ", alto=" + alto + 
                ", precioCompra=" + pCompra + 
                ", precioVenta=" + pVenta +
                ", almacen=" + almacen.getCodAlmacen();
                
    }
}