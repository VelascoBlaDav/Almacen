package com.mycompany.almacen;

import GestionDeAlmacenes.Almacen;
import GestionDeAlmacenes.tipoAlmacen;
import GestionDeClientes.Cliente;
import GestionDeFacturas.Albaran;
import GestionDeProductos.Producto;
import GestionDeProductos.Unidad;
import GestionDeProductos.estadoProducto;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;


public class Principal {
    private static ArrayList<Almacen> almacenes = new ArrayList<Almacen>();
    private static ArrayList<Producto> productos = new ArrayList<Producto>();
    private static ArrayList<Unidad> unidades = new ArrayList<Unidad>();
    private static ArrayList<Cliente> clientes = new ArrayList<Cliente>();
    
    public static void main(String args[]){
        String referencia = null;
        int i, salir = 0, si, descuento;
        Producto p;
        Almacen a;
        Unidad u;
        
        //Creamos los tres almacenes de la empresa,1 de cada tipo.
        almacenes.add(new Almacen("Seco",tipoAlmacen.a));
        almacenes.add(new Almacen("Seco",tipoAlmacen.b));
        almacenes.add(new Almacen("Seco",tipoAlmacen.c));       
        
        
        Scanner sc = new Scanner (System.in);
        
        do{
            System.out.println("Bienvenido\n");
            System.out.println("¿Que opcion desea realizar?\n\n");
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
            System.out.println("12)Añadir descuento a una unidad\n");

            int opcion = sc.nextInt();
            switch(opcion){
                case 1:
                    menuAddProducto();
                    break;
                case 2:
                    //Buscar el producto
                    //Seleccionar el nuevo tipo de almacen segun su codigo
                    //Cambiar el tipo de almacen
                    p=buscarProducto(referencia);
                    System.out.println("El almacen del producto es"+p.getAlmacen());
                    System.out.println("¿Desea cambiarlo?(0-no,1-si)");
                    sc.nextInt();
                    si = sc.nextInt();
                    if(si==1){
                        System.out.println("Escribe el codigo de referencia del almacen:\n");
                        sc.nextLine();
                        referencia = sc.nextLine();
                        a=buscarAlmacen(referencia);
                        p.setAlmacen(a);
                    }else{
                        break;
                    }
                    break;
                case 3:
                    System.out.println("Escribe el codigo de referencia del almacen:\n");
                    sc.nextLine();
                    referencia = sc.nextLine();
                    listarProductosAlmacen(referencia);
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
                    //Eliminar productos caducados
                    //Comprobar la fecha actual y la fecha de la unidad del producto
                    //Los productos cuya fecha sea menor a la fecha actual ponerlos a null
                    for(i=0;i<unidades.size();i++){
                        if(unidades.get(i).getfCaducidad().compareTo(new Date())==0){
                            eliminarUnidad(unidades.get(i).getReferencia());
                        }
                    }
                    break;
                case 8:
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
                    System.out.println("Escribe el codigo del producto a buscar:\n");
                    sc.nextLine();
                    referencia = sc.nextLine();
                    u = buscarUnidad(referencia);
                    System.out.println("Escribe el % de descuento:\n");
                    sc.nextFloat();
                    descuento = sc.nextInt();
                    u.setDescuento(descuento);
                    break;
                case 0:
                    salir = 1;
                    break;
            }
            sc.nextLine();
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
            productos.get(i).toString();
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
        Unidad u;
        u=buscarUnidad(referencia);
        u=null;
    }
    public static void listarEstadoProductos(){
        for(int i=0;i<unidades.size();i++){
            System.out.println(unidades.get(i).toString());
        }
    }
    public static void listarProductosCercaDeCaducar(){
        for(int i=0;i<unidades.size();i++){
            if(unidades.get(i).getfCaducidad().compareTo(new Date())==0){
                System.out.println(unidades.get(i).toString());
            }
        }
    }
    public static void listarProductosLibresCaducados(){
        for(int i=0;i<unidades.size();i++){
            if(unidades.get(i).getEstadoProducto() == estadoProducto.a && unidades.get(i).getfCaducidad().compareTo(new Date())>=0){
                System.out.println(unidades.get(i).toString());
            }
        }
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
//ALBARAN
    //BUSCAR ALBARAN
    
    public static void menuAddCliente(){
        String nombre, nif, direccion;
        float credito;
        Scanner sc = new Scanner (System.in);

        System.out.println("-Añadir nuevo cliente-\n");
        System.out.println("Nombre completo:\n");
        sc.nextLine();
        nombre = sc.nextLine();
        System.out.println("NIF:\n");
        sc.nextLine();
        nif = sc.nextLine();
        System.out.println("Dirección (Pais, ciudad, calle, numero, piso, letra):\n");
        sc.nextLine();
        direccion = sc.nextLine();
        System.out.println("Credito (en €):\n");
        sc.nextFloat();
        credito = sc.nextFloat();

        addCliente(new Cliente(nombre, nif, direccion, credito));

    }
    public static void menuAddProducto(){
        String nombreProducto,codAlmacen;
        float ancho, alto,pCompra;
        Scanner sc = new Scanner (System.in);

        System.out.println("-Añadir nuevo producto-\n");
        System.out.println("Escribe el nombre del producto:\n");
        sc.nextLine();
        nombreProducto = sc.nextLine();
        System.out.println("Ancho del producto:\n");
        sc.nextFloat();
        ancho = sc.nextFloat();
        System.out.println("Alto del producto:\n");
        sc.nextFloat();
        alto = sc.nextFloat();
        System.out.println("Precio de compra:\n");
        sc.nextFloat();
        pCompra = sc.nextFloat();
        System.out.println("El codigo de almacen:\n");
        sc.nextLine();
        codAlmacen = sc.nextLine();

        //Añado el producto al array
        addProducto(new Producto(nombreProducto, ancho, alto, pCompra, codAlmacen));
    }
    public static void menuAddUnidad(){
        int uni, año, mes, dia;
        Date fCaducidad;
        String refProducto;
        Scanner sc = new Scanner (System.in);
        
        System.out.println("-Añadir unidades de producto-\n");
        
        //System.out.println("Selecciona el producto:\n");
        //TODO: Lista de productos
        
        System.out.println("Escribe el codigo del producto a buscar:\n");
        sc.nextLine();
        refProducto = sc.nextLine();                   
        
        System.out.println("¿Cuantas unidades quieres añadir?\n");
        sc.nextInt();
        uni = sc.nextInt();

        System.out.println("Datos de la fecha de caducidad:\n");
        System.out.println("Introduce el dia de caducidad:\n");
        sc.nextInt();
        dia = sc.nextInt();
        System.out.println("Introduce el mes de caducidad:\n");
        sc.nextInt();
        mes = sc.nextInt();
        System.out.println("Introduce el año de caducidad:\n");
        sc.nextInt();
        año = sc.nextInt();

        fCaducidad= new Date(año, mes, dia);
        //Crear unidades de producto
        addUnidad(uni,new Unidad(refProducto, fCaducidad));
    }
    public static void addUnidad(int nUnidades, Unidad unidad){
        int i;
        for(i=0;i<nUnidades;i++){
            unidades.add(unidad); 
        }
    }
    public static void addProducto(Producto producto){
        productos.add(producto);
    }
    public static void addCliente(Cliente cliente){
        clientes.add(cliente);
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
