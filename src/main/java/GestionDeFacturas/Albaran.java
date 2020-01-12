
package GestionDeFacturas;

import GestionDeProductos.Unidad;
import java.util.Date;

public class Albaran {
    private String comprador; //nombreCliente
    private Date fAlbaran;
    private static int numeroAlbaranes;
    String refAlbaran;
    private Unidad[] listaProductos;
    private int total;// ToDo: Calcular en funcion de Unidades

    public Albaran(String comprador, Date fAlbaran, Unidad[] listaProductos) {
        numeroAlbaranes++;
        this.comprador = comprador;
        this.fAlbaran = fAlbaran;
        this.refAlbaran = formatoNAlbaran(numeroAlbaranes);
        this.listaProductos = listaProductos;
        
    }
    
    public static String formatoNAlbaran(int numeroReferencia){
        String cadenaReferencia = null;
        if(1<=numeroReferencia && numeroReferencia<=9){
            cadenaReferencia="AB-00" + Integer.toString(numeroReferencia);
        }else if(10<=numeroReferencia && numeroReferencia<=99){
            cadenaReferencia="AB-0" + Integer.toString(numeroReferencia);
        }else if(100<=numeroReferencia && numeroReferencia<=999){
            cadenaReferencia="AB-" + Integer.toString(numeroReferencia);
        }
        return cadenaReferencia;
    }    
    
    public String getComprador() {
        return comprador;
    }

    public void setComprador(String comprador) {
        this.comprador = comprador;
    }

    public Date getfAlbaran() {
        return fAlbaran;
    }

    public void setfAlbaran(Date fAlbaran) {
        this.fAlbaran = fAlbaran;
    }
    public void setfAlbaran() {
        this.fAlbaran=new Date(); //instancio un objeto Date para obtener la fecha actual
        
    }

    public Unidad[] getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(Unidad[] listaProductos) {
        this.listaProductos = listaProductos;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
