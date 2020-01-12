
package GestionDeFacturas;

import GestionDeFacturas.formaPago;
import GestionDeFacturas.estadoFactura;
import GestionDeClientes.Cliente;
import GestionDeProductos.Unidad;
import java.util.Date;

public class Factura {
    private Cliente comprador;
    private Date fFactura;
    private static int nAlbaran;
    private Unidad[] listaProductos;
    private int total;// ToDo: Calcular en funcion de Unidades
    private String observaciones;
    private formaPago formaPago;
    private estadoFactura estadoFactura;
}
