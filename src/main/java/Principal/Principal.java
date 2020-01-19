package Principal;

import GestionDeFunciones.Calculo;
import GestionDeFunciones.Lectura;
import GestionDeAlmacenes.Almacen;
import GestionDeAlmacenes.tipoAlmacen;
import GestionDeClientes.Cliente;
import GestionDeFacturas.Albaran;
import GestionDeFacturas.Factura;
import GestionDeFacturas.estadoFactura;
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
            System.out.println("3)Listar el unidades en un almacen\n"); //Completo
            System.out.println("4)Listar unidades que van a caducar\n"); //Completo
            System.out.println("5)Listar el estado de los productos\n"); //Completo
            System.out.println("6)Listar el unidades libres caducadas\n"); //Completo
            System.out.println("7)Eliminar productos caducados\n"); //Completo
            System.out.println("8)Vender producto\n");//Completo
            System.out.println("9)Registrar un nuevo cliente\n"); //Completo
            System.out.println("10)Listar productos\n");//Completo
            System.out.println("11)Añadir unidades de un producto existente\n");//Completo
            System.out.println("12)Cambiar el descuento de una unidad\n");//Completo
            System.out.println("13)Añadir un nuevo albaran\n");//Completo
            System.out.println("14)Generar factura de un albaran\n");//Completo
            System.out.println("15)Listar facturas pendientes de cobro\n");//Completo
            System.out.println("16)Listar facturas\n");//Completo
            System.out.println("17)Listar el stock de un producto\n");//Completo
            System.out.println("18)Añadir unidades de un producto\n");//Completo
            System.out.println("19)Añadir unidades a un albaran\n");//Completo
            System.out.println("20)Imprimir albaran\n");//Completo
            System.out.println("21)Imprimir factura\n");//Completo
            System.out.println("22)Listar facturas de un cliente\n");//Completo
            System.out.println("23)Listar el stock completo\n");//Completo
            System.out.println("24)Listar albaranes\n");//Completo
            System.out.println("25)Filtrar productos por precio\n");//Completo
            System.out.println("26)Listar albaranes generados en una fecha\n");//Completo
            System.out.println("27)Suma total económica de productos vendidos\n");//Completo
            System.out.println("28)Listar almacenes\n");//Completo

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
                    menuVenta();
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
                    listarFacturas();
                    break;
                case 17:
                    menuListarStockProducto();
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
                case 21:
                    menuImprimirFactura();
                    break;
                case 22:
                    menuListarFacturasCliente();
                    break;
                case 23:
                    listarStock();
                    break;
                case 24:
                    listarAlbaranes();
                    break;
                case 25:
                    menuListarProductosPorPrecio();
                    break;
                case 26:
                    menuAlbaranDeUnDia();
                    break;
                case 27:
                    System.out.println("El total vendido es: "+sumaTotalUnidadesVendidas()+"€");
                    break;
                case 28:
                    listarAlmacenes();
                    break;
                case 0:
                    salir = 1;
                    break;
            }
            System.out.println("Pulse intro para continuar:");
            Lectura.cadena();
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
    public static void listarAlmacenes(){
        for(int i=0;i<almacenes.size();i++){
            System.out.println(almacenes.get(i).toString());
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
    public static void listarUnidadesDisponibles(){
        for(int i=0;i<unidades.size();i++){
            if(unidades.get(i).getEstadoProducto().equals(estadoProducto.a)){
                System.out.println(unidades.get(i).toString());            
            }
        }
    }
    
    public static void listarStock(){
        for(int i=0;i<unidades.size();i++){
            if(unidades.get(i).getEstadoProducto().equals(estadoProducto.a)){   //Lista unidades libres
                System.out.println(unidades.get(i).toString());
            }
        }
    }
    
    public static void listarStock(Producto producto){
        for(int i=0;i<unidades.size();i++){
            if(unidades.get(i).getEstadoProducto().equals(estadoProducto.a) &&  //Lista unidades libres
                    unidades.get(i).getTipoProducto().equals(producto)){        //Lista unidades del tipo de producto
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
    public static void listarAlbaranes(){
        for(int i=0;i<albaranes.size();i++){
            System.out.println(albaranes.get(i).toString());
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
    
    public static void listarFacturasPendientes(){  //No cobradas
        for(int i=0;i<facturas.size();i++){
            if(facturas.get(i).getEstadoFactura().equals(estadoFactura.a)){
                System.out.println(facturas.get(i).toString());
            }
        }
    }

    public static void listarFacturas(){    //Todas las facturas
        for(int i=0;i<facturas.size();i++){
            System.out.println(facturas.get(i).toString());
        }
    }
    
    public static void listarFacturas(Cliente cliente){ //Del cliente seleccionado
        for(int i=0;i<facturas.size();i++){
            if(facturas.get(i).getComprador().equals(cliente)){
                System.out.println(facturas.get(i).toString());
            }
        }
    }
     
    //MENUS
    public static void menuAlbaranDeUnDia(){
        Date fecha;
        System.out.println("Introduce la fecha a buscar (dd/mm/yyyy): ");
        fecha=Lectura.fecha();
        for(int i=0;i<albaranes.size();i++){
            if(Calculo.diasDiferencia(fecha,albaranes.get(i).getfAlbaran())==0){
                System.out.println(albaranes.get(i).toString());
            }
        }
    }
    public static void menuListarProductosPorPrecio(){
        float cantidad;
        boolean opcion=false;
        
        System.out.println("--Filtrar por precio de venta--");
        System.out.println("Introduzca la cantidad seleccionada:");
        cantidad=Lectura.real();
        System.out.println("¿Listar productos con un precio mayor o menor?");
        System.out.println("0)Menor o igual");
        System.out.println("1)Mayor o igual");
        opcion=Lectura.booleanoNumerico();
        if(opcion){
            for(int i=0;i<productos.size();i++){
                if(productos.get(i).getpVenta()<=cantidad){
                    System.out.println(productos.get(i).toString());
                }
            }
        }else{
            for(int i=0;i<productos.size();i++){
                if(productos.get(i).getpVenta()>=cantidad){
                    System.out.println(productos.get(i).toString());
                }
            }
        }
    }
    public static void menuCambiarDescuentoUnidad(){
        System.out.println("Escribe el codigo del producto a buscar:\n");
        String referencia = Lectura.cadena();
        Unidad uni = buscarUnidad(referencia);
        System.out.println("Escribe el % de descuento:\n");
        int descuento = Lectura.entero();
        uni.setDescuento(descuento);
    }
    
    public static void menuMoverProducto(){
        Producto p;
        Almacen a;
        String referencia;
        int si;
        
        System.out.println("Lista de productos:");
        listarProductos();
        System.out.println("\nIntroduce el código del producto.");
        referencia=Lectura.cadena();
        p=buscarProducto(referencia);
        System.out.println("El almacen del producto es "+p.getAlmacen().getCodAlmacen());
        System.out.println("¿Desea cambiarlo?:");
        System.out.println("0) No.");
        System.out.println("1) Si.");
        si = Lectura.entero();
        if(si==1){
            System.out.println("Listado de almacenes:\n");
            listarAlmacenes();
            System.out.println("\nEscribe el codigo de referencia del almacen:\n");
            referencia = Lectura.cadena();
            a=buscarAlmacen(referencia);
            p.setAlmacen(a);
            System.out.println("El almacen ahora es : "+a.getCodAlmacen()+".\n");
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
        System.out.println("Ancho del producto (x.x):\n");
        ancho = Lectura.real();
        System.out.println("Alto del producto (x.x):\n");
        alto = Lectura.real();
        System.out.println("Precio de compra  (en €. x,x):\n");
        pCompra = Lectura.real();
        System.out.println("Los almacenes disponibles son los siguientes:\n");
        listarAlmacenes();
        System.out.println("\nEl codigo de almacen (AL-xxx):\n");
        codAlmacen = Lectura.cadena();


        addProducto(new Producto(nombreProducto, ancho, alto, pCompra, codAlmacen));
    }
    
    public static void menuListarStockProducto(){
        String referencia;
        System.out.println("El listado de productos es este:\n");
        listarProductos();
        System.out.println("Escribe el codigo del producto a listar:\n");
        referencia=Lectura.cadena();
        listarStock(buscarProducto(referencia));
    }
   
    public static void menuAddUnidad(){
        int cantidad;
        Date fCaducidad;
        String refProducto;
        
        System.out.println("-Añadir unidades de producto-\n");
        System.out.println("Lista de productos:\n");
        listarProductos();
        System.out.println("\nEscribe el codigo del producto:\n");
        refProducto = Lectura.cadena();
        System.out.println("¿Cuantas unidades quieres añadir?\n");
        cantidad = Lectura.entero();
        System.out.println("Introduce la fecha de caducidad (formato dd/mm/yyyy):\n");
        fCaducidad=Lectura.fecha();
        addUnidad(cantidad,refProducto,fCaducidad);
    }
    
    public static void menuAddUnidadesAlbaran(){
        
        System.out.println("Lista de albaranes:\n");
        listarAlbaranes();
        System.out.println("\nIntroduce la referencia del albaran:\n");
        String refAlbaran=Lectura.cadena();
        System.out.println("Lista de unidades:\n");
        listarUnidades();
        System.out.println("Introduce la referencia de la unidad a añadir:\n");
        String refUnidad=Lectura.cadena();
        buscarAlbaran(refAlbaran).addUnidad(buscarUnidad(refUnidad));
    }
    
    public static void menuImprimirAlbaran(){
        System.out.println("Lista de albaranes:\n");
        listarAlbaranes();
        System.out.println("\nIntroduce la referencia del albaran:\n");
        String referencia=Lectura.cadena();
        buscarAlbaran(referencia).imprimirAlbaran();
    }
    
    public static void menuImprimirFactura(){
        System.out.println("La lista de facturas es esta:\n");
        listarFacturas();
        System.out.println("Introduce la referencia de la factura:\n");
        String referencia=Lectura.cadena();
        buscarFactura(referencia).imprimirFactura();
    }
    
    public static String menuAddAlbaran(){
        String codCliente,refAlbaran,refUnidad;
        boolean continuar=true;
        boolean imprimir;
        Albaran albaran;
        
        System.out.println("La lista de clientes es esta:\n");
        listarCliente();
        System.out.println("Introduzca el código del cliente:\n");
        codCliente = Lectura.cadena();
        //Generamos un nuevo albaran al cliente
        refAlbaran=addAlbaran(new Albaran(codCliente));
        albaran=buscarAlbaran(refAlbaran);
        //Añadimos unidades al albaran
        while(continuar){
            System.out.println("Las unidades disponibles son estas:\n");
            listarUnidadesDisponibles();
            System.out.println("Escribe el codigo de la unidad a añadir:\n");
            refUnidad=Lectura.cadena();
            albaran.addUnidad(buscarUnidad(refUnidad));
            System.out.println("¿Quieres añadir más productos?");
            System.out.println("0) No");
            System.out.println("1) Si");
            continuar=Lectura.booleanoNumerico();
        }
        
        System.out.println("¿Desea imprimir el albarán?");
        System.out.println("0) No");
        System.out.println("1) Si");
        imprimir=Lectura.booleanoNumerico();
        if(imprimir){
            albaran.imprimirAlbaran();
        }
        return refAlbaran;
    }
    
    public static void menuAddFactura(){
        String referencia;
        System.out.println("La lista de albaranes es esta:\n");
        listarAlbaranes();
        System.out.println("Seleccione el albaran:\n");
        referencia = Lectura.cadena();
        generarFactura(referencia);
    }
    public static Factura generarFactura(String refAlbaran){
        Albaran albaran=buscarAlbaran(refAlbaran);          
        Cliente cliente=albaran.getComprador();
        cliente.reduceCredito(albaran.calcularTotal());     //Se reduce el credito del cliente.
        marcarListaVendida(albaran.getListaProductos());    //Se marcan los productos como vendidos
        Factura factura=new Factura(refAlbaran);            //Se crea la factura
        addFactura(factura);                                
        return factura;
    }
    
    public static void menuVenta(){
        boolean generar=false,imprimir=false,obs=false;
        String observaciones;
        Factura factura;
        String refAlbaran=menuAddAlbaran();
        
        System.out.println("¿Desea generar la factura?");
        System.out.println("0) No");
        System.out.println("1) Si");
        generar=Lectura.booleanoNumerico();
        if(generar){
            factura=generarFactura(refAlbaran);
            System.out.print("¿Desea añadir alguna observación?");
            System.out.println("0) No");
            System.out.println("1) Si");
            obs=Lectura.booleanoNumerico();
            if(obs){
                observaciones=Lectura.cadena();
                factura.setObservaciones(observaciones);
            }
                        
            System.out.print("¿Quiere imprimir la factura?");
            System.out.println("0) No");
            System.out.println("1) Si");
            imprimir=Lectura.booleanoNumerico();
            if(imprimir){
                factura.imprimirFactura();
            }else{
                System.out.println("Código de la factura generada: "+factura.getReferencia());
            }
        }else{
            System.out.println("Código del albarán generado: "+refAlbaran);
        }
    }
    
    public static void menuListarUnidadesEnAlmacen(){
        System.out.println("Lista de almacenes:\n");
        listarAlmacenes();
        System.out.println("\nEscribe el codigo de referencia del almacen:\n");
        String referencia = Lectura.cadena();
        listarProductosAlmacen(referencia);
    }
    
    public static void menuListarFacturasCliente(){
        String codCliente;
        Cliente cliente;
        System.out.println("La lista de clientes es esta:\n");
        listarCliente();
        System.out.println("Introduzca el código del cliente:\n");
        codCliente = Lectura.cadena();
        cliente=buscarCliente(codCliente);
        listarFacturas(cliente);
    }
    
    public static void borrarProductosCaducados(){
        for(int i=0;i<unidades.size();i++){
            if(Calculo.diasRestantes(unidades.get(i).getfCaducidad())<0){
                //Producto caducado
                eliminarUnidad(unidades.get(i).getReferencia());
            }
        }
    }
    
    public static void addUnidad(int cantidad,String refProducto,Date fCaducidad){
        for(int i=0;i<cantidad;i++){
            unidades.add(new Unidad(refProducto,fCaducidad)); 
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
    public static float sumaTotalUnidadesVendidas(){
        float total=0;
        Unidad uni;
        for(int i=0;i<unidades.size();i++){
            uni=unidades.get(i);
            if(uni.getEstadoProducto().equals(estadoProducto.b)){   //Unidades marcadas como vendidas
                total+=uni.getTipoProducto().getpVenta();           //Precio de venta del producto asociado
            }
        }
        return total;
    }
    public static void marcarListaVendida(ArrayList<Unidad> listaProductos){
        //Marcamos las unidades como vendidas
        for(int i=0;i<listaProductos.size();i++){
            listaProductos.get(i).setEstadoProducto(estadoProducto.c);
        }
    }
}
