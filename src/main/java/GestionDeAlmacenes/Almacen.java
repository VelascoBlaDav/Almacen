
package GestionDeAlmacenes;

import GestionDeProductos.Unidad;
import static GestionDeAlmacenes.tipoAlmacen.a;
import static GestionDeAlmacenes.tipoAlmacen.b;
import static GestionDeAlmacenes.tipoAlmacen.c;

public class Almacen {

    private static int NumAlmacenes;
    private String codAlmacen;
    private String nombre;
    private tipoAlmacen zona;
    public Unidad[] stock;
    public Unidad[] vendidos;
    public Unidad[] reservado;
    public Unidad[] libres;
    
    private static int numProdA = 0;
    private static int numProdB = 0;
    private static int numProdC = 0;

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
        if(null != zona)
        switch (zona) {
            case a:
                System.out.println("El numero de productos en el almacen "+zona+"es "+numProdA);
                break;
            case b:
                System.out.println("El numero de productos en el almacen "+zona+"es "+numProdB);
                break;
            case c:
                System.out.println("El numero de productos en el almacen "+zona+"es "+numProdC);
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
}