
package GestionDeFacturas;

import GestionDeClientes.Cliente;
import GestionDeProductos.Unidad;
import com.mycompany.almacen.Principal;
import java.util.Date;

public class Albaran {
    private static int NumAlbaranes;
    private String referencia;
    private Cliente comprador;
    private Date fAlbaran;
    private Unidad[] listaProductos;
    private int total;// ToDo: Calcular en funcion de Unidades

    public Albaran(String codCliente, Unidad[] listaProductos) {
        NumAlbaranes++;
        this.comprador = Principal.buscarCliente(codCliente);
        this.fAlbaran = new Date();
        this.referencia = formatoRefAlbaran(NumAlbaranes);
        this.listaProductos = listaProductos;
    }
    
    public static String formatoRefAlbaran(int numeroReferencia){
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
    
    public Cliente getComprador() {
        return comprador;
    }

    public void setComprador(Cliente comprador) {
        this.comprador = comprador;
    }

    public Date getfAlbaran() {
        return fAlbaran;
    }

    public void setfAlbaran(Date fAlbaran) {
        this.fAlbaran = fAlbaran;
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

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }
}
