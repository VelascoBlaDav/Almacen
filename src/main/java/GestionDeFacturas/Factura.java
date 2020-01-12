
package GestionDeFacturas;

import GestionDeFacturas.formaPago;
import GestionDeFacturas.estadoFactura;
import GestionDeClientes.Cliente;
import GestionDeProductos.Unidad;
import java.util.Date;

public class Factura {
    private String comprador;
    private Date fFactura;
    private Albaran[] listaAlbaranes;
    private Unidad[] listaProductos;
    private int total;// ToDo: Calcular en funcion de Unidades
    private String observaciones;
    private formaPago formaPago;
    private estadoFactura estadoFactura;

    public String getComprador() {
        return comprador;
    }

    public void setComprador(String comprador) {
        this.comprador = comprador;
    }

    public Date getfFactura() {
        return fFactura;
    }

    public void setfFactura(Date fFactura) {
        this.fFactura = fFactura;
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
