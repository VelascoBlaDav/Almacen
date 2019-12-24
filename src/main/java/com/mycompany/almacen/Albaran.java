
package com.mycompany.almacen;

import java.util.Date;

public class Albaran {
    private Cliente comprador;
    private Date fAlbaran;
    private static int nAlbaran;
    private Unidad[] listaProductos;
    private int total;// ToDo: Calcular en funcion de Unidades
    
    java.util.Date fecha = new Date(); //instancio un objeto Date para obtener la fecha actual

    public Cliente getComprador() {
        return comprador;
    }

    public void setComprador(Cliente comprador) {
        this.comprador = comprador;
    }

    public Date getfAlbaran() {
        fAlbaran = fecha; //copio la fecha actual en fAlbaran
        return fAlbaran;
    }

    public void setfAlbaran(Date fAlbaran) {
        this.fAlbaran = fAlbaran;
    }

    public static int getnAlbaran() {
        return nAlbaran;
    }

    public static void setnAlbaran(int nAlbaran) {
        Albaran.nAlbaran = nAlbaran;
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
