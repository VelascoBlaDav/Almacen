package com.mycompany.almacen;

import GestionDeAlmacenes.Almacen;
import GestionDeAlmacenes.tipoAlmacen;
import GestionDeClientes.Cliente;
import GestionDeProductos.Producto;
import GestionDeProductos.Unidad;
import GestionDeProductos.estadoProducto;
import java.util.Date;
import java.util.Scanner;


public class Principal {
    private static Almacen[] almacenes = null;
    private static int n, uni, client;
    
    private static Producto[] productos = new Producto[n];
    private static Unidad unidades[] = new Unidad[uni];
    private static Cliente clientes[] = new Cliente[client];
    public static void main(String args[]){
        
        String nombreProducto, nombre, nif, direccion, referencia = null;
        float ancho, alto;
        float pCompra,credito;
        float descAplic;
        Date fCaducidad;
        String codAlmacen;//elegir el almacen al que va cada producto
        int año, mes, dia, var, i, salir = 0;
        estadoProducto estadoProducto;
        Producto p;
        //Creamos los tres almacenes de la empresa,1 de cada tipo.
        almacenes[0] = new Almacen("Seco",tipoAlmacen.a);
        almacenes[1] = new Almacen("Humedo",tipoAlmacen.b);
        almacenes[2] = new Almacen("Congelado",tipoAlmacen.c);
        
        
        
        Scanner sc = new Scanner (System.in);
        
        do{
            System.out.println("Bienvenido\n");
            System.out.println("¿Que opcion desea realizar?\n\n");
            System.out.println("0)Salir\n");
            System.out.println("1)Añadir un nuevo producto\n"); //Completo
            System.out.println("2)Cambiar de almacen a un producto\n"); 
            System.out.println("3)Listar el numero de unidades de productos en un almacen\n");
            System.out.println("4)Listar unidades de productos que van a caducar\n");
            System.out.println("5)Listar el estado de los productos\n");
            System.out.println("6)Listar el numero de productos libres caducados\n");
            System.out.println("7)Eliminar productos caducados\n");
            System.out.println("8)Vender producto\n");
            System.out.println("9)Registrar un nuevo cliente\n"); //Completo
            System.out.println("10)Listar productos\n");//Completo
            System.out.println("11)Añadir unidades de un producto existente\n");//Completo
            System.out.println("12)Añadir descuento a un producto\n");
            System.out.println("13)Añadir descuento a una unidad\n");

            int opcion = sc.nextInt();
            switch(opcion){
                case 1:
                    System.out.println("Escribe los datos del producto:\n");

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

                    for(i=0;i<n;i++){
                        if(productos[i]==null){
                            productos[i] = new Producto(nombreProducto, ancho, alto, pCompra, codAlmacen); //Creo un producto en una posicion que no esta utilizada
                            break; //una vez creo el producto salgo del bucle
                        }
                    }
                    System.out.println("¿Cuantas unidades quieres añadir al producto?\n");
                    sc.nextInt();
                    uni = sc.nextInt();

                    System.out.println("Datos de la fecha de caducidad:\n");
                    System.out.println("Introduce el año de caducidad:\n");
                    sc.nextInt();
                    año = sc.nextInt();
                    System.out.println("Introduce el mes de caducidad:\n");
                    sc.nextInt();
                    mes = sc.nextInt();
                    System.out.println("Introduce el dia de caducidad:\n");
                    sc.nextInt();
                    dia = sc.nextInt();
                    fCaducidad= new Date(año, mes, dia);
                    //Crear unidades de producto
                    for(i=0;i<uni;i++){
                        if(unidades[i]==null){
                            unidades[i] = new Unidad(nombreProducto, fCaducidad);
                            break;
                        }
                    }
                    break;
                case 2:
                    //Buscar el producto
                    //Seleccionar el nuevo tipo de almacen segun su codigo
                    //Cambiar el tipo de almacen
                    p=buscarProducto(referencia);
                    
                    break;
                case 3:
                    //
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    //Eliminar productos caducados
                    //Comprobar la fecha actual y la fecha de la unidad del producto
                    //Los productos cuya fecha sea menor a la fecha actual ponerlos a null
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
                    //Constructor de cliente
                    System.out.println("Bienvenido, añada los datos del cliente:\n");
                    System.out.println("Nombre:\n");
                    sc.nextLine();
                    nombre = sc.nextLine();
                    System.out.println("NIF:\n");
                    sc.nextLine();
                    nif = sc.nextLine();
                    System.out.println("Direccion con esta estructura:(Pais, ciudad, calle, numero, piso, letra)\n");
                    sc.nextLine();
                    direccion = sc.nextLine();
                    System.out.println("Diga su credito en euros:\n");
                    sc.nextFloat();
                    credito = sc.nextFloat();
                    for(i=0;i<client;i++){
                        if(clientes[i]!=null){
                            clientes[i] = new Cliente(nombre, nif, direccion, credito);
                            break;
                        }
                    }
                    break;
                    
                case 10:
                    listarProductos();
                    break;
                case 11:
                    System.out.println("Escribe el codigo del producto a buscar:\n");
                    sc.nextLine();
                    referencia = sc.nextLine();
                    p = buscarProducto(referencia);
                    
                    nombreProducto=p.getNombre();
                    System.out.println("¿Cuantas unidades quieres añadir al producto?\n");
                    sc.nextInt();
                    uni = sc.nextInt();

                    System.out.println("Datos de la fecha de caducidad:\n");
                    System.out.println("Introduce el año de caducidad:\n");
                    sc.nextInt();
                    año = sc.nextInt();
                    System.out.println("Introduce el mes de caducidad:\n");
                    sc.nextInt();
                    mes = sc.nextInt();
                    System.out.println("Introduce el dia de caducidad:\n");
                    sc.nextInt();
                    dia = sc.nextInt();
                    fCaducidad= new Date(año, mes, dia);
                    //Crear unidades de producto
                    for(i=0;i<uni;i++){
                        if(unidades[i]==null){
                            unidades[i] = new Unidad(nombreProducto, fCaducidad);
                            break;
                        }
                    }
                    break;
                case 12:
                    
                    break;
                case 13:
                    
                    break;
                case 0:
                    salir = 1;
                    break;

            }
        }while(salir==0);
        
        
    }
    public static Almacen buscarAlmacen(String codAlmacen ){
        for (int i=0;i<almacenes.length;i++){
            //Recorremos todos los objetos
            if(almacenes[i].getCodAlmacen()==codAlmacen){
                return almacenes[i];
            }
        }
        return null;
    }

    public static Producto buscarProducto(String referencia){
        int i;
        for (i=0;i<productos.length;i++){
            if(productos[i].getReferencia() == referencia){
                return productos[i];
            }
        }
        return null;
    }
    public static void eliminarProducto(String referencia){
        Producto p;
        p=buscarProducto(referencia);
        p=null;
    }
    public static void listarProductos(){
        int i;
        for (i=0;i<productos.length;i++){
            if(productos[i]!=null)
                productos[i].toString();
        }
    }
    public static Unidad buscarUnidad(String referencia){
        int i;
        for(i=0;i<unidades.length;i++){
            if(unidades[i].getReferencia() == referencia){
                return unidades[i];
            }
            break;
        }
        return null;
    }
    public static Cliente buscarCliente(String referencia){
        int i;
        for(i=0;i<clientes.length;i++){
            if(clientes[i].getCodCliente() == referencia){
                return clientes[i];
            }
            break;
        }
        return null;
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