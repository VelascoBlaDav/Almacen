
package GestionDeAlmacenes;

import GestionDeProductos.Unidad;
import GestionDeProductos.Producto;
import static GestionDeAlmacenes.tipoAlmacen.a;
import static GestionDeAlmacenes.tipoAlmacen.b;
import static GestionDeAlmacenes.tipoAlmacen.c;

public class Almacen {

    private static int NumAlmacenes;
    private String codAlmacen;
    private String nombre;
    private tipoAlmacen zona;

    public Almacen(String nombre, tipoAlmacen zona) {
        NumAlmacenes++;
        this.codAlmacen = formatoRefAlmacen(NumAlmacenes);
        this.nombre=nombre;
        this.zona = zona;
    }
    
    public static String formatoRefAlmacen(int numeroReferencia){
        String cadenaReferencia = null;
        if(1<=numeroReferencia && numeroReferencia<=9){
            cadenaReferencia="AL-00" + Integer.toString(numeroReferencia);
        }else if(10<=numeroReferencia && numeroReferencia<=99){
            cadenaReferencia="AL-0" + Integer.toString(numeroReferencia);
        }else if(100<=numeroReferencia && numeroReferencia<=999){
            cadenaReferencia="AL-" + Integer.toString(numeroReferencia);
        }
        return cadenaReferencia;
    } 
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
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

    @Override
    public String toString() {
        return "Almacen:" + "codigo=" + codAlmacen + ", nombre=" + nombre + ", zona=" + zona;
    }

    //Conteo productos libre, vendido, reservado.
    //Productos libres caducados.
}