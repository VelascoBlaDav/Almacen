
package GestionDeFacturas;

import GestionDeClientes.Cliente;
import GestionDeProductos.Unidad;
import java.util.Date;

public class Factura {
    private static int NumFacturas;
    private String referencia;
    private Cliente comprador;
    private Date fFactura;
    private Unidad[] listaProductos;
    private int total;// ToDo: Calcular en funcion de Unidades
    private String observaciones;
    private formaPago formaPago;
    private estadoFactura estadoFactura;
 
    public Factura(String refAlbaran){
        Albaran albaran=Principal.buscarAlbaran(refAlbaran);
        NumFacturas++;
        this.referencia=formatoRefFactura(NumFacturas);
        this.comprador=albaran.getComprador();
        this.fFactura=albaran.getfAlbaran();
        this.listaProductos=albaran.getListaProductos();
        this.total=albaran.getTotal();
        
        
    }
    public static String formatoRefFactura(int numeroReferencia){
        String cadenaReferencia = null;
        if(1<=numeroReferencia && numeroReferencia<=9){
            cadenaReferencia="FA-00" + Integer.toString(numeroReferencia);
        }else if(10<=numeroReferencia && numeroReferencia<=99){
            cadenaReferencia="FA-0" + Integer.toString(numeroReferencia);
        }else if(100<=numeroReferencia && numeroReferencia<=999){
            cadenaReferencia="FA-" + Integer.toString(numeroReferencia);
        }
        return cadenaReferencia;
    }
    
    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public Cliente getComprador() {
        return comprador;
    }

    public void setComprador(Cliente comprador) {
        this.comprador = comprador;
    }

    public Date getfFactura() {
        return fFactura;
    }

    public void setfFactura(Date fFactura) {
        this.fFactura = fFactura;
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

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public formaPago getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(formaPago formaPago) {
        this.formaPago = formaPago;
    }

    public estadoFactura getEstadoFactura() {
        return estadoFactura;
    }

    public void setEstadoFactura(estadoFactura estadoFactura) {
        this.estadoFactura = estadoFactura;
    }

    
}
