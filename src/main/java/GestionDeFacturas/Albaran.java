
package GestionDeFacturas;

import GestionDeClientes.Cliente;
import GestionDeFunciones.Formato;
import GestionDeProductos.Unidad;
import Principal.Principal;
import java.util.ArrayList;
import java.util.Date;

public class Albaran {
    private static int NumAlbaranes;
    private String referencia;
    private Cliente comprador;
    private Date fAlbaran;
    private ArrayList<Unidad> listaProductos;

    public Albaran(String codCliente) {
        NumAlbaranes++;
        this.comprador = Principal.buscarCliente(codCliente);
        this.fAlbaran = new Date();
        this.referencia = formatoRefAlbaran(NumAlbaranes);
        this.listaProductos = new ArrayList<>();
    }
    
    public void addUnidad(Unidad unidad){
        listaProductos.add(unidad);
    }
    
    public float calcularTotal(){
        float total=0;
        for(int i=0;i<listaProductos.size();i++){
            total+=listaProductos.get(i).getTipoProducto().getpVenta();
        }
        return total;
    }
    
    public void imprimirAlbaran(){
            System.out.println("---Albaran---\n");
            System.out.println("Número de albarán: "+getReferencia());
            System.out.println("Nombre del cliente: "+getComprador().getNombre());
            System.out.println("NIF del cliente: "+getComprador().getNIF());
            System.out.println("Fecha del albarán: "+Formato.fecha(getfAlbaran()));
            System.out.println("Productos: ");
            for(int i=0;i<listaProductos.size();i++){
                System.out.println(listaProductos.get(i).toString());
            }
            System.out.println("Total: "+calcularTotal());
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
    
    public ArrayList<Unidad> getListaProductos() {
        return listaProductos;
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

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }
    
    @Override
    public String toString() {
        return "Albaran:" + "referencia=" + referencia +
                ", comprador=" + comprador.getNombre() +
                ", fecha=" + Formato.fecha(fAlbaran) +
                ", total=" + calcularTotal() ;
    }    
    
}
