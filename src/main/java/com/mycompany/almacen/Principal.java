package com.mycompany.almacen;

import java.util.Date;
import java.util.Scanner;

public class Principal {
    public static void main(String args[]){
        String referencia;
        float ancho;
        float alto;
        float pCompra;
        float descAplic;
        Date fCaducidad;
        Almacen almacen;//elegir el almacen al que va cada producto
        estadoProducto estadoProducto;
        
        Scanner sc = new Scanner (System.in);
        System.out.println("Bienvenido\n");
        System.out.println("¿Que opcion desea realizar?\n\n");
        System.out.println("1)Añadir un nuevo producto\n");
        System.out.println("2)Cambiar de almacen a un producto\n");
        System.out.println("3)Listar el numero de productos en un almacen\n");
        System.out.println("4)Listar productos que van a caducar\n");
        System.out.println("5)Listar el estado de los productos\n");
        System.out.println("6)Listar el numero de productos libres caducados\n");
        System.out.println("7)Eliminar productos caducados\n");
        System.out.println("8)Vender producto\n");
        System.out.println("9)Registrar un nuevo cliente\n");
        int opcion = sc.nextInt();
        switch(opcion){
            case 1:
                System.out.println("Escribe los datos del producto:\n");
                System.out.println("Referencia:\n");
                referencia = sc.nextLine();
                System.out.println("Ancho del producto:\n");
                ancho = sc.nextFloat();
                System.out.println("Alto del producto:\n");
                alto = sc.nextFloat();
                System.out.println("Precio de compra:\n");
                pCompra = sc.nextFloat();
                System.out.println("Fecha de caducidad:\n");
                //fCaducidad = sc.nextDate();
                System.out.println("El tipo de almacen:\n");
                //fCaducidad = sc.next();
                System.out.println("El estado del producto:\n");
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
            case 8:
                break;
            case 9:
                break;
        }
        
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
    }
}
