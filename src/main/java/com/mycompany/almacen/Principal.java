package com.mycompany.almacen;

import Funciones.Calculo;
import Funciones.Lectura;
import GestionDeAlmacenes.Almacen;
import GestionDeAlmacenes.tipoAlmacen;
import GestionDeClientes.Cliente;
import GestionDeFacturas.Albaran;
import GestionDeFacturas.Factura;
import GestionDeProductos.Producto;
import GestionDeProductos.Unidad;
import GestionDeProductos.estadoProducto;
import java.util.ArrayList;
import java.util.Date;

public class Principal {
    private static ArrayList<Almacen> almacenes = new ArrayList<Almacen>();
    private static ArrayList<Producto> productos = new ArrayList<Producto>();
    private static ArrayList<Unidad> unidades = new ArrayList<Unidad>();
    private static ArrayList<Cliente> clientes = new ArrayList<Cliente>();
    private static ArrayList<Albaran> albaranes = new ArrayList<Albaran>();
    private static ArrayList<Factura> facturas = new ArrayList<Factura>();
    
    public static void main(String args[]){
        int salir = 0;
        
        //Creamos los tres almacenes de la empresa,1 de cada tipo.
        almacenes.add(new Almacen("Seco",tipoAlmacen.a));
        almacenes.add(new Almacen("Humedo",tipoAlmacen.b));
        almacenes.add(new Almacen("Congelado",tipoAlmacen.c));       
                
        do{
            System.out.println("Bienvenido\n");
            System.out.println("¿Que opción desea realizar?\n\n");
            System.out.println("0)Salir\n"); //Completo
            System.out.println("1)Añadir un nuevo producto\n"); //Completo
            System.out.println("2)Cambiar de almacen un producto\n"); //Completo
            System.out.println("3)Listar el numero de unidades de productos en un almacen\n"); //Completo
            System.out.println("4)Listar unidades de productos que van a caducar\n"); //Completo
            System.out.println("5)Listar el estado de los productos\n"); //Completo
            System.out.println("6)Listar el numero de productos libres caducados\n"); //Completo
            System.out.println("7)Eliminar productos caducados\n"); //Completo
            System.out.println("8)Vender producto\n");
            System.out.println("9)Registrar un nuevo cliente\n"); //Completo
            System.out.println("10)Listar productos\n");//Completo
            System.out.println("11)Añadir unidades de un producto existente\n");//Completo
            System.out.println("12)Cambiar el descuento de una unidad\n");//Completo
            System.out.println("13)Añadir un nuevo albaran\n");//Completo
            System.out.println("14)Crear una factura por albaran\n");//Completo
            System.out.println("15)Listar facturas pendientes de cobro\n");
            System.out.println("16)Listar facturas de un cliente\n");
            System.out.println("17)Listar el stock de un producto\n");
            System.out.println("18)Añadir unidades de un producto\n");//Completo
            System.out.println("19)Añadir unidades a un albaran\n");//Completo
            System.out.println("20)Imprimir albaran\n");//Completo

            int opcion = Lectura.entero();
            switch(opcion){
                case 1:
                    menuAddProducto();
                    break;
                case 2:
                    menuMoverProducto();
                    break;
                case 3:
                    menuListarUnidadesEnAlmacen();
                    break;
                case 4:
                    listarProductosCercaDeCaducar();
                    break;
                case 5:
                    listarEstadoProductos();
                    break;
                case 6:
                    listarProductosLibresCaducados();
                    break;
                case 7:
                    borrarProductosCaducados();
                    break;
                case 8:
                    // Funcion venta de producto, recibe una unidad, resta stock y llama a funcion generar albaran.
                    
                    break;
                case 9:
                    menuAddCliente();
                    break;
                case 10:
                    listarProductos();
                    break;
                case 11:
                    menuAddUnidad();
                    break;
                case 12:
                    menuCambiarDescuentoUnidad();
                    break;
                case 13:
                    menuAddAlbaran();
                    break;
                case 14:
                    menuAddFactura();
                    break;
                case 15:
                    listarFacturasPendientes();
                    break;
                case 16:
                    listarFacturas(); //de un cliente concreto
                    break;
                case 17:
                    //Listar las unidades de un producto concreto
                    break;
                case 18:
                    menuAddUnidad();
                    break;
                case 19:
                    menuAddUnidadesAlbaran();
                    break;
                case 20:
                    menuImprimirAlbaran();
                    break;
                case 0:
                    salir = 1;
                    break;
            }
        }while(salir==0);
        
        
    }
//ALMACEN
    public static Almacen buscarAlmacen(String codAlmacen ){
        for (int i=0;i<almacenes.size();i++){
            if(almacenes.get(i).getCodAlmacen().equals(codAlmacen)){
                return almacenes.get(i);
            }
        }
        return null;
    }
    public static void listarProductosAlmacen(String codAlmacen){
        int i;
        for(i=0;i<productos.size();i++){
            if (productos.get(i).getAlmacen().getCodAlmacen().equals(codAlmacen)){
                productos.get(i).toString();
            }
        }
    }
//PRODUCTO
    public static Producto buscarProducto(String referencia){
        int i;
        for (i=0;i<productos.size();i++){
            if(productos.get(i).getReferencia().equals(referencia)){
                return productos.get(i);
            }
        }
        return null;
    }
    public static void eliminarProducto(String referencia){
        productos.remove(buscarProducto(referencia));
    }
    public static void listarProductos(){
        int i;
        for (i=0;i<productos.size();i++){
            System.out.println(productos.get(i).toString());
        }
    }
    public static void listarProductos(float precio){
        int i;
        for (i=0;i<productos.size();i++){
            if(productos.get(i).getpVenta() >= precio){
                productos.get(i).toString();
            }
        }
    }
//UNIDAD
    public static Unidad buscarUnidad(String referencia){
        int i;
        for(i=0;i<unidades.size();i++){
            if(unidades.get(i).getReferencia().equals(referencia)){
                return unidades.get(i);
            }
        }
        return null;
    }
    public static void eliminarUnidad(String referencia){
        unidades.remove(buscarUnidad(referencia));
    }
    public static void listarEstadoProductos(){
        for(int i=0;i<unidades.size();i++){
            System.out.println(unidades.get(i).toString());
        }
    }
    public static void listarProductosCercaDeCaducar(){
        for(int i=0;i<unidades.size();i++){
            if(Calculo.diasRestantes(unidades.get(i).getfCaducidad()) <7){  //Queda menos de 1 semana para que caduquen.
                System.out.println(unidades.get(i).toString());
            }
        }
    }
    public static void listarProductosLibresCaducados(){
        for(int i=0;i<unidades.size();i++){
            if(unidades.get(i).getEstadoProducto() == estadoProducto.a              //Libres
                    && Calculo.diasRestantes(unidades.get(i).getfCaducidad())<0){   //Caducados
                System.out.println(unidades.get(i).toString());
            }
        }
    }
    public static void listarUnidades(){
        for(int i=0;i<unidades.size();i++){
            System.out.println(unidades.get(i).toString());
        }
    }
    //venta
    public static void venderProductos(String referencia){
        buscarUnidad(referencia);
        //Primero se genera un albaran
        
    }
//CLIENTE
    public static Cliente buscarCliente(String referencia){
        int i;
        for(i=0;i<clientes.size();i++){
            if(clientes.get(i).getCodCliente().equals(referencia)){
                return clientes.get(i);
            }
        }
        return null;
    }
    public static void listarCliente(){
        int i;
        for(i=0;i<clientes.size();i++){
            clientes.toString();
        }
    }
//ALBARAN
    public static Albaran buscarAlbaran(String referencia ){
        for (int i=0;i<albaranes.size();i++){
            if(albaranes.get(i).getReferencia().equals(referencia)){
                return albaranes.get(i);
            }
        }
        return null;
    }
    public static void listarAlbaran(){
        albaranes.toString();
    }
    public static void listarAlbaran(Date fecha){
        for(int i=0;i<clientes.size();i++){
            if(albaranes.get(i).getfAlbaran().equals(fecha)){
                albaranes.get(i).toString();
            }
        }
    }
//FACTURAS
    public static Factura buscarFactura(String referencia ){
        for (int i=0;i<facturas.size();i++){
            if(albaranes.get(i).getReferencia().equals(referencia)){
                return facturas.get(i);
            }
        }
        return null;
    }
    public static void listarFacturasPendientes(){
        facturas.toString();
    }
    public static void listarFacturas(){
        facturas.toString();
    }
     
//MENUS
    public static void menuCambiarDescuentoUnidad(){
        System.out.println("Escribe el codigo del producto a buscar:\n");
        String referencia = Lectura.cadena();
        Unidad uni = buscarUnidad(referencia);
        System.out.println("Escribe el % de descuento:\n");
        int descuento = Lectura.entero();
        uni.setDescuento(descuento);
    }
    public static void menuMoverProducto(){
        //Buscar el producto
        //Seleccionar el nuevo tipo de almacen segun su codigo
        //Cambiar el tipo de almacen
        Producto p;
        Almacen a;
        String referencia;
        int si;
        System.out.println("Introduce el código del producto.");
        referencia=Lectura.cadena();
        p=buscarProducto(referencia);
        System.out.println("El almacen del producto es"+p.getAlmacen());
        System.out.println("¿Desea cambiarlo?:);(0-no,1-si)");
        System.out.println("0) No.");
        System.out.println("1) Si.");
        si = Lectura.entero();
        if(si==1){
            System.out.println("Escribe el codigo de referencia del almacen:\n");
            referencia = Lectura.cadena();
            a=buscarAlmacen(referencia);
            p.setAlmacen(a);
            System.out.println("El almacen ahora es : "+a+".\n");
        }else{
            System.out.println("El almacen no se ha modificado.\n");
        }
    }
    public static void menuAddCliente(){
        String nombre, nif, direccion;
        float credito;

        System.out.println("-Añadir nuevo cliente-\n");
        System.out.println("Nombre completo:\n");
        nombre = Lectura.cadena();
        System.out.println("NIF:\n");
        nif = Lectura.cadena();
        System.out.println("Dirección (Pais, ciudad, calle, numero, piso, letra):\n");
        direccion = Lectura.cadena();
        System.out.println("Credito (en €):\n");
        credito = Lectura.real();

        addCliente(new Cliente(nombre, nif, direccion, credito));

    }
    public static void menuAddProducto(){
        String nombreProducto,codAlmacen;
        float ancho, alto,pCompra;

        System.out.println("-Añadir nuevo producto-\n");
        System.out.println("Escribe el nombre del producto:\n");
        nombreProducto = Lectura.cadena();
        System.out.println("Ancho del producto (x,x):\n");
        ancho = Lectura.real();
        System.out.println("Alto del producto (x,x):\n");
        alto = Lectura.real();
        System.out.println("Precio de compra  (en €. x,x):\n");
        pCompra = Lectura.real();
        System.out.println("El codigo de almacen (AL-1xxx):\n");
        codAlmacen = Lectura.cadena();


        addProducto(new Producto(nombreProducto, ancho, alto, pCompra, codAlmacen));
    }
    public static void menuAddUnidad(){
        int unidades;
        Date fCaducidad;
        String refProducto;
        
        System.out.println("-Añadir unidades de producto-\n");
        //System.out.println("Selecciona el producto:\n");
        //TODO: Lista de productos       
        System.out.println("Escribe el codigo del producto a buscar:\n");
        refProducto = Lectura.cadena();
        System.out.println("¿Cuantas unidades quieres añadir?\n");
        unidades = Lectura.entero();

        System.out.println("Introduce la fecha de caducidad (formato dd/mm/yyyy):\n");
        fCaducidad=Lectura.fecha();
        //Crear unidades de producto
        addUnidad(unidades,new Unidad(refProducto, fCaducidad));
    }
    public static void menuAddUnidadesAlbaran(){
        System.out.println("Introduce la referencia del albaran:\n");
        String refAlbaran=Lectura.cadena();
        System.out.println("Introduce la referencia de la unidad a añadir:\n");
        String refUnidad=Lectura.cadena();
        buscarAlbaran(refAlbaran).addUnidad(buscarUnidad(refUnidad));
    }
    public static void menuImprimirAlbaran(){
        System.out.println("Introduce la referencia del albaran:\n");
        String referencia=Lectura.cadena();
        buscarAlbaran(referencia).imprimirAlbaran();
    }
    public static void menuAddAlbaran(){
        String codCliente,refAlbaran,refUnidad;
        boolean salir=false;
        boolean imprimir;
        Albaran albaran;
        
        System.out.println("La lista de clientes es esta:\n");
        listarCliente();
        System.out.println("Introduzca el código del cliente:\n");
        codCliente = Lectura.cadena();
        buscarCliente(codCliente);
        //Generamos un nuevo albaran al cliente
        refAlbaran=addAlbaran(new Albaran(codCliente));
        
        albaran=buscarAlbaran(refAlbaran);
        //Añadimos unidades al albaran
        while(!salir){
            System.out.println("Las unidades disponibles son estas:\n");
            listarUnidades();
            System.out.println("Escribe el codigo de la unidad a añadir:\n");
            refUnidad=Lectura.cadena();
            albaran.addUnidad(buscarUnidad(refUnidad));
            System.out.println("¿Quieres añadir más productos?");
            System.out.println("0) No");
            System.out.println("1) Si");
            salir=Lectura.booleanoNumerico();
        }
        
        System.out.println("¿Desea imprimir el albarán?");
        System.out.println("0) No");
        System.out.println("1) Si");
        imprimir=Lectura.booleanoNumerico();
        if(imprimir){
            albaran.imprimirAlbaran();
        }
        
    }
    public static void menuAddFactura(){
        String referencia;
        
        System.out.println("La lista de albaranes es esta:\n");
        listarAlbaran();
        System.out.println("Seleccione el albaran:\n");
        referencia = Lectura.cadena();
        addFactura(new Factura(referencia));
    }
    public static void menuVenta(Albaran albaran){
        Date fecha = null;
        float precio = 0;
        
        /*
        Despues de una venta hay que hacer todas estas operaciones
        - Obtener un listado de los productos.
        - Obtener un listado de Albaranes. 
        - Obtener un listado de productos buscados a partir de un precio de venta mayor a una cantidad
        - Obtener un listado de albaranes generados en una fecha concreta.
        - Obtener la suma total económica de productos vendidos. 
        - Obtener un listado de las facturas pendientes de cobro. 
        - Obtener un listado detallado de facturas de un cliente 
        - Cuanto Stock tenemos de un producto concreto.
        */
        listarUnidades();
        listarAlbaran();
        listarProductos(precio);
        listarAlbaran(fecha);
        listarFacturasPendientes();
        //totalVenta();
    }
    public static void menuListarUnidadesEnAlmacen(){
        System.out.println("Escribe el codigo de referencia del almacen:\n");
        String referencia = Lectura.cadena();
        listarProductosAlmacen(referencia);
    }
    public static void borrarProductosCaducados(){
        for(int i=0;i<unidades.size();i++){
            if(Calculo.diasRestantes(unidades.get(i).getfCaducidad())<0){
                //Producto caducado
                eliminarUnidad(unidades.get(i).getReferencia());
            }
        }
    }
    public static void addUnidad(int nUnidades, Unidad unidad){
        int i;
        for(i=0;i<nUnidades;i++){
            unidades.add(unidad); 
        }
    }
    public static String addProducto(Producto producto){
        productos.add(producto);
        return producto.getReferencia();
    }
    public static String addCliente(Cliente cliente){
        clientes.add(cliente);
        return cliente.getCodCliente();
    }
    public static String addAlbaran(Albaran albaran){
        albaranes.add(albaran);
        return albaran.getReferencia();
    }
    public static String addFactura(Factura factura){
        facturas.add(factura);
        return factura.getReferencia();
    }
}
/*
recorrer(){
    for (int i=0;i<a.length;i++){
                //Mostramos la direccion del objeto
                System.out.println(a[i]);
            }
}
bucar(codAlmacen){
    var=recorrer();
    if(var==codAlmacen)
        return a;
}
eliminar(codAlmacen){
    buscar(codAlmacen);
    a=null;
}
*/