
package GestionDeFacturas;

import GestionDeClientes.Cliente;
import GestionDeProductos.Unidad;
import com.mycompany.almacen.Principal;
import java.util.ArrayList;
import java.util.Date;

public class Factura {
    private static int NumFacturas;
    private String referencia;
    private Cliente comprador;
    private Date fFactura;
    private ArrayList<Unidad> listaProductos;
    private float total;// ToDo: Calcular en funcion de Unidades
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
        this.total=albaran.calcularTotal();
        
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
    public void imprimirFactura(){
            System.out.println("---Factura---\n");
            System.out.println("Número de factura: "+getReferencia());
            System.out.println("Nombre del cliente: "+getComprador().getNombre());
            System.out.println("NIF del cliente: "+getComprador().getNIF());
            System.out.println("Fecha de la factura: "+getfFactura());
            System.out.println("Productos: ");
            for(int i=0;i<listaProductos.size();i++){
                System.out.println(listaProductos.get(i).toString());
            }
            System.out.println("Total: "+total);
            System.out.print("Estado: ");
            if(estadoFactura.equals(estadoFactura.a)){
                System.out.println("Pendiente de cobro");
            }else if(estadoFactura.equals(estadoFactura.b)){
                System.out.println("Cobro realizado");
                System.out.print("Forma de pago: ");
                if(formaPago.equals(formaPago.a)){
                    System.out.println("Al contado");
                }else if(formaPago.equals(formaPago.b)){
                    System.out.println("Con talón");
                }
            }
            System.out.println("Observaciones: "+observaciones);

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

    public ArrayList<Unidad> getListaProductos() {
        return listaProductos;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
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
    @Override
    public String toString() {
        return "Factura:" + "referencia=" + referencia + ", comprador=" + comprador.getNombre() +
                ", fecha=" + fFactura + ", total=" + total + ", observaciones=" + observaciones +
                ", forma de pago=" + formaPago + ", estado=" + estadoFactura;
    }    
}
